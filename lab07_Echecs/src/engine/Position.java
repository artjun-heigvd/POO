package engine;

/**
 * Classe représentant une position sur l'échiquier
 *
 * @author Bleuer Rémy, Demont Kilian, Junod Arthur
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructeur de Position
     *
     * @param x Coordonnée x
     * @param y Coordonnée y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return La coordonnée x
     */
    public int getX() {
        return x;
    }

    /**
     * @return La coordonnée y
     */
    public int getY() {
        return y;
    }

    /**
     * Permet d'ajouter un vecteur de mouvement à une position pour la déplacer
     * @param move le vecteur de mouvement
     */
    public void addMove(MoveVector move){
        this.x += move.getX();
        this.y += move.getY();
    }
}
