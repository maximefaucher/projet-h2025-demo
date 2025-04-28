package modele;

import java.time.LocalDate;

public class Professeur extends Personne {
    protected Discipline specialiteProfesseur;
    protected int echelon;

    public Professeur() {
        super();
        this.specialiteProfesseur = Discipline.PROGRAMMATION;
        this.echelon = 1;
    }

    public Professeur(String prenom, String nom, LocalDate dateNaissance, Discipline specialiteProfesseur, int echelon) {
        super(prenom, nom, dateNaissance);
        this.specialiteProfesseur = specialiteProfesseur;
        this.echelon = echelon;
    }

    public Discipline getSpecialiteProfesseur() {
        return specialiteProfesseur;
    }

    public void setSpecialiteProfesseur(Discipline specialiteProfesseur) {
        this.specialiteProfesseur = specialiteProfesseur;
    }

    public int getEchelon() {
        return echelon;
    }

    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((specialiteProfesseur == null) ? 0 : specialiteProfesseur.hashCode());
        result = prime * result + echelon;
        return result;
    }

    public boolean equals(Professeur obj) {
        // Prendre .equals() pour les enums, == pour les int
        return super.equals(obj) && this.specialiteProfesseur.equals(obj.getSpecialiteProfesseur()) && this.echelon == obj.getEchelon();
    }

    
}
