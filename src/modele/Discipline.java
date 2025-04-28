package modele;

public enum Discipline {
    // Les valeurs possibles avec leur nom
    PROGRAMMATION("Programmation"),
    RESEAUX("Réseaux"),
    BASES_DE_DONNEES("Bases de données"),
    WEB("Web"),
    OBJETS_CONNECTES("Objets connectés"),
    JEUX_VIDEOS("Jeux vidéos"),
    ADMINISTRATION_SYSTEMES("Administration de systèmes"),
    INSTALLATIONS_MATERIELLES("Installations matérielles"),
    CYBERSECURITE("Cybersécurité");

    // Le nom de la discipline
    public final String nom;

    // Constructeur privé pour initialiser le nom de la discipline
    private Discipline(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}

// Version simple de l'enum Discipline avec seulement des valeurs
// public enum Discipline { PROGRAMMATION, RESEAUX, BASES_DE_DONNEES, WEB, OBJETS_CONNECTES, JEUX_VIDEOS, 
//                          ADMINISTRATION_SYSTEMES, INSTALLATIONS_MATERIELLES, CYBERSECURITE; }