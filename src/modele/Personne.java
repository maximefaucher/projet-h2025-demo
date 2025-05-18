package modele;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public abstract class Personne implements Serializable, Comparator<Personne> {

    protected String prenom;
    protected String nom;
    
    public Personne() {
        this.prenom = "Jean";
        this.nom = "Jean";
    }

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom == null || prenom.trim().equals("")) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide.");
            
        }
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.trim().equals("")) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
        this.nom = nom;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }


    public boolean equals(Personne obj) {
        return this.prenom.equals(obj.getPrenom()) && this.nom.equals(obj.getNom());
    }

    public String toString() {
        return prenom + " " + nom;
    }


    public int compare(Personne p1, Personne p2) {
        if (p1 instanceof Joueur && !(p2 instanceof Joueur)) {
            return -1; // Joueurs come first
        } else if (p1 instanceof Entraineur && p2 instanceof Medecin) {
            return -1; // Entraineurs come before Medecins
        } else if (p1 instanceof Medecin && !(p2 instanceof Medecin)) {
            return 1; // Medecins come last
        } else if (p1.getClass().equals(p2.getClass())) {
            // If same type, compare by name and then by first name
            int nameComparison = p1.nom.compareTo(p2.getNom());
            return nameComparison != 0 ? nameComparison : p1.prenom.compareTo(p2.getPrenom());
        } else {
            return 0; // Default case for other types
        }
    }
}
