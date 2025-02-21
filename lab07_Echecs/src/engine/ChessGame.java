package engine;

import chess.ChessController;
import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;
import engine.pieces.*;

/**
 * Classe qui gère le jeu d'échec
 * Implémente l'interface ChessController
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class ChessGame implements ChessController {

    private ChessView view;
    private ChessBoard board;
    private PlayerColor currentPlayer;

    /**
     * Constructeur de ChessGame
     *
     * @param view Vue du jeu
     */
    @Override
    public void start(ChessView view) {
        this.view = view;
        view.startView();
    }

    /**
     * Méthode qui gère le déplacement des pièces
     *
     * @param fromX Coordonnée x de départ
     * @param fromY Coordonnée y de départ
     * @param toX   Coordonnée x d'arrivée
     * @param toY   Coordonnée y d'arrivée
     * @return true si le déplacement est valide, false sinon
     */
    @Override
    public boolean move(int fromX, int fromY, int toX, int toY) {

        Position posFrom = new Position(fromX, fromY);
        Position posTo = new Position(toX, toY);
        MoveVector move = new MoveVector(posFrom, posTo);

        if(board != null && board.getPieceAt(move.getPosFrom()) != null &&
                board.getPieceAt(move.getPosFrom()).getColor() == currentPlayer) {
            if (canCastleBePerformed(move)) {
                return performCastling(move);
            }

            if (board.getPieceAt(move.getPosFrom()).canMove(move, board)) {

                if (board.check == currentPlayer) {
                    return checkMoveSavesKing(move);
                } else {
                    moveAndEat(move);
                }

                isThereCheck();

                performPawnPromotion(posTo);

                switchPlayer();
                return true;
            }
        }
        view.displayMessage("Move is invalid !");
        return false;

    }

    /**
     * Méthode qui gère la promotion du pion
     *
     * @param pos de la pièce
     */
    public void performPawnPromotion(Position pos){

        if (board.canPromote(pos)) {
            Piece newPiece = null;
            while (newPiece == null) {
                newPiece = view.askUser(
                        "Promotion",
                        "Quel est votre choix ?",
                        new Bishop(currentPlayer),
                        new Knight(currentPlayer),
                        new Queen(currentPlayer),
                        new Rook(currentPlayer)
                );
            }

            board.replacePiece(pos, newPiece);
            view.putPiece(board.getPieceAt(pos).getType(), board.getPieceAt(pos).getColor(), pos.getX(), pos.getY());
        }
    }

    /**
     * Méthode qui vérifie si le roque peut être effectué
     *
     * @param move Vecteur de déplacement
     * @return true si le roque peut être effectué, false sinon
     */
    private boolean canCastleBePerformed(MoveVector move) {
        return move.magnitude() == 2 &&
                board.getPieceAt(move.getPosFrom()).getType() == PieceType.KING &&
                board.check != currentPlayer;
    }

    /**
     * Méthode qui effectue le roque
     *
     * @param move Vecteur de déplacement
     * @return true si le roque a été effectué, false sinon
     */
    public boolean performCastling(MoveVector move) {

        //Vérification du roque
        boolean kingside = move.getPosTo().getX() > move.getPosFrom().getX();
        if (((King) board.getPieceAt(move.getPosFrom())).canCastle(board, kingside) &&
                board.getPieceAt(move.getPosFrom()).canMove(move, board)) {
            // Éffectue le roque
            int rookFromX = kingside ? 7 : 0;
            int rookToX = kingside ? 5 : 3;
            Position rookPosFrom = new Position(rookFromX, move.getPosFrom().getY());
            Position rookPosTo = new Position(rookToX, move.getPosFrom().getY());
            MoveVector moveRook = new MoveVector(rookPosFrom, rookPosTo);

            board.movePiece(moveRook, null);
            updateView(moveRook);
            board.movePiece(move, null);
            updateView(move);
            board.kingsPos[currentPlayer.ordinal()].addMove(move);
            switchPlayer();
            return true;
        }else{
            return false;
        }
    }

    /**
     * Méthode qui effectue la prise en passant
     *
     * @param move Mouvement effectué
     */
    public void moveAndEat(MoveVector move) {

        Position posTo = move.getPosTo();
        Position posFrom = move.getPosFrom();

        Position enPassantTarget = board.enPassantTarget;

        if (board.getPieceAt(posTo) != null) {
            board.eatPiece(posTo);
            this.view.removePiece(posTo.getX(), posTo.getY());
        } else if (board.getPieceAt(posFrom).getType() == PieceType.PAWN && enPassantTarget != null
                && posTo.getX() == enPassantTarget.getX() && posTo.getY() == enPassantTarget.getY()) {
            board.eatPiece(new Position(posTo.getX(), posTo.getY() - ((Pawn) board.getPieceAt(posFrom)).getDir()));
            this.view.removePiece(posTo.getX(), posTo.getY() - ((Pawn) board.getPieceAt(posFrom)).getDir());
        }

        board.movePiece(move, null);
        updateView(move);
    }

    /**
     * Méthode qui vérifie si le déplacement ne met pas le roi en danger
     *
     * @param move Mouvement demandé
     * @return true si le déplacement met le roi en danger, false sinon
     */
    private boolean checkMoveSavesKing(MoveVector move) {

        Piece valCellTo = board.movePiece(move, null);
        if (board.getPieceAt(board.attackerPos).canMove(new MoveVector(board.attackerPos, board.getKingPos(currentPlayer)), board)) {
            board.movePiece(move.inverse(), valCellTo);
            view.displayMessage("You must save the king !");
            return false;
        } else {
            updateView(move);
            board.check = null;
            board.attackerPos = null;
            switchPlayer();
            return true;
        }
    }

    /**
     * Vérifie si le board est en état d'échec
     */
    public void isThereCheck() {

        PlayerColor enemyColor = currentPlayer == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
        Position posAttack;
        if ((posAttack = board.findAttackerPos(board.getKingPos(enemyColor), enemyColor)) != null) {
            board.attackerPos = posAttack;
            view.displayMessage("Check!");
            if (currentPlayer == PlayerColor.WHITE) {
                board.check = PlayerColor.BLACK;
            } else {
                board.check = PlayerColor.WHITE;
            }
        }
    }

    /**
     * Méthode qui gère le début d'une nouvelle partie
     */
    @Override
    public void newGame() {
        board = new ChessBoard();
        currentPlayer = PlayerColor.WHITE;
        setStartBoard();
    }

    /**
     * Méthode qui affiche le plateau de jeu en début de partie
     */
    private void setStartBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = board.getPieceAt(new Position(x, y));
                if (piece != null) {
                    view.putPiece(piece.getType(), piece.getColor(), x, y);
                }
            }
        }
    }

    /**
     * Méthode qui met à jour l'affichage du plateau de jeu
     *
     * @param move Mouvement demandé
     */
    private void updateView(MoveVector move) {
        // Supprimer la pièce
        view.removePiece(move.getPosFrom().getX(), move.getPosFrom().getY());
        // Màj position finale
        Piece movedPiece = board.getPieceAt(move.getPosTo());
        if (movedPiece != null)
            view.putPiece(movedPiece.getType(), movedPiece.getColor(), move.getPosTo().getX(), move.getPosTo().getY());
    }

    /**
     * Méthode qui gère le changement de joueur
     */
    private void switchPlayer() {
        currentPlayer = (currentPlayer == PlayerColor.WHITE) ? PlayerColor.BLACK : PlayerColor.WHITE;
    }


}