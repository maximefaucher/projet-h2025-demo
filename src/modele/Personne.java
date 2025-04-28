package modele;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Personne implements Serializable, Comparable<Personne> {

    protected String prenom;
    protected String nom;
    protected LocalDate dateNaissance;
    
    public Personne() {
        this.prenom = "Jean";
        this.nom = "Jean";
        this.dateNaissance = LocalDate.now();
    }

    public Personne(String prenom, String nom, LocalDate dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
        return result;
    }

    public boolean equals(Personne obj) {
        return this.prenom.equals(obj.getPrenom()) && this.nom.equals(obj.getNom()) && this.dateNaissance.equals(obj.getDateNaissance());
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + dateNaissance + ")";
    }

    // Ordre naturel : par nom puis par prénom
    public int compareTo(Personne o) {
        if (this.nom.equals(o.getNom())) {
            return this.prenom.compareTo(o.getPrenom());
        } else {
            return this.nom.compareTo(o.getNom());
        }
    }

}
