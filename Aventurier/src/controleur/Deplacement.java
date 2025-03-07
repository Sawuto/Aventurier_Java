package controleur;

import modele.Carte;
import modele.Hero;
import vue.VueCarte;

/**
 * Gère les déplacements du héros sur la carte.
 * Permet de déplacer le héros dans les directions Nord, Sud, Est, Ouest,
 * en vérifiant si la case cible est accessible.
 */
public class Deplacement {
    private Carte carte;
    private Hero hero;
    private VueCarte vueCarte;

    /**
     * Constructeur du gestionnaire de déplacements.
     * @param carte La carte du jeu, utilisée pour vérifier si un déplacement est possible
     * @param hero Le héros qui se déplace sur la carte
     * @param vueCarte Vue de la carte, utilisée pour afficher l'état actuel après chaque déplacement
     */
    public Deplacement(Carte carte, Hero hero, VueCarte vueCarte) {
        this.carte = carte;
        this.hero = hero;
        this.vueCarte = vueCarte;
    }

    /**
     * Déplace le héros dans la direction donnée.
     * Les directions possibles sont :
     * 'N' : Nord (décroît la coordonnée Y)
     * 'S' : Sud (augmente la coordonnée Y)
     * 'E' : Est (augmente la coordonnée X)
     * 'O' : Ouest (décroît la coordonnée X)
     * 
     * Si la case cible est inaccessible (obstacle), le déplacement est ignoré.
     * @param direction La direction du déplacement ('N' pour Nord, 'S' pour Sud, 'E' pour Est, 'O' pour Ouest)
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
            vueCarte.afficherCarte(carte, hero);
        }
    }
}