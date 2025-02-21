package engine.pieces;

import chess.PieceType;
import chess.PlayerColor;
import engine.ChessBoard;
import engine.MoveVector;

/**
 * Classe représentant la reine
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class Queen extends BlockedPiece {
    public Queen(PlayerColor color) {
        super(color);
    }

    @Override
    protected boolean isValidMovement(MoveVector move, ChessBoard board){
        return board.isCellAccessible(move.getPosTo(), getColor()) && (move.isHorizontal() || move.isDiag() || move.isVertical());
    }

    @Override
    public PieceType getType() {
        return PieceType.QUEEN;
    }

    @Override
    public String textValue() {
        return "Queen";
    }
}
