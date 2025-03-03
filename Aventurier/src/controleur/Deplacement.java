package controleur;

import modele.Carte;
import modele.Hero;

/**
 * Gère les déplacements du héros sur la carte.
 */
public class Deplacement {
    private Carte carte;
    private Hero hero;

    /**
     * Constructeur du gestionnaire de déplacement.
     * @param carte La carte du jeu
     * @param hero Le héros qui se déplace
     */
    public Deplacement(Carte carte, Hero hero) {
        this.carte = carte;
        this.hero = hero;
    }

    /**
     * Déplace le héros dans la direction donnée (N, S, E, O).
     * @param direction Direction du déplacement ('N' = Nord, 'S' = Sud, 'E' = Est, 'O' = Ouest)
     */
    public void deplacer(char direction) {
        int X = hero.getX();
        int Y = hero.getY();

        switch (direction) {
            case 'N':
            	Y--; 
            	break;
            case 'S': 
            	Y++; 
            	break;
            case 'E': 
            	X++; 
            	break;
            case 'O': 
            	X--;
            	break;
            default:
                System.out.println("Direction invalide : " + direction);
                return;
        }

        if (carte.estAccessible(X, Y)) {
            hero.setPosition(X, Y);
        }
    }
}