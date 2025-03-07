package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modele.Carte;
import modele.Hero;

/**
 * Classe responsable de l'affichage de la carte et du héros.
 * Elle utilise Swing pour afficher une grille représentant la carte du jeu.
 */
public class VueCarte extends JFrame {
    
    /** Panneau principal contenant la grille */
    private JPanel panel;
    
    /** Référence à la carte du jeu */
    private Carte carte;
    
    /** Référence au héros */
    private Hero hero;
    
    /** Tableau de labels représentant la carte */
    private JLabel[][] labels;

    /**
     * Constructeur de la VueCarte.
     * Initialise la fenêtre et la grille graphique.
     * 
     * @param carte La carte du jeu
     * @param hero Le héros
     */
    public VueCarte(Carte carte, Hero hero) {
        this.carte = carte;
        this.hero = hero;

        setTitle("Déplacement du Héros"); // Titre de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture propre de l'application
        setLayout(new BorderLayout()); // Utilisation d'un layout principal
        
        panel = new JPanel(new GridLayout(carte.getHauteur(), carte.getLargeur()));
        labels = new JLabel[carte.getHauteur()][carte.getLargeur()];

        // Initialisation de la grille avec des labels
        for (int y = 0; y < carte.getHauteur(); y++) {
            for (int x = 0; x < carte.getLargeur(); x++) {
                labels[y][x] = new JLabel(" ", SwingConstants.CENTER);
                labels[y][x].setOpaque(true);
                labels[y][x].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(labels[y][x]);
            }
        }

        add(panel, BorderLayout.CENTER); // Ajout du panel à la fenêtre
        pack(); // Ajuste la taille automatiquement
        setVisible(true); // Affiche la fenêtre
    }

    /**
     * Met à jour l'affichage de la carte avec la position actuelle du héros.
     * Met à jour les couleurs et les symboles pour représenter les obstacles et le héros.
     * 
     * @param carte La carte du jeu
     * @param hero Le héros à afficher
     */
    public void mettreAJourAffichage(Carte carte, Hero hero) {
        for (int y = 0; y < carte.getHauteur(); y++) {
            for (int x = 0; x < carte.getLargeur(); x++) {
                if (x == hero.getX() && y == hero.getY()) {
                    labels[y][x].setText("P"); // Affiche le héros
                    labels[y][x].setBackground(Color.RED); // Fond rouge pour le héros
                } else if (carte.getCarte()[y][x] == '#') {
                    labels[y][x].setText("#"); // Affiche un mur
                    labels[y][x].setBackground(Color.BLACK); // Fond noir pour les obstacles
                } else {
                    labels[y][x].setText(" "); // Case vide
                    labels[y][x].setBackground(Color.WHITE); // Fond blanc pour les zones accessibles
                }
            }
        }
        panel.revalidate(); // Rafraîchit le panel
        panel.repaint(); // Redessine l'interface
    }
    
    /**
     * Affiche la carte sous forme textuelle dans la console avec la position du héros.
     * 
     * @param carte La carte du jeu
     * @param hero Le héros à afficher
     */
    public void afficherCarte(Carte carte, Hero hero) {
        char[][] grille = carte.getCarte();
        for (int y = 0; y < carte.getHauteur(); y++) {
            for (int x = 0; x < carte.getLargeur(); x++) {
                if (x == hero.getX() && y == hero.getY()) {
                    System.out.print("P"); // Affiche le personnage
                } else {
                    System.out.print(grille[y][x]); // Affiche les obstacles et espaces libres
                }
            }
            System.out.println(); // Saut de ligne pour la nouvelle rangée
        }
    }
}