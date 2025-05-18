package vue;

import java.awt.Frame;
import java.awt.GridLayout;
import java.time.LocalDate;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import controleur.GestionnaireCours;
import modele.Equipes;
import modele.Joueur;
import modele.Disciplines;
import modele.Disciplines.Position;


public class DialogueAjoutJoueur extends JDialog {


    public DialogueAjoutJoueur(Frame parent, GestionnaireCours gestionnaire) {
        super(parent, "Ajouter un joueur", true); // true pour modal
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 12, 12)); // 3 lignes, 2 colonnes, 5px spacing H, 5px spacing V

        JLabel labelPrenom = new JLabel("Prénom du joueur :");
        JTextField textePrenom = new JTextField(20); // 20 = largeur en caractères
        JLabel labelNom = new JLabel("Nom du joueur :");
        JTextField texteNom = new JTextField(20); // 20 = largeur en caractères


        
        JLabel labelDateNaissance = new JLabel("Date de naissance :");
        DatePickerSettings params = new DatePickerSettings();
        params.setFormatForDatesCommonEra("dd/MM/yyyy");
        DatePicker datePicker = new DatePicker(params);

        JLabel labelPosition = new JLabel("Position :");
        JLabel labelEquipe = new JLabel("Equipe :");
        JComboBox<Equipes> comboListeEquipes = new JComboBox<Equipes>();
        for (Equipes equipe : gestionnaire.getListeEquipes()) {
            comboListeEquipes.addItem(equipe);
        }
        JComboBox<Disciplines.Position> comboPosition = new JComboBox<Disciplines.Position>(Position.values());
        JButton btnAjout = new JButton("Créer");
        JButton btnAnnuler = new JButton("Annuler");

        panel.add(labelNom); 
        panel.add(texteNom);
        panel.add(labelPrenom); 
        panel.add(textePrenom);
        panel.add(labelDateNaissance);
        panel.add(datePicker);
        panel.add(labelPosition); 
        panel.add(comboPosition);
        panel.add(labelEquipe);
        panel.add(comboListeEquipes);
        panel.add(btnAjout);
        panel.add(btnAnnuler);

        add(panel);

        btnAjout.addActionListener(e -> {
            // Récupérer les données saisies par l'utilisateur
            String nom = texteNom.getText();
            String prenom = textePrenom.getText();
            LocalDate dateNaiss = datePicker.getDate();
            Equipes equipe = (Equipes)comboListeEquipes.getSelectedItem();
            Position position = (Position)(comboPosition.getSelectedItem());
            try {
                
            }
            catch(IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la création du cours : " + iae.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // en créer un joueur et l'ajouter à l'équipe choisie
            Joueur nouvJoueur = new Joueur(prenom, nom, dateNaiss, position,1);
            equipe.ajouterPersonne(nouvJoueur);
            dispose();
        });
        btnAnnuler.addActionListener(e -> dispose());

    }
}
