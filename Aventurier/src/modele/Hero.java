package modele;

/**
 * Représente un héros qui peut se déplacer sur la carte.
 * Le héros possède une position (x, y) et peut se déplacer dans les 4 directions cardinales.
 */
public class Hero {

    protected int x; // Coordonnée X du héros
    protected int y; // Coordonnée Y du héros

    /**
     * Constructeur du héros avec des coordonnées initiales.
     * @param x Position initiale en X
     * @param y Position initiale en Y
     */
    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Récupère la position actuelle du héros en X.
     * @return Coordonnée X du héros
     */
    public int getX() {
        return x;
    }

    /**
     * Met à jour la position du héros en X.
     * @param x Nouvelle coordonnée X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Récupère la position actuelle du héros en Y.
     * @return Coordonnée Y du héros
     */
    public int getY() {
        return y;
    }

    /**
     * Met à jour la position du héros en Y.
     * @param y Nouvelle coordonnée Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Met à jour simultanément la position du héros en X et Y.
     * @param x Nouvelle coordonnée X
     * @param y Nouvelle coordonnée Y
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
