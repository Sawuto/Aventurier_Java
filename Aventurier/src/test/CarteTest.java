package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import modele.Carte;

public class CarteTest { // Ajout de public
    private Carte carte;

    @Before
    public void setUp() throws IOException { // Ajout de public
        // Création d'une carte factice pour les tests
        String contenuCarte = """
                #####
                #   #
                # # #
                #   #
                #####
                """;
        Files.writeString(Paths.get("test_carte.txt"), contenuCarte);
        carte = new Carte("test_carte.txt");
    }

    @Test
    public void testChargementCarte() { // Ajout de public
        assertEquals(5, carte.getHauteur());
        assertEquals(5, carte.getLargeur());
    }

    @Test
    public void testEstAccessible() { // Ajout de public
        assertTrue(carte.estAccessible(1, 1)); // Case vide
        assertFalse(carte.estAccessible(0, 0)); // Mur '#'
        assertFalse(carte.estAccessible(-1, 1)); // Hors limites
    }
}
