package vue;

import java.awt.*;
import javax.swing.*;
import modele.Equipes;
import modele.Personne;
import java.util.ArrayList;

public class DialogueListePersEquipe extends JDialog {

    public DialogueListePersEquipe(Frame parent, Equipes equipe) {
        super(parent, "Détails de l'équipe", true); // true pour modal
        setSize(700, 300);
        setLocationRelativeTo(parent);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Panel pour afficher chaque élément dans un rowPanel
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        ArrayList<Personne> personnelList = equipe.getPersonnes();
        for (Personne personnel : personnelList) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0)); 
            rowPanel.setAlignmentX(Component.LEFT_ALIGNMENT); 

            JLabel label = new JLabel(personnel.toString());

            // Boutton liste de joueurs
            ImageIcon penIcon = new ImageIcon(getClass().getResource("/images/pen1.png"));
            JButton btnModifier = new JButton(penIcon);
            btnModifier.setBackground(new Color(153, 0, 0)); 
            btnModifier.setForeground(Color.WHITE);
            btnModifier.setToolTipText("Modifier le nom du joueur");
            btnModifier.addActionListener(e -> {
                modifJoueur(personnel, equipe);
            });
            // Boutton supprimer une personne
            ImageIcon meurIcon = new ImageIcon(getClass().getResource("/images/trash1.png"));
            JButton btnSupprimer = new JButton(meurIcon);
            btnSupprimer.setBackground(Color.BLACK); 
            btnSupprimer.setForeground(Color.WHITE);
            btnSupprimer.setToolTipText("Supprimer cette personne");
            btnSupprimer.addActionListener(e -> {
                supprimerJoueur(personnel, equipe);
            });

            rowPanel.add(label);
            rowPanel.add(btnModifier, BorderLayout.EAST);
            rowPanel.add(btnSupprimer, BorderLayout.EAST);
            rowPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); 

            listPanel.add(rowPanel);
            listPanel.add(Box.createRigidArea(new Dimension(0, 2))); 
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Boutons pour options supplémentaires
        JPanel buttonPanel = new JPanel();
        JButton btnFermer = new JButton("Fermer");

        btnFermer.addActionListener(e -> dispose());

        buttonPanel.add(btnFermer);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }
    private void modifJoueur(Personne personnel, Equipes equipe) {
        String uPrenom = JOptionPane.showInputDialog(this, "Modifier le prénom du joueur :", personnel.getPrenom());
        String uNom = JOptionPane.showInputDialog(this, "Modifier le nom du joueur :", personnel.getNom());

        try {
            personnel.setPrenom(uPrenom);
            personnel.setNom(uNom);
            JOptionPane.showMessageDialog(this, "Le joueur a été modifié avec succès !");
            dispose();
            DialogueListePersEquipe dialog = new DialogueListePersEquipe((Frame) SwingUtilities.getWindowAncestor(this), equipe);
            dialog.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la modification du joueur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void supprimerJoueur(Personne personnel, Equipes equipe) {
        int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer ce joueur ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            equipe.supprimerPersonne(personnel);
            dispose();
            JOptionPane.showMessageDialog(this, "Le joueur a été supprimé avec succès !");
            DialogueListePersEquipe dialog = new DialogueListePersEquipe((Frame) SwingUtilities.getWindowAncestor(this), equipe);
            dialog.setVisible(true);
        }
    }
}
