package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modele.Carte;
import modele.Hero;
import controleur.Deplacement;

public class DeplacementTest {
    private Carte carte;
    private Hero hero;
    private Deplacement deplacement;

    @Before
    public void setUp() throws IOException {
        // Création d'une carte factice
        String contenuCarte = """
                #####
                #   #
                # # #
                #   #
                #####
                """;

        // Écriture du fichier temporaire pour la carte
        String cheminFichier = "test_carte.txt";
        Files.writeString(Paths.get(cheminFichier), contenuCarte);

        // Initialisation des objets
        carte = new Carte(cheminFichier);
        hero = new Hero(1, 1); // Position initiale dans une case vide
        deplacement = new Deplacement(carte, hero);
    }

    @Test
    public void testDeplacementValide() {
        deplacement.deplacer('S'); // Sud
        assertEquals(1, hero.getX());
        assertEquals(2, hero.getY()); // Doit descendre d'une case

        deplacement.deplacer('E'); // Est
        assertEquals(2, hero.getX());
        assertEquals(2, hero.getY()); // Doit avancer d'une case à droite
    }

    @Test
    public void testDeplacementMur() {
        hero.setPosition(2, 1); // Position devant un mur
        deplacement.deplacer('S'); // Tentative de passer à travers un mur

        // La position ne doit pas changer
        assertEquals(2, hero.getX());
        assertEquals(1, hero.getY());
    }

    @Test
    public void testDeplacementHorsLimite() {
        hero.setPosition(0, 0); // Coin supérieur gauche
        deplacement.deplacer('N'); // Impossible (hors carte)

        assertEquals(0, hero.getX());
        assertEquals(0, hero.getY()); // Ne doit pas bouger
    }
}
