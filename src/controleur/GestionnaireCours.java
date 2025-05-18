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

import javax.swing.JOptionPane;

import modele.*;

public class GestionnaireCours {
    
    private ArrayList<Equipes> listeEquipes;
    public static final String NOM_FICHIER = "cours.dat"; // Nom du fichier de sauvegarde

    public GestionnaireCours() {
        this.listeEquipes = new ArrayList<Equipes>();
    }

    public ArrayList<Equipes> getListeEquipes() {
        return listeEquipes;
    }

    // Méthode pour trier les équipes par ordre alphabétique
    public void triEqipes() {
        Collections.sort(listeEquipes);
    }

    // Méthode pour trier les personnes d'une équipe
    public void triPersonnes(Equipes equipe) {
    }


    // Pour récupérer les personnes d'un cours donné
    public ArrayList<Personne> getPersonnesDuCours(Equipes equipe) {
        return equipe.getPersonnes();
    }

    public void sauvegarderDansFichier(String nomFichier) throws IOException {
        // Mettre le code pour écrire l'ArrayList<Cours> dans un fichier sérialisé
        // TODO
    }

    @SuppressWarnings("unchecked") // pour éviter les avertissements de compilation
    public void chargerDepuisFichier(String nomFichier) throws IOException, ClassNotFoundException {
        // Mettre le code pour lire le fichier et récupérer l'ArrayList<Cours> sérialisée
        // TODO
        genererEquipesParDefaut(); // Si jamais le fichier n'existe pas ou que la liste est vide, on génère des cours par défaut
    }

    private void genererEquipesParDefaut() {
        // Créer des cours par défaut
        Equipes equipe1 = new Equipes("Les Chatouilleux Prisoniers", "Saint-Jérôme", new ArrayList<Personne>());
        Equipes equipe2 = new Equipes("Yvons d'Acier", "Nova-Scotia", new ArrayList<Personne>());
        Equipes equipe3 = new Equipes("Les Trains Immobilles", "Shawinigan", new ArrayList<Personne>());
        Equipes equipe4 = new Equipes("Les Crystales Bruns", "Bas-du-Cap", new ArrayList<Personne>());
        Equipes equipe5 = new Equipes("Dairy Queen", "Tokyo", new ArrayList<Personne>());
        Equipes equipe6 = new Equipes("mélasse", "NYC", new ArrayList<Personne>());
        Equipes equipe7 = new Equipes("ptits cocos du Sag", "Jonquière", new ArrayList<Personne>());
        equipe1.ajouterPersonne(new Entraineur("Marco","Pilieux",LocalDate.of(2001,2, 1),23, Disciplines.TypeEntr.ENTR_ADJOINT));
        equipe1.ajouterPersonne(new Joueur("Lud","Eau",LocalDate.of(2001,2, 1),Disciplines.Position.MENEUR,23));
        equipe1.ajouterPersonne(new Joueur("Lud","Eau",LocalDate.of(2001,2, 1),Disciplines.Position.MENEUR,23));
        equipe1.ajouterPersonne(new Joueur("Lud","Eau",LocalDate.of(2001,2, 1),Disciplines.Position.MENEUR,23));
        equipe1.ajouterPersonne(new Joueur("Lsud","Eau",LocalDate.of(2001,2, 1),Disciplines.Position.MENEUR,23));
        equipe1.ajouterPersonne(new Joueur("Lud","Eau",LocalDate.of(2001,2, 1),Disciplines.Position.MENEUR,23));
        equipe1.ajouterPersonne(new Joueur("Ludsad","Eau",LocalDate.of(2001,2, 1),Disciplines.Position.MENEUR,23));
        equipe1.ajouterPersonne(new Joueur("Lusd","Eau",LocalDate.of(2001,2, 1),Disciplines.Position.MENEUR,23));
        equipe1.ajouterPersonne(new Medecin("Doc","Mailloux","Les Marsoins Médecins",Disciplines.Specialite.MEDECIN_SPORT));
      
        
        listeEquipes.add(equipe1);
        listeEquipes.add(equipe2);
        listeEquipes.add(equipe3);
        listeEquipes.add(equipe4);
        listeEquipes.add(equipe5);
        listeEquipes.add(equipe6);
        listeEquipes.add(equipe7);
        // listeEquipes.add(cours2);
        // listeEquipes.add(cours3);

        // Mélanger les listes (afin de tester les tris)
        Collections.shuffle(listeEquipes); // les cours
        for (Equipes cours : listeEquipes) { // les personnes dans les cours
            Collections.shuffle(cours.getPersonnes());
        }

    }
    
}
