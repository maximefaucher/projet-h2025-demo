package modele;

import java.time.LocalDate;

import modele.Disciplines.Position;

public class Joueur extends Personne {

    protected LocalDate dateNaissance;
    protected Position position;
    protected int noJoueur; 
    
    public Joueur() {
        this.dateNaissance = LocalDate.now();
        this.position = Position.AILIER;
        this.noJoueur = 0;
    }

    public Joueur(String prenom, String nom, LocalDate dateNaissance, Position position, int noJoueur) {
        super(prenom, nom);
        this.dateNaissance = dateNaissance;
        this.position = position;
        this.noJoueur = noJoueur;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getNoJoueur() {
        return noJoueur;
    }

    public void setNoJoueur(int noJoueur) {
        this.noJoueur = noJoueur;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + noJoueur;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ": Joueur " + dateNaissance + ", position : " + position + ", #" + noJoueur;
    }


    
    
}
