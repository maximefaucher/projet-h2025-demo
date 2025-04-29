package vue;

import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;
import controleur.GestionnaireCours;
import modele.*;

public class DialogueProfesseur extends JDialog {

    // Attributs de la fenêtre
    JLabel lblPrenom, lblNom, lblDateNaissance, lblDiscipline, lblEchelon;
    JTextField fldPrenom, fldNom, fldDateNaissance;
    JComboBox<Discipline> cmbDiscipline;
    JComboBox<Integer> cmbEchelon;
    JButton btnSubmit, btnCancel;
    boolean edit;


    // Constructeur pour boîte de dialogue pour la création (professeur == null)
    // ou l'édition d'un objet Professeur
    public DialogueProfesseur(Frame parent, GestionnaireCours gestionnaire, Professeur professeur, Cours cours) {
        super(parent, (professeur == null ? "Ajout" : "Mise à jour") + " d'un professeur", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6 , 2, 3, 3)); // grille 6 x 2

        edit = professeur != null; // booléen utile si on est en edit

        // Initialisation des composants (attributs)
        lblPrenom = new JLabel("Prénom");
        lblNom = new JLabel("Nom");
        lblDateNaissance = new JLabel("Date de naissance (AAAA-MM-JJ)");
        lblDiscipline = new JLabel("Discipline");
        lblEchelon = new JLabel("Échelon (1-19)");
        fldPrenom = new JTextField(edit ? professeur.getNom() : "", 20);
        fldNom = new JTextField(edit ? professeur.getNom() : "", 20);
        fldDateNaissance = new JTextField(edit ? professeur.getDateNaissance().toString() : "", 20);
        cmbDiscipline = new JComboBox<>(Discipline.values()); // va automatiquement mettre les valeurs de l'enum
        if(edit) cmbDiscipline.setSelectedItem(professeur.getSpecialiteProfesseur());
        Integer echelons[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        cmbEchelon = new JComboBox<>(echelons); // va prendre les entiers du tableau echelons
        if(edit) cmbEchelon.setSelectedIndex(professeur.getEchelon()-1);
        btnSubmit = new JButton("Enregistrer");
        btnCancel = new JButton("Annuler");

        // Ajout des composants à la fenêtre
        add(lblPrenom);
        add(fldPrenom);
        add(lblNom);
        add(fldNom);
        add(lblDateNaissance);
        add(fldDateNaissance);
        add(lblDiscipline);
        add(cmbDiscipline);
        add(lblEchelon);
        add(cmbEchelon);
        add(btnSubmit);
        add(btnCancel);

        // Écouteurs d'événements
        btnCancel.addActionListener(e -> dispose());

        btnSubmit.addActionListener(e -> {
            // on récupère les données
            String prenom = fldPrenom.getText();
            String nom = fldNom.getText();
            String ddn = fldDateNaissance.getText(); // sera converti en LocalDate plus tard!
            int echelon = cmbEchelon.getSelectedIndex() + 1;
            Discipline discipline = (Discipline) cmbDiscipline.getSelectedItem(); // transtypage!!

            // Selon qu'on ajoute ou on modifie, on fait l'action appropriée
            if(edit) {
                // code pour mise à jour
                // on pourrait appeler les "setters" ici
            }
            else {
                // code pour l'ajout
                // 1. création de l'objet à ajouter
                Professeur nouveau = new Professeur(prenom, nom, LocalDate.parse(ddn), discipline, echelon);
                // 2. Ajout au cours reçu en param!
                gestionnaire.ajoutPersonneCours(cours, nouveau);
                // rétroaction à l'utilisateur?
                JOptionPane.showMessageDialog(this, "Ajout effectué avec succès!", "Ajout", JOptionPane.INFORMATION_MESSAGE);
            }
            dispose(); // ne pas oublier de fermer la fenêtre!
        });

    }
}
