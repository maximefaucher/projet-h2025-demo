package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Cours implements Serializable, Comparable<Cours> {

    private String nom;
    private Discipline discipline;
    private ArrayList<Personne> personnes;

    public Cours() {
        this.nom = "Nouveau cours";
        this.discipline = Discipline.PROGRAMMATION;
        this.personnes = new ArrayList<Personne>();
    }

    public Cours(String nom, Discipline discipline, ArrayList<Personne> personnes) {
        this.nom = nom;
        this.discipline = discipline;
        this.personnes = personnes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(ArrayList<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
        result = prime * result + ((personnes == null) ? 0 : personnes.hashCode());
        return result;
    }

    public boolean equals(Cours obj) {
        return this.nom.equals(obj.getNom()) && this.discipline.equals(obj.getDiscipline()) && this.personnes.equals(obj.getPersonnes());
    }

    @Override
    public String toString() {
        return nom + " (" + discipline + ") " + " : " + getNbProfs() + " profs / " + getNbEtudiants() + " étudiants";
    }

    public int compareTo(Cours obj) {
        return this.nom.compareTo(obj.getNom());
    }
    
    // Autres méthodes de la classe Cours ici
    private int getNbProfs() {
        int nbProfs = 0;
        for (Personne personne : personnes) {
            if (personne instanceof Professeur) {
                nbProfs++;
            }
        }
        return nbProfs;
    }

    private int getNbEtudiants() {
        int nbEtudiants = 0;
        for (Personne personne : personnes) {
            if (personne instanceof Etudiant) {
                nbEtudiants++;
            }
        }
        return nbEtudiants;
    }

    public void ajouterPersonne(Personne p) {
        personnes.add(p);
    }

    public void supprimerPersonne(Personne p) {
        for(Personne _p : personnes) {
            if(p.equals(_p)) personnes.remove(_p);
        }
    }

}
