package engine.pieces;

import chess.PieceType;
import engine.ChessBoard;
import engine.MoveVector;
import chess.PlayerColor;

/**
 * Classe représentant la tour
 * Elle hérite de FirstMovePiece car la tour peut faire un roque
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class Rook extends FirstMovePiece {

    public Rook(PlayerColor color) {
        super(color);
    }

    @Override
    protected boolean validFirstMove(MoveVector move, ChessBoard board) {
        return board.isCellAccessible(move.getPosTo(), getColor()) && (move.isVertical() || move.isHorizontal());
    }

    @Override
    public PieceType getType() {
        return PieceType.ROOK;
    }

    @Override
    public String textValue() {
        return "Rook";
    }
}
