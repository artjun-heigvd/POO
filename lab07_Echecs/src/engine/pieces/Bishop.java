package engine.pieces;

import chess.PieceType;
import engine.ChessBoard;
import chess.PlayerColor;
import engine.MoveVector;

/**
 * Classe représentant le fou
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class Bishop extends BlockedPiece {

    public Bishop(PlayerColor color){
        super(color);
    }

    @Override
    protected boolean isValidMovement(MoveVector move, ChessBoard board){
        return board.isCellAccessible(move.getPosTo(), getColor()) && move.isDiag();
    }

    @Override
    public PieceType getType() {
        return PieceType.BISHOP;
    }

    @Override
    public String textValue() {
        return "Bishop";
    }
}
