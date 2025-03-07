package App;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JFileChooser;

import modele.Carte;
import modele.Hero;
import controleur.Deplacement;
import vue.VueCarte;
/**
 * Constructeur par défaut de la classe App.
 * 
 * <p>
 * Ce constructeur initialise l'application sans paramètres, et il peut être utilisé dans des tests ou des scénarios
 * où l'initialisation de l'application se fait sans paramètres spécifiques.
 * </p>
 */
public class App {
	/**
	 * Méthode principale qui démarre l'application.
	 * @param args Arguments de la ligne de commande
	 */
    public static void main(String[] args) {
        try {
            // Sélection du fichier de configuration
            File fichierConfig = selectionnerFichier("Sélectionner le fichier de configuration");
            if (fichierConfig == null) {
                System.out.println("Aucun fichier de configuration sélectionné.");
                return;
            }

            // Sélection du fichier de carte
            File fichierCarte = selectionnerFichier("Sélectionner le fichier de la carte");
            if (fichierCarte == null) {
                System.out.println("Aucun fichier de carte sélectionné.");
                return;
            }

            // Lecture du fichier de configuration
            List<String> lignes = Files.readAllLines(Paths.get(fichierConfig.getAbsolutePath()));
            if (lignes.size() < 2) {
                System.out.println("Fichier de configuration invalide !");
                return;
            }

            // Extraction des coordonnées initiales
            String[] coords = lignes.get(0).split(",");
            int x = Integer.parseInt(coords[0].trim());
            int y = Integer.parseInt(coords[1].trim());

            // Récupération des mouvements
            String mouvements = lignes.get(1).trim();
            System.out.println("Mouvements lus : " + mouvements);


            // Chargement de la carte
            Carte carte = new Carte(fichierCarte.getAbsolutePath());

            if (!carte.estAccessible(x, y)) {
                System.out.println("Erreur : La position initiale du héros est sur un obstacle !");
                return; // Le programme s'arrête si la position est invalide
            }
            
            // Initialisation du héros et des déplacements
            Hero hero = new Hero(x, y);
            VueCarte vueCarte = new VueCarte();
            Deplacement deplacement = new Deplacement(carte, hero, vueCarte);

            // Affichage de la carte initiale
            vueCarte.afficherCarte(carte, hero);
            
            //Affichage position initiale
            System.out.println("Position actuelle : (" + hero.getX() +", " + hero.getY()+")");
            // Exécution des mouvements
            for (char direction : mouvements.toCharArray()) {
                deplacement.deplacer(direction);
                System.out.println("Déplacement : " + direction + " → Position actuelle : (" + hero.getX() + ", " + hero.getY() + ")");

            }

            // Affichage du résultat
            System.out.println("Carte après déplacements :");
            vueCarte.afficherCarte(carte, hero);
            System.out.println("Position finale : (" + hero.getX() + ", " + hero.getY() + ")");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur : format des coordonnées invalide !");
        }
    }

    /**
     * Méthode permettant à l'utilisateur de sélectionner un fichier via une boîte de dialogue.
     * @param titre Le titre de la boîte de dialogue.
     * @return Le fichier sélectionné ou null si aucun fichier n'a été choisi.
     */
    private static File selectionnerFichier(String titre) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(titre);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
}
