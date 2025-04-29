package vue;

import java.awt.*;
import javax.swing.*;
import controleur.GestionnaireCours;
import modele.Cours;
import vue.FenetrePrincipale.ActionsCours;

public class DialogueListeCours extends JDialog {

    JPanel panelBoutons;

    public DialogueListeCours(Frame parent, GestionnaireCours gestionnaire, FenetrePrincipale.ActionsCours action) {
        super(parent, "Liste des équipes", true); // true pour modal
        setSize(400, 300);
        setLocationRelativeTo(parent);

        panelBoutons = new JPanel();
        panelBoutons.setLayout(new FlowLayout());
        
        // On ajoute les cours à une liste
        DefaultListModel<Cours> listeModele = new DefaultListModel<>();
        for(Cours cours : gestionnaire.getListeCours()) {
            listeModele.addElement(cours); // toString() de Cours sera appelée pour l'affichage dans la liste
        }
        JList<Cours> liste = new JList<>(listeModele);
        JScrollPane scrollPane = new JScrollPane(liste);
        add(scrollPane, BorderLayout.NORTH);

        // On ajoute un bouton pour valider le choix d'un cours en fonction du param 'action'
        if(action == ActionsCours.AJOUTER_PERSONNE) {
            JButton validerButton = new JButton("Choisir ce cours");
            panelBoutons.add(validerButton);
            validerButton.addActionListener(e -> {
                int index = liste.getSelectedIndex();
                if(index == -1) { // Aucune sélection
                    JOptionPane.showMessageDialog(this, "Veuillez choisir un cours dans la liste.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // On récupère le cours sélectionné pour le passer à la fenêtre suivante (pour choisir le type de Personne à ajouter)
                Cours leCours = listeModele.get(index);
                new DialogueChoixTypePersonne(parent, gestionnaire, leCours).setVisible(true);;
                dispose(); // fermer la fenêtre courante
            });
        }
        
        JButton okButton = new JButton("Fermer");
        panelBoutons.add(okButton);
        okButton.addActionListener(e -> dispose());
        add(panelBoutons, BorderLayout.SOUTH);

    }

}
