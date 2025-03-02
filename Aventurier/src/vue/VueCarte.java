package vue;

import modele.Carte;
import modele.Hero;

public class VueCarte {
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

