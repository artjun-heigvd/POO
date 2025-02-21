package engine;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.Math.max;

/**
 * Classe représentant un vecteur de déplacement
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class MoveVector {

    private final Position posFrom;
    private final Position posTo;
    private final int x;
    private final int y;

    /**
     * Constructeur de MoveVector
     *
     * @param posFrom Position de départ
     * @param posTo Position d'arrivée
     */
    public MoveVector(Position posFrom, Position posTo){
        this.posFrom = posFrom;
        this.posTo = posTo;
        this.x = posTo.getX() - posFrom.getX();
        this.y = posTo.getY() - posFrom.getY();
    }

    /**
     * @return La distance entre la position de départ et la position d'arrivée
     */
    public double magnitude(){return sqrt(x * x + y * y);}

    /**
     * @return true si le vecteur est horizontal, false sinon
     */
    public boolean isHorizontal(){return y == 0 && !isZero();}

    /**
     * @return true si le vecteur est vertical, false sinon
     */
    public boolean isVertical(){return x == 0 && !isZero();}

    /**
     * @return true si le vecteur est diagonal, false sinon
     */
    public boolean isDiag(){return abs(x) == abs(y);}

    /**
     * @return true si le vecteur est un L (mouvement du cavalier), false sinon
     */
    public boolean isL(){return (abs(x) == 1 && abs(y) == 2) || (abs(x) == 2 && abs(y) == 1);}

    /**
     * @return true si le vecteur est nul, false sinon
     */
    public boolean isZero(){return (x == 0 && y == 0);}

    /**
     * @return La position de départ
     */
    public Position getPosFrom() {return posFrom;}

    /**
     * @return La position d'arrivée
     */
    public Position getPosTo() {return posTo;}

    /**
     * @return La coordonnée x du vecteur
     */
    public int getX() {return x;}

    /**
     * @return La coordonnée y du vecteur
     */
    public int getY() {return y;}

    public MoveVector inverse(){
        return new MoveVector(posTo, posFrom);
    }

}
