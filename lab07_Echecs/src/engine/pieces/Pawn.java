package engine.pieces;

import chess.PieceType;
import chess.PlayerColor;
import engine.ChessBoard;
import engine.MoveVector;
import engine.Position;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Classe représentant le pion
 * Elle hérite de FirstMovePiece car le pion peut faire un premier mouvement de 2 cases
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class Pawn extends FirstMovePiece {
    private final int dirPawn;

    public Pawn(PlayerColor color) {
        super(color);
        dirPawn = color == PlayerColor.WHITE ? 1 : -1;
    }

    @Override
    public PieceType getType() {
        return PieceType.PAWN;
    }

    protected boolean validFirstMove(MoveVector move, ChessBoard board) {

        int dir = Integer.signum(move.getY());
        int distAccepted = hasMoved() ? 1 : 2;
        Position posTo = move.getPosTo();

        if(dir == dirPawn) {
            if (move.isVertical() && move.magnitude() <= distAccepted &&
                !board.cellNotEmpty(posTo)) {
                // En passant
                if (move.magnitude() == 2) {
                    board.enPassantTarget = new Position(posTo.getX(), posTo.getY() - dirPawn);
                } else {
                    board.enPassantTarget = null;
                }
                return true;
            } else if(move.isDiag() && abs(move.magnitude() - sqrt(2)) <= 0.00001) {
                if(board.cellNotEmpty(posTo) && getColor() != board.getPieceAt(posTo).getColor()){
                    return true;
                }else{
                    return board.enPassantTarget != null &&
                            board.enPassantTarget.getX() == posTo.getX() &&
                            board.enPassantTarget.getY() == posTo.getY() &&
                            board.getPieceAt(new Position(posTo.getX(), posTo.getY() - dirPawn)).getColor() != getColor();
                }
            }
        }
        return false;
    }

    public int getDir(){
        return dirPawn;
    }

    @Override
    public String textValue() {
        return "Pawn";
    }
}
