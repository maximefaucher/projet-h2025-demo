package modele;

import java.time.LocalDate;

public class Etudiant extends Personne {

    protected String matricule;
    protected double moyenne;
    
    public Etudiant() {
        this.matricule = "-1";
        this.moyenne = 0.0;
    }

    public Etudiant(String prenom, String nom, LocalDate dateNaissance, String matricule, double moyenne) {
        super(prenom, nom, dateNaissance);
        this.matricule = matricule;
        this.moyenne = moyenne;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
        long temp;
        temp = Double.doubleToLongBits(moyenne);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals(Etudiant obj) {
        return super.equals(obj) && this.matricule.equals(obj.getMatricule()) && this.moyenne == obj.getMoyenne();
    }

    
}
