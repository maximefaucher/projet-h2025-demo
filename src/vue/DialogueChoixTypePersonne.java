package vue;

import java.awt.*;
import javax.swing.*;
import controleur.GestionnaireCours;
import modele.Cours;

public class DialogueChoixTypePersonne extends JDialog {

    public DialogueChoixTypePersonne(Frame parent, GestionnaireCours gestionnaire, Cours cours) {
        super(parent, "Type de personne", true);
        setSize(300, 100);
        setLocationRelativeTo(parent);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Choisir le type de personne à ajouter");
        add(label, BorderLayout.NORTH);

        JPanel panelBoutons = new JPanel(); // conteneur des boutons
        panelBoutons.setLayout(new FlowLayout());

        JButton boutonProf = new JButton("Professeur");
        JButton boutonEtu = new JButton("Étudiant");

        panelBoutons.add(boutonProf);
        panelBoutons.add(boutonEtu);

        add(panelBoutons, BorderLayout.SOUTH);

        boutonProf.addActionListener(e -> {
            new DialogueProfesseur(parent, gestionnaire, null, cours).setVisible(true);;
            dispose();
        });

        boutonEtu.addActionListener(e -> {});
        
    }
}
