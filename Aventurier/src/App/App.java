package App;

import java.io.IOException;
import modele.Carte;
import modele.Hero;
import controleur.Deplacement;
import vue.VueCarte;

public class App {
    public static void main(String[] args) {
        try {
            Carte carte = new Carte("/home/enzos/Téléchargements/carte.txt");
            Hero hero = new Hero(3, 0);
            Deplacement deplacement = new Deplacement(carte, hero);
            VueCarte vue = new VueCarte();

            String mouvements = "SSSSEEEEEENN";
            for (char direction : mouvements.toCharArray()) {
            	deplacement.deplacer(direction);
            }

            System.out.println("Carte après déplacements :");
            vue.afficherCarte(carte, hero);

            System.out.println("Position finale : (" + hero.getX() + ", " + hero.getY() + ")");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
