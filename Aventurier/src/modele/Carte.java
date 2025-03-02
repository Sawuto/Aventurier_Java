package modele;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Carte {
    private char[][] carte;
    private int hauteur, largeur;

    /**
     * Constructeur : Charge la carte depuis un fichier texte
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
     * Vérifie si une position donnée est accessible (espace vide ' ')
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
     * Récupère la largeur de la carte
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Récupère la hauteur de la carte
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Récupère la carte sous forme de tableau 2D
     */
    public char[][] getCarte() {
        return carte;
    }


	public void afficherCarte() {
		System.out.println(" Carte chargée :");
		for (char[] ligne : carte) {
            System.out.println(new String(ligne));
        }
    }
	
}
