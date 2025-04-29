package vue;

import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.GestionnaireCours;
import modele.Cours;
import modele.Discipline;
import modele.Personne;

public class DialogueAjoutCours extends JDialog {



    public DialogueAjoutCours(Frame parent, GestionnaireCours gestionnaire) {
        super(parent, "Ajouter une .quipe", true); // true pour modal
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5)); // 3 lignes, 2 colonnes, 5px spacing H, 5px spacing V

        JLabel labelNom = new JLabel("Nom du cours :");
        JTextField texteNom = new JTextField(20); // 20 = largeur en caractères
        JLabel labelDiscipline = new JLabel("Discipline :");
        JComboBox<Discipline> comboDiscipline = new JComboBox<Discipline>(Discipline.values());
        JButton btnAjout = new JButton("Créer");
        JButton btnAnnuler = new JButton("Annuler");

        panel.add(labelNom);
        panel.add(texteNom);
        panel.add(labelDiscipline);
        panel.add(comboDiscipline);
        panel.add(btnAjout);
        panel.add(btnAnnuler);

        add(panel);

        btnAjout.addActionListener(e -> {
            // Récupérer les données saisies par l'utilisateur
            String nomCours = texteNom.getText();
            Discipline discipline = (Discipline) comboDiscipline.getSelectedItem();
            try {
                Cours nouveauCours = new Cours(nomCours, discipline, new ArrayList<>());
            }
            catch(IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la création du cours : " + iae.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // en créer un cours et l'ajouter à l'ArryList du gestionnaire
            Cours nouveauCours = new Cours(nomCours, discipline, new  ArrayList<Personne>());
            gestionnaire.ajouterCours(nouveauCours);
            dispose();
        });
        btnAnnuler.addActionListener(e -> dispose());

    }
}
