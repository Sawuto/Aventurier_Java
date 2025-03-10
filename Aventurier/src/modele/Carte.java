package modele;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Représente une carte 2D chargée depuis un fichier texte.
 * La carte est constituée d'un tableau de caractères où chaque caractère représente une case.
 */
public class Carte {
    private char[][] carte;
    private int hauteur, largeur;

    /**
     * Constructeur : Charge la carte depuis un fichier texte.
     * @param fichierCarte Chemin du fichier contenant la carte
     * @throws IOException si le fichier ne peut être lu
     */
    public Carte(String fichierCarte) throws IOException {
        List<String> lignes = Files.readAllLines(Paths.get(fichierCarte));
        hauteur = lignes.size();
        largeur = lignes.get(0).length();
        carte = new char[hauteur][largeur];

        for (int i = 0; i < hauteur; i++) {
            carte[i] = lignes.get(i).toCharArray();
        }
    }

    /**
     * Vérifie si une position donnée est accessible (espace vide ' ').
     * @param x Coordonnée X
     * @param y Coordonnée Y
     * @return true si le déplacement est possible, false sinon
     */
    public boolean estAccessible(int x, int y) {
        if (x < 0 || y < 0 || x >= largeur || y >= hauteur) {
            return false; // Hors des limites de la carte
        }
        return carte[y][x] == ' ';
    }

    /**
     * Récupère la largeur de la carte.
     * @return La largeur en nombre de colonnes
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Récupère la hauteur de la carte.
     * @return La hauteur en nombre de lignes
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Récupère la carte sous forme de tableau 2D.
     * @return Un tableau 2D représentant la carte
     */
    public char[][] getCarte() {
        return carte;
    }

}
