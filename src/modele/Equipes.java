package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipes implements Serializable, Comparable<Equipes> {

    private String nom;
    private String ville;
    private ArrayList<Personne> personnes;

    public Equipes() {
        this.nom = "Nouvelle équipe";
        this.ville = "aucune";
        this.personnes = new ArrayList<Personne>();
    }

    public Equipes(String nom, String ville, ArrayList<Personne> personnes) {
        setNom(nom);
        this.ville = ville;
        this.personnes = personnes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(nom == null || nom.trim().equals("")) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
        this.nom = nom;
    }

    public String getString() {
        return ville;
    }

    public void setString(String ville) {
        this.ville = ville;
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
        result = prime * result + ((ville == null) ? 0 : ville.hashCode());
        result = prime * result + ((personnes == null) ? 0 : personnes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipes other = (Equipes) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (ville == null) {
            if (other.ville != null)
                return false;
        } else if (!ville.equals(other.ville))
            return false;
        if (personnes == null) {
            if (other.personnes != null)
                return false;
        } else if (!personnes.equals(other.personnes))
            return false;
        return true;
    }

    public boolean equals(Equipes obj) {
        return this.nom.equals(obj.getNom()) && this.ville.equals(obj.getString()) && this.personnes.equals(obj.getPersonnes());
    }

    @Override
    public String toString() {
        return nom + " (" + ville + ") ";
    }

    // Ordre naturel : par nom (sans binaire)
    @Override
    public int compareTo(Equipes obj) {
        return this.nom.toLowerCase().compareTo(obj.getNom().toLowerCase());
    }
    
    // Autres méthodes de la classe Cours ici
    public void ajouterPersonne(Personne personne){
        this.personnes.add(personne);
    }

    public ArrayList<Personne> getPersonnel() {
        return this.personnes;

    }

    public void supprimerPersonne(Personne personne) {
        personnes.remove(personne);
    }
}
