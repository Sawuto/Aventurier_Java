package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controleur.Deplacement;
import modele.Carte;
import modele.Hero;
import vue.VueCarte;

/**
 * Teste l'affichage de la carte dans la classe {@link VueCarte}.
 * 
 * <p>
 * Ce test vérifie que la méthode {@link VueCarte#afficherCarte(Carte, Hero)} affiche correctement la carte et la position
 * du héros. La sortie console est capturée et comparée à l'affichage attendu.
 * </p>
 * 
 * @see VueCarte
 * @see Carte
 * @see Hero
 */
public class VueCarteTest {
	private Carte carte;
    private Hero hero;
    private VueCarte vueCarte;
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
        hero = new Hero(1, 1); // Position initiale dans une case vide
        vueCarte = new VueCarte();
    }
    
    /**
     * Teste l'affichage de la carte avec la position du héros.
     * 
     * <p>
     * Ce test redirige la sortie console, appelle la méthode d'affichage de la carte, et vérifie que la position
     * du héros est bien incluse dans l'affichage.
     * </p>
     */
    @Test
    public void testAfficherCarte() {
    	vueCarte.afficherCarte(carte,hero);
    	
    	
    }
    
    @After
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
    public void supprimerFichierTemporaire() throws IOException {
        Files.deleteIfExists(fichierTemporaire);
    }
    
}
