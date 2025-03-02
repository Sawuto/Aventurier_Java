package controleur;

import modele.Carte;
import modele.Hero;

public class Deplacement {
    private Carte carte;
    private Hero hero;

    public Deplacement(Carte carte, Hero hero) {
        this.carte = carte;
        this.hero = hero;
    }

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
        }

        if (carte.estAccessible(X, Y)) {
            hero.setPosition(X, Y);
        }
    }
}