package engine;

import chess.PieceType;
import chess.PlayerColor;
import engine.pieces.*;

import static chess.PlayerColor.*;
import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * Classe représentant l'échiquier, les restrictions de mouvements et les pièces
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class ChessBoard {

    private static final Position START_POS_KING_WHITE = new Position(4, 0);
    private static final Position START_POS_KING_BLACK = new Position(4, 7);
    private static final int BOARD_SIZE = 8;

    public Position enPassantTarget;
    public Position[] kingsPos;
    private final Piece[][] board;
    Position attackerPos;
    PlayerColor check;


    /**
     * Constructeur de ChessBoard
     */
    public ChessBoard() {
        board = new Piece[BOARD_SIZE][BOARD_SIZE];
        check = null;
        attackerPos = null;
        enPassantTarget = null;
        kingsPos = new Position[]{START_POS_KING_WHITE, START_POS_KING_BLACK};
        initializeGame();
    }

    /**
     * Initialise les différentes parties de l'échiquier
     */
    public void initializeGame() {
        check = null;
        attackerPos = null;
        enPassantTarget = null;
        kingsPos = new Position[]{START_POS_KING_WHITE, START_POS_KING_BLACK};
        initBackRow(WHITE, 0);
        initPawns(WHITE, 1);
        initEmptySlots();
        initPawns(BLACK, 6);
        initBackRow(BLACK, 7);
    }

    /**
     * Initialise la rangée de pièces arrière
     * (tour, cavalier, fou, dame, roi, fou, cavalier, tour)
     *
     * @param color couleur des pièces/joueur
     * @param row   rangée
     */
    private void initBackRow(PlayerColor color, int row) {
        Piece[] pieces = {
                new Rook(color),
                new Knight(color),
                new Bishop(color),
                new Queen(color),
                new King(color),
                new Bishop(color),
                new Knight(color),
                new Rook(color)
        };

        System.arraycopy(pieces, 0, board[row], 0, BOARD_SIZE);

    }

    /**
     * Initialise la rangée de pions
     *
     * @param color couleur des pions/joueur
     * @param row   rangée
     */
    private void initPawns(PlayerColor color, int row) {
        for (int i = 0; i < BOARD_SIZE; i++)
            board[row][i] = new Pawn(color);
    }

    /**
     * Initialise les cases vides
     */
    private void initEmptySlots() {
        for (int i = 2; i <= 5; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = null;
    }

    /**
     * @param pos position de la pièce à récuperer
     * @return la pièce à la position (x, y)
     */
    public Piece getPieceAt(Position pos) {
        if (pos.getX() < 0 || pos.getX() >= BOARD_SIZE || pos.getY() < 0 || pos.getY() >= BOARD_SIZE) {
            return null;
        }
        return board[pos.getY()][pos.getX()];
    }

    /**
     * Méthode qui vérifie si la case est accessible par une pièce
     *
     * @param pos position
     * @return true si la case est accessible, false sinon
     */
    public boolean isCellAccessible(Position pos, PlayerColor color){
        if(pos.getY() >= BOARD_SIZE || pos.getX() >= BOARD_SIZE){
            return false;
        }

        // Position en passant
        if (pos.equals(enPassantTarget)) {
            return true;
        }

        return board[pos.getY()][pos.getX()] == null || board[pos.getY()][pos.getX()].getColor() != color;
    }

    /**
     * @param pos position à verifier
     * @return true si la case n'est pas vide, false sinon
     */
    public boolean cellNotEmpty(Position pos){
        if(pos.getY() >= BOARD_SIZE || pos.getX() >= BOARD_SIZE){
            return false;
        }
        return board[pos.getY()][pos.getX()] != null;
    }

    /**
     * Supprime la pièce à la position pos
     *
     * @param pos la position de la pièce
     */
    public void eatPiece(Position pos){
        board[pos.getY()][pos.getX()] = null;
    }

    /**
     * Remplace la pièce à la position (x, y) par newPiece
     *
     * @param pos position de la pièce à remplacer
     * @param newPiece la nouvelle pièce
     */
    public void replacePiece(Position pos, Piece newPiece) {
        this.board[pos.getY()][pos.getX()] = newPiece;
    }


    /**
     * Trouve la première piece qui peut attaquer une cellule donnée
     * @param pos position de la cellule à tester
     * @param color couleur contre laquelle on veut tester l'attaque
     * @return la position de l'attaquant si trouvé sinon null
     */
    public Position findAttackerPos(Position pos, PlayerColor color){
        for(int x = 0; x < BOARD_SIZE; ++x){
            for(int y = 0; y < BOARD_SIZE; ++y){
                Piece piece = getPieceAt(new Position(x, y));
                if(piece != null && piece.getColor() != color &&
                        piece.canMove(new MoveVector(new Position(x, y), pos), this)){
                    return new Position(x, y);
                }
            }
        }
        return null;
    }

    /**
     * @param color couleur du joueur
     * @return la position du roi du joueur
     */
    public Position getKingPos(PlayerColor color) {
        return kingsPos[color.ordinal()];
    }

    /**
     * Verifie si le mouvement que l'on va éffectuer va mettre en danger le roi
     * @param move mouvement à tester
     * @param color couleur de la piece que l'n veut bouger (donc également
     *             du roi que l'on peut mettre en danger)
     * @return true si on met en danger le roi
     */
    public boolean putKingInDanger(MoveVector move, PlayerColor color){
        Piece valCellTo = movePiece(move, null);
        Position king = getKingPos(color);
        for(int x = 0; x < BOARD_SIZE; ++x){
            for(int y = 0; y < BOARD_SIZE; ++y){
                Piece piece = getPieceAt(new Position(x, y));
                if(piece != null && piece.getColor() != color &&
                        piece.canMove(new MoveVector(new Position(x, y), king), this)){
                    movePiece(move.inverse(), valCellTo);
                    return true;
                }
            }
        }
        movePiece(move.inverse(), valCellTo);
        return false;
    }

    /**
     * @param pos position de la pièce à promouvoir
     * @return true s'il est possible de promouvoir le pion, false sinon
     */
    public boolean canPromote(Position pos) {
        return (getPieceAt(pos).getType() == PieceType.PAWN) && (pos.getY() == 0 || pos.getY() == 7);
    }


    /**
     * Permet de trouver toutes les cases qui se trouvent entre l'arrivée et le départ d'un mouvement
     * @param move mouvement duquel on tire les cases
     * @return les cases entre l'arrivée et le départ sous forme de tableau de position
     */
    private Position[] getCellsFromMove(MoveVector move){

        int dirX = Integer.signum(move.getX());
        int dirY = Integer.signum(move.getY());

        int max = max(abs(move.getX()), abs(move.getY()));

        Position[] positions = new Position[max - 1];

        for(int i = 1; i < max; ++i){
            positions[i - 1] = new Position(move.getPosFrom().getX() + (i * dirX), move.getPosFrom().getY() + (i * dirY));
        }

        return positions;
    }

    /**
     * Verifie si les cases travérsée lors d'un mouvement peuvent être attaquée
     * @param move mouvement à tester
     * @param color couleur de la pièce qui se déplace
     * @return true si une des cases est dangereuse
     */
    public boolean areCellsDangerous(MoveVector move, PlayerColor color){
        for(Position pos : getCellsFromMove(move)) {
            if(pos != null && findAttackerPos(pos, color) != null){
                return true;
            }
        }
        return false;
    }

    /**
     * Permet de savoir si un mouvement ne traverse pas une piece
     * @param move mouvement à tester
     * @return true si toutes le cases sont vides
     */
    public boolean isPathFree(MoveVector move){
        for(Position pos : getCellsFromMove(move)){
            if(pos != null && cellNotEmpty(pos)){
                return false;
            }
        }
        return true;
    }

    /**
     * Bouge la pièce mais permet également de définir la valeur de la case que l'on quitte et de récupérer la valeur
     * de la case sur laquelle on arrive (utile pour simuler des mouvements)
     * @param move mouvement à effectuer
     * @param valCellFrom valeur que l'on va donner à la case que l'on quitte
     * @return la valeur de la case que sur laquelle on arrive
     */
    public Piece movePiece(MoveVector move, Piece valCellFrom){

        Position posTo = move.getPosTo();
        Position posFrom = move.getPosFrom();

        Piece temp = board[posTo.getY()][posTo.getX()];
        board[posTo.getY()][posTo.getX()] = board[posFrom.getY()][posFrom.getX()];
        board[posFrom.getY()][posFrom.getX()] = valCellFrom;
        return temp;
    }
}
