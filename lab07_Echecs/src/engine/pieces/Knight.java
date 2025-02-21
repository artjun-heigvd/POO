package engine.pieces;

import chess.PieceType;
import engine.ChessBoard;
import engine.Piece;
import engine.MoveVector;
import chess.PlayerColor;


/**
 * Classe représentant le cavalier
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class Knight extends Piece {

    public Knight(PlayerColor color){
        super(color);
    }

    @Override
    protected boolean moveValid(MoveVector move, ChessBoard board){
        return board.isCellAccessible(move.getPosTo(), getColor()) && move.isL();
    }

    @Override
    public PieceType getType() {
        return PieceType.KNIGHT;
    }

    @Override
    public String textValue() {
        return "Knight";
    }
}
