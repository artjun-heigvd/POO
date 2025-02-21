package engine;

import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;

/**
 * Classe abstraite représentant une pièce d'échec.
 * Implémente l'interface UserChoice pour permettre
 * à l'utilisateur de choisir une pièce (lors de la promotion).
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public abstract class Piece implements ChessView.UserChoice {

    private final PlayerColor color;

    /**
     * Constructeur de Piece
     *
     * @param color Couleur de la pièce
     */
    public Piece(PlayerColor color){
        this.color = color;
    }

    /**
     * Utilise la méthode isValidMovement pour vérifier si le déplacement est valide
     * On vérifie également à ce niveau que le mouvement ne soit pas nul et qu'il ne mette pas le roi en danger
     * @param move le vecteur de déplacement
     * @param board l'échiquier
     * @return true si le déplacement est valide, false sinon
     */
    public boolean canMove(MoveVector move, ChessBoard board){
        return !move.isZero() && moveValid(move, board) && !board.putKingInDanger(move, getColor());
    }

    /**
     * @param move le vecteur de déplacement
     * @param board l'échiquier
     * @return true si le déplacement est valide, false sinon
     */
    protected abstract boolean moveValid(MoveVector move, ChessBoard board);

    /**
     * @return La couleur de la pièce/joueur
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * @return Le type de la pièce
     */
    public abstract PieceType getType();
}
