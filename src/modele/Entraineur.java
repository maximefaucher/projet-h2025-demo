package modele;

import java.time.LocalDate;

import modele.Disciplines.TypeEntr;

public class Entraineur extends Personne {
    protected int primeMatch;
    protected LocalDate dateEmbauche;
    protected TypeEntr type;

    public Entraineur() {
        super();
        this.type = TypeEntr.ENTR_PRINCIPAL;
        this.primeMatch = 1;
    }

    public Entraineur(String prenom, String nom, LocalDate dateEmbauche, int primeMatch, TypeEntr type) {
        super(prenom, nom);
        this.dateEmbauche = dateEmbauche;
        this.primeMatch = primeMatch;
        this.type = type;
    }

    public TypeEntr getType() {
        return type;
    }

    public void setType(TypeEntr type) {
        this.type = type;
    }

    public int getEchelon() {
        return primeMatch;
    }

    public void setEchelon(int primeMatch) {
        this.primeMatch = primeMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + primeMatch;
        return result;
    }

    public boolean equals(Entraineur obj) {
        // Prendre .equals() pour les enums, == pour les int
        return super.equals(obj) && this.type.equals(obj.getType()) && this.primeMatch == obj.getEchelon();
    }

    @Override
    public String toString() {
        return super.toString() + ": Entraineur depuis : " + dateEmbauche + ", Prime : " + primeMatch + " Type : " + type;
    }
    
}
