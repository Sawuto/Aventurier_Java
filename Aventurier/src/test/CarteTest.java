package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modele.Carte;

/**
 * Teste le comportement de la classe {@link Carte}.
 * 
 * <p>
 * Ce test vérifie que la carte est correctement chargée depuis un fichier et que ses dimensions ainsi que son contenu
 * correspondent aux attentes. De plus, il teste la méthode {@link Carte#estAccessible(int, int)} pour vérifier
 * l'accessibilité des cases de la carte.
 * </p>
 * 
 * @see Carte
 */
public class CarteTest {
    private Carte carte;
    private Path fichierTemporaire;

    /**
     * Prépare l'environnement de test avant chaque méthode de test.
     * 
     * <p>
     * Cette méthode configure l'état initial nécessaire pour chaque test. Elle est appelée avant
     * chaque exécution de test.
     * </p>
     * 
     * @throws IOException si un problème survient lors du chargement des ressources.
     */
    @Before
    public void setUp() throws IOException {
        // Création d'un fichier temporaire
        fichierTemporaire = Files.createTempFile("test_carte", ".txt");

        // Contenu de la carte
        String contenuCarte = """
                #####
                #   #
                # # #
                #   #
                #####
                """;
        Files.writeString(fichierTemporaire, contenuCarte);
        
        // Chargement de la carte
        carte = new Carte(fichierTemporaire.toString());
    }

    /**
     * Teste le chargement correct de la carte à partir d'un fichier.
     * 
     * <p>
     * Ce test vérifie que la hauteur et la largeur de la carte sont correctes, et que chaque case de la carte
     * contient les valeurs attendues (soit un mur '#', soit une case vide ' ').
     * </p>
     */
    @Test
    public void testChargementCarte() {
        assertEquals(5, carte.getHauteur());
        assertEquals(5, carte.getLargeur());

        // Vérifier le contenu exact de la carte
        char[][] expectedCarte = {
            {'#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#'}
        };

        assertEquals(expectedCarte.length, carte.getHauteur());
        assertEquals(expectedCarte[0].length, carte.getLargeur());

        for (int y = 0; y < carte.getHauteur(); y++) {
            for (int x = 0; x < carte.getLargeur(); x++) {
                assertEquals(expectedCarte[y][x], carte.getCarte()[y][x]);
            }
        }
    }

    /**
     * Teste la méthode {@link Carte#estAccessible(int, int)}.
     * 
     * <p>
     * Ce test vérifie que les cases sont correctement identifiées comme accessibles ou non (en fonction de
     * leur contenu : mur ou espace vide).
     * </p>
     */
    @Test
    public void testEstAccessible() {
        assertTrue(carte.estAccessible(1, 1));  // Case vide
        assertFalse(carte.estAccessible(0, 0)); // Mur '#'
        assertFalse(carte.estAccessible(-1, 1)); // Hors limites
        assertFalse(carte.estAccessible(5, 5));  // Hors limites
    }
    
    /**
     * Supprime le fichier temporaire utilisé pendant les tests.
     * 
     * <p>
     * Cette méthode est appelée après le test pour s'assurer que les fichiers temporaires
     * sont supprimés, afin d'éviter toute accumulation de fichiers inutiles.
     * </p>
     * 
     * @throws IOException si un problème survient lors de la suppression du fichier.
     */
    @After
    public void supprimerFichierTemporaire() throws IOException {
        Files.deleteIfExists(fichierTemporaire);
    }
}
