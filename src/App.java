/* 
 * Auteur   : 
 * Date     : 
 * Sujet    : Gestionnaire de cours
 *            Programme principal de l'application
*/

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import controleur.GestionnaireCours;
import vue.FenetrePrincipale;

public class App {
    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {
            // Créer une instance de GestionnaireCours et charger les données depuis le fichier
            GestionnaireCours gestionnaire = new GestionnaireCours();
            try {
                gestionnaire.chargerDepuisFichier(GestionnaireCours.NOM_FICHIER);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur lors du chargement des données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            // Créer la fenêtre principale de l'application et la rendre visible
            FenetrePrincipale fenetre = new FenetrePrincipale(gestionnaire);
            fenetre.setVisible(true);
        });
        
    }
}
