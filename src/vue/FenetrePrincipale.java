package vue;

import javax.swing.*;
import java.awt.*;
import controleur.*;

public class FenetrePrincipale extends JFrame {

    private GestionnaireCours gestionnaire;
    public enum ActionsCours {LISTER, AJOUTER, AFFICHER_PERSONNES, QUITTER};

    public FenetrePrincipale(GestionnaireCours gestionnaire) {
        // On initialise la fenêtre principale
        super("Gestionnaire de cours");
        this.gestionnaire = gestionnaire;
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // On crée un panneau pour le contenu de la fenêtre (boutons, etc.)
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // On crée les boutons pour les différentes actions
        JButton listerButton = new JButton("Lister les cours");
        JButton ajouterButton = new JButton("Ajouter un cours");
        JButton afficherButton = new JButton("Afficher les personnes d'un cours");
        JButton quitterButton = new JButton("Quitter");
        quitterButton.setBackground(new Color( 242, 102, 102)); // Couleur de fond personnalisée
        // On ajoute les boutons au panneau
        panel.add(listerButton);
        panel.add(ajouterButton);
        panel.add(afficherButton);
        panel.add(quitterButton);
        // On ajoute le panneau à la fenêtre principale
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajout d'une bordure vide (10px partout)
        add(panel);

        // ActionListener pour les boutons
        listerButton.addActionListener(e -> afficherEquipes());
        // ajouter des action listeners ici pour les autres fonctionnalités
        ajouterButton.addActionListener(e -> ajouterEquipe());
        quitterButton.addActionListener(e -> quitterApplication());
        
    }

    private void afficherEquipes() {
        new DialogueListeCours(this, gestionnaire, ActionsCours.LISTER).setVisible(true);
    }

    private void ajouterEquipe() {
        new DialogueAjoutCours(this, gestionnaire).setVisible(true);
    }

    private void quitterApplication() {
        try {
            gestionnaire.sauvegarderDansFichier(GestionnaireCours.NOM_FICHIER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();      // Ferme la fenêtre principale
        System.exit(0); // Quitte l'application
    }
}
