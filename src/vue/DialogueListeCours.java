package vue;

import java.awt.*;
import javax.swing.*;
import controleur.GestionnaireCours;
import modele.Cours; 

public class DialogueListeCours extends JDialog {

    public DialogueListeCours(Frame parent, GestionnaireCours gestionnaire, FenetrePrincipale.ActionsCours action) {
        super(parent, "Liste des équipes", true); // true pour modal
        setSize(400, 300);
        setLocationRelativeTo(parent);
        
        // On ajoute les cours à une liste
        DefaultListModel<String> listeModele = new DefaultListModel<>();
        for(Cours cours : gestionnaire.getListeCours()) {
            listeModele.addElement(cours.toString()); 
        }
        JList<String> liste = new JList<>(listeModele);
        JScrollPane scrollPane = new JScrollPane(liste);
        add(scrollPane);

        JButton okButton = new JButton("Fermer");
        okButton.addActionListener(e -> dispose());
        add(okButton, BorderLayout.SOUTH);

    }

}
