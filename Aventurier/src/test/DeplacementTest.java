package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modele.Carte;
import modele.Hero;
import vue.VueCarte;
import controleur.Deplacement;

/**
 * Teste le déplacement du héros en dehors des limites de la carte.
 * 
 * <p>
 * Ce test vérifie que le héros ne peut pas se déplacer en dehors des limites de la carte. Si un déplacement
 * tente de sortir de la carte, la position du héros doit rester inchangée. Dans ce cas, la tentative
 * de déplacement vers le nord à partir du coin supérieur gauche (position 0, 0) ne doit pas réussir.
 * </p>
 * 
 * @see Deplacement
 * @see Hero
 * @see Carte
 */
public class DeplacementTest {
    private Carte carte;
    private Hero hero;
    private VueCarte vueCarte;
    private Deplacement deplacement;
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

        // Initialisation des objets
        carte = new Carte(fichierTemporaire.toString());
        hero = new Hero(1, 1); // Position initiale dans une case vide
        vueCarte = new VueCarte();
        deplacement = new Deplacement(carte, hero, vueCarte);

    }

    /**
     * Teste un déplacement valide du héros.
     * 
     * <p>
     * Ce test vérifie que le héros se déplace correctement vers le sud ('S') puis vers l'est ('E') en fonction
     * de la carte et de la position initiale. Il s'assure aussi que le héros ne traverse pas les murs.
     * </p>
     */
    @Test
    public void testDeplacementValide() {
        deplacement.deplacer('S'); // Sud
        assertEquals(1, hero.getX());
        assertEquals(2, hero.getY()); // Doit descendre d'une case

        deplacement.deplacer('E'); // Est
        assertEquals(1, hero.getX());
        assertEquals(2, hero.getY()); // Doit avancer d'une case à droite
    }

    /**
     * Teste le déplacement du héros lorsqu'il rencontre un mur.
     * 
     * <p>
     * Ce test vérifie que le héros ne peut pas traverser un mur ('#') sur la carte. Si le héros tente de se déplacer
     * vers une case contenant un mur, sa position ne doit pas changer.
     * </p>
     */
    @Test
    public void testDeplacementMur() {
        hero.setPosition(2, 1); // Position devant un mur
        deplacement.deplacer('S'); // Tentative de passer à travers un mur

        // La position ne doit pas changer
        assertEquals(2, hero.getX());
        assertEquals(1, hero.getY());
    }

    /**
     * Teste le déplacement du héros en dehors des limites de la carte.
     * 
     * <p>
     * Ce test vérifie que le héros ne peut pas se déplacer en dehors des limites de la carte. Si un déplacement
     * tente de sortir de la carte, la position du héros doit rester inchangée.
     * </p>
     */
    @Test
    public void testDeplacementHorsLimite() {
        hero.setPosition(0, 0); // Coin supérieur gauche
        deplacement.deplacer('N'); // Impossible (hors carte)

        assertEquals(0, hero.getX());
        assertEquals(0, hero.getY()); // Ne doit pas bouger
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
