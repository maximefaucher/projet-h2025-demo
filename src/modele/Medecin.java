package modele;
import java.util.Comparator;

import modele.Disciplines.Specialite;;
public class Medecin extends Personne implements Comparator<Personne> {

    private String nomDeCabinet;
    private Specialite specialite;

    public Medecin(String nom, String prenom, String nomDeCabinet, Specialite specialite) {
        super(nom, prenom);
        this.nomDeCabinet = nomDeCabinet;
        this.specialite = specialite;
    }
    // Constructeur par défaut
    public Medecin() {
        super();
        this.nomDeCabinet = "Cabinet médical";
        this.specialite = Specialite.MEDECIN_SPORT;
    }

    public String getNomDeCabinet() {
        return nomDeCabinet;
    }

    public void setNomDeCabinet(String nomDeCabinet) {
        this.nomDeCabinet = nomDeCabinet;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cabinet: " + nomDeCabinet + " (" + specialite + ")";
    }
}
