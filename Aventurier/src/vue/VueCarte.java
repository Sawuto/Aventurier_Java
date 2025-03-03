package vue;

import modele.Carte;
import modele.Hero;
/**
 * Classe responsable de l'affichage de la carte et du héros.
 */
public class VueCarte {
	/**
     * Affiche la carte avec la position du héros.
     * @param carte La carte du jeu
     * @param hero Le héros à afficher
     */
	public void afficherCarte(Carte carte, Hero hero) {
        char[][] grille = carte.getCarte();
        for (int y = 0; y < carte.getHauteur(); y++) {
            for (int x = 0; x < carte.getLargeur(); x++) {
                if (x == hero.getX() && y == hero.getY()) {
                    System.out.print("P"); // Affiche le personnage
                } else {
                    System.out.print(grille[y][x]);
                }
            }
            System.out.println();
        }
    }
}

