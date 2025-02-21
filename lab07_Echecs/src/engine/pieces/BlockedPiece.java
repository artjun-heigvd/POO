package engine.pieces;

import chess.PlayerColor;
import engine.ChessBoard;
import engine.MoveVector;
import engine.Piece;

public abstract class BlockedPiece extends Piece {

    /**
     * Constructeur de Piece
     *
     * @param color Couleur de la pièce
     */
    public BlockedPiece(PlayerColor color) {
        super(color);
    }

    /**
     * Fonction intermédiaire qui vérifie que le mouvement ne soit pas bloqué par d'autres pièces
     * @param move le vecteur de déplacement
     * @param board l'échiquier
     * @return true si le mouvement peut être fait
     */
    @Override
    protected boolean moveValid(MoveVector move, ChessBoard board) {
        return isValidMovement(move, board) && board.isPathFree(move);
    }

    protected abstract boolean isValidMovement(MoveVector move, ChessBoard board);
}
