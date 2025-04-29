package controleur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modele.*;

public class GestionnaireCours {

    private ArrayList<Cours> listeCours;
    public static final String NOM_FICHIER = "cours.dat"; // Nom du fichier de sauvegarde

    public GestionnaireCours() {
        this.listeCours = new ArrayList<Cours>();
    }

    public ArrayList<Cours> getListeCours() {
        return listeCours;
    }

    // Pour ajouter un cours
    public void ajouterCours(Cours cours) {
        this.listeCours.add(cours);
    }

    // Pour supprimer un cours
    public void supprimerCours(Cours cours) {
        this.listeCours.remove(cours);
    }

    // Pour remplacer un cours par un autre (mise à jour)
    public void remplacerCours(Cours ancienCours, Cours nouveauCours) {
        int index = this.listeCours.indexOf(ancienCours);
        if (index != -1) {
            this.listeCours.set(index, nouveauCours);
        }
    }

    // Pour récupérer les personnes d'un cours donné
    public ArrayList<Personne> getPersonnesDuCours(Cours cours) {
        return cours.getPersonnes();
    }

    public void sauvegarderDansFichier(String nomFichier) throws IOException {
        // Mettre le code pour écrire l'ArrayList<Cours> dans un fichier sérialisé
        // TODO
    }

    @SuppressWarnings("unchecked") // pour éviter les avertissements de compilation
    public void chargerDepuisFichier(String nomFichier) throws IOException, ClassNotFoundException {
        // Mettre le code pour lire le fichier et récupérer l'ArrayList<Cours> sérialisée
        // TODO
        genererCoursParDefaut(); // Si jamais le fichier n'existe pas ou que la liste est vide, on génère des cours par défaut
    }

    private void genererCoursParDefaut() {
        // Créer des cours par défaut
        Cours cours1 = new Cours("Programmation Java", Discipline.PROGRAMMATION, new ArrayList<Personne>());
        cours1.ajouterPersonne(new Professeur("Alice", "Dupont", LocalDate.of(1985, 5, 15), Discipline.PROGRAMMATION, 15));
        cours1.ajouterPersonne(new Etudiant("Bob", "Martin", LocalDate.of(2000, 3, 20), "123456", 95.5));
        cours1.ajouterPersonne(new Etudiant("Charlie", "Durand", LocalDate.of(1999, 7, 10), "654321", 84.0));
        Cours cours2 = new Cours("Développement Web II", Discipline.WEB, new ArrayList<Personne>());
        cours2.ajouterPersonne(new Professeur("David", "Leroy", LocalDate.of(1978, 11, 25), Discipline.BASES_DE_DONNEES, 3));
        cours2.ajouterPersonne(new Etudiant("Eve", "Bernard", LocalDate.of(2001, 1, 30), "789012", 88.0));
        cours2.ajouterPersonne(new Etudiant("Frank", "Lemoine", LocalDate.of(2002, 4, 5), "345678", 92.0));        
        Cours cours3 = new Cours("Réseaux avancés", Discipline.RESEAUX, new ArrayList<Personne>());
        cours3.ajouterPersonne(new Professeur("Patrick", "Moreau", LocalDate.of(1990, 8, 12), Discipline.OBJETS_CONNECTES, 5));
        cours3.ajouterPersonne(new Etudiant("Hugo", "Rousseau", LocalDate.of(2003, 2, 14), "901234", 78.0));
        cours3.ajouterPersonne(new Etudiant("Iris", "Garnier", LocalDate.of(2004, 6, 18), "567890", 85.0));
        
        listeCours.add(cours1);
        listeCours.add(cours2);
        listeCours.add(cours3);

        // Mélanger les listes (afin de tester les tris)
        Collections.shuffle(listeCours); // les cours
        for (Cours cours : listeCours) { // les personnes dans les cours
            Collections.shuffle(cours.getPersonnes());
        }

    }

}
