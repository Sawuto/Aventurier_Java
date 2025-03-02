package App;

import java.io.IOException;
import modele.Carte;
import modele.Hero;
import controleur.Deplacement;

public class App {
    public static void main(String[] args) {
        try {
            Carte carte = new Carte("/home/enzos/Téléchargements/carte.txt");
            Hero hero = new Hero(3, 0);
            Deplacement controleur = new Deplacement(carte, hero);

            String mouvements = "SSSSEEEEEENN";
            for (char direction : mouvements.toCharArray()) {
                controleur.deplacer(direction);
            }
            
            System.out.println("Position finale : (" + hero.getX() + ", " + hero.getY() + ")");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
