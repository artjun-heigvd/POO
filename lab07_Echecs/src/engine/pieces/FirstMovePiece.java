package engine.pieces;

import chess.PlayerColor;
import engine.ChessBoard;
import engine.MoveVector;

/**
 * Classe abstraite représentant une pièce qui a un mouvement spécial
 * lors de son premier déplacement.
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public abstract class FirstMovePiece extends BlockedPiece {

    private boolean moved;

    /**
     * Constructeur de FirstMovePiece
     *
     * @param color Couleur de la pièce
     */
    public FirstMovePiece(PlayerColor color) {
        super(color);
        moved = false;
    }

    /**
     * Utile pour les pièces qui ont un premier mouvement spécial (pion, tour, roi)
     * @param move le vecteur de déplacement
     * @param board l'échiquier
     * @return Si le mouvement est valide
     */
    @Override
    protected boolean isValidMovement(MoveVector move, ChessBoard board) {
        if(validFirstMove(move, board)){
            moved = true;
            return true;
        }else {
            return false;
        }
    }

    /**
     * @param move le vecteur de déplacement
     * @param board l'échiquier
     * @return true si le premier déplacement d'une pièce est valide, false sinon
     */
    protected abstract boolean validFirstMove(MoveVector move, ChessBoard board);
    protected boolean hasMoved(){
        return moved;
    }
}
