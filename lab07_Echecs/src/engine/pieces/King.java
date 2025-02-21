package engine.pieces;

import chess.PieceType;
import engine.ChessBoard;
import chess.PlayerColor;
import engine.MoveVector;
import engine.Piece;
import engine.Position;

import static java.lang.Math.sqrt;
import static java.lang.Math.abs;


/**
 * Classe représentant le roi
 * Elle hérite de FirstMovePiece car le roi peut faire un roque
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class King extends FirstMovePiece {

    public King(PlayerColor color){
        super(color);
    }

    @Override
    protected boolean validFirstMove(MoveVector move, ChessBoard board) {
        if(!hasMoved() && (move.magnitude() == 1 || abs(move.magnitude() - sqrt(2)) <= 0.00001 || (move.magnitude() == 2
                && move.isHorizontal())) && board.isCellAccessible(move.getPosTo(), getColor())){
            board.kingsPos[getColor().ordinal()].addMove(move);
            return true;
        }else if((move.magnitude() == 1 || abs(move.magnitude() - sqrt(2)) <= 0.00001)
                && board.isCellAccessible(move.getPosTo(), getColor())){
            board.kingsPos[getColor().ordinal()].addMove(move);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public PieceType getType() {
        return PieceType.KING;
    }

    /**
     * Vérifie si le roi peut faire un roque
     * @param board l'échiquier
     * @param kingside true si c'est un petit roque, false si c'est un grand roque
     * @return true si le roi peut faire un roque, false sinon
     */
    public boolean canCastle(ChessBoard board, boolean kingside) { // kingside = petit roque
        if (hasMoved()) {
            return false;
        }

        int rank = getColor() == PlayerColor.WHITE ? 0 : 7;
        int rookX = kingside ? 7 : 0;

        Position rookPosFrom = new Position(rookX, rank);

        // Vérifier si la tour et le roi n'ont pas bougé
        Piece rook = board.getPieceAt(rookPosFrom);
        if (rook != null && rook.getType() == PieceType.ROOK && ((Rook) rook).hasMoved()) {
            return false;
        }

        // Vérifier si les cases entre le roi et la tour sont vides
        MoveVector pathRook = new MoveVector(board.kingsPos[getColor().ordinal()], rookPosFrom);
        return board.isPathFree(pathRook) && !board.areCellsDangerous(pathRook, getColor());
    }

    @Override
    public String textValue() {
        return "King";
    }
}
