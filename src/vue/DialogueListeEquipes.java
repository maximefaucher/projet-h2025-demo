package vue;

import java.awt.*;
import java.lang.reflect.Array;

import javax.swing.*;
import controleur.GestionnaireCours;
import modele.Equipes;

public class DialogueListeEquipes extends JDialog {

    public DialogueListeEquipes(Frame parent, GestionnaireCours gestionnaire) {
        super(parent, "Liste des équipes", true); // true pour modal
        setSize(600, 300);
        setLocationRelativeTo(parent);
        
        // panel pour la liste d'équipe qui auront des boutons
        JPanel panelEquipes = new JPanel();
        panelEquipes.setLayout(new BoxLayout(panelEquipes, BoxLayout.Y_AXIS));


        for(Equipes equipe : gestionnaire.getListeEquipes()) {
            // ligne pour toutes les équipes
            JPanel rowPanel = new JPanel(new BorderLayout());
            rowPanel.setSize(200, 40);

            JLabel equipeLabel = new JLabel(equipe.toString());
            equipeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // spacing
            rowPanel.add(equipeLabel, BorderLayout.CENTER);

            // panel pour contenir de pitons cote à cote
            JPanel btnPanel = new JPanel();
            btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));

            // Boutton liste de joueurs
            ImageIcon eyeIcon = new ImageIcon(getClass().getResource("/images/eye.png")); // adjust the path as needed
            JButton btnAfficher = new JButton(eyeIcon);
            btnAfficher.setBackground(new Color(0, 153, 0)); 
            btnAfficher.setForeground(Color.WHITE);
            btnAfficher.addActionListener(e -> {
                DialogueListePersEquipe dialog = new DialogueListePersEquipe((Frame) SwingUtilities.getWindowAncestor(this), equipe);
                dialog.setVisible(true);
            });
            btnAfficher.setToolTipText("Afficher les joueurs de l'équipe");
            btnPanel.add(btnAfficher, BorderLayout.AFTER_LINE_ENDS);
            // Boutton liste de joueurs
            ImageIcon penIcon = new ImageIcon(getClass().getResource("/images/pen1.png")); // adjust the path as needed
            JButton btnModifier = new JButton(penIcon);
            btnModifier.setBackground(new Color(153, 0, 0)); 
            btnModifier.setForeground(Color.WHITE);
            btnModifier.addActionListener(e -> ModifierNomEquipe(equipe, gestionnaire));
            btnModifier.setToolTipText("Modifier le nom d'équipe");
            btnPanel.add(btnModifier, BorderLayout.AFTER_LINE_ENDS);

            // ajout des deux bouton dans le rowpanel
            rowPanel.add(btnPanel, BorderLayout.EAST);

            panelEquipes.add(rowPanel);
            panelEquipes.add(Box.createVerticalStrut(5)); 
            
        }

        JScrollPane scrollPane = new JScrollPane(panelEquipes);
        add(scrollPane, BorderLayout.CENTER);

        // panel pour les boutons de tri et de fermeture        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnFermer = new JButton("Fermer");
        btnFermer.addActionListener(e -> dispose());
        buttonPanel.add(btnFermer);

        JButton btnTrier = new JButton("Trier par nom");
        btnTrier.addActionListener(e -> {
            // Trier la liste des équipes par nom
            gestionnaire.triEqipes();
            // Mettre à jour l'affichage
            dispose();
            new DialogueListeEquipes((Frame) SwingUtilities.getWindowAncestor(this), gestionnaire).setVisible(true);
        });
        buttonPanel.add(btnTrier);

        add(buttonPanel, BorderLayout.SOUTH);

    }

    // méthode privée pour modifier le nom de l'équipe
    private void ModifierNomEquipe(Equipes equipe,GestionnaireCours gestionnaire) {
        String uNumEquipe = JOptionPane.showInputDialog(this, "Modifier le nom de l'équipe :", equipe.getNom());
        if (uNumEquipe != null && !uNumEquipe.trim().isEmpty()) {
            equipe.setNom(uNumEquipe);
            JOptionPane.showMessageDialog(this, "Le nom de l'équipe a été modifié avec succès !");
            dispose();
            // Mettre à jour la liste des équipes dans le gestionnaire
                new DialogueListeEquipes((Frame) SwingUtilities.getWindowAncestor(this), gestionnaire).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Le nom de l'équipe ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


}



