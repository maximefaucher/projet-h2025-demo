package modele;

public class Disciplines {
    
    // Enum pour les positions des joueurs
    public enum Position{
        MENEUR("Meneur"),
        ARRIERE("Arrière"),
        AILIER("Aillier"),
        AILIER_FORT("Ailier fort"),
        CENTRE("Centre");


        public final String nom;

         // Constructeur privé pour initialiser le nom de la discipline
        private Position(String nom) {
            this.nom = nom;
        }

        @Override
        public String toString() {
            return nom;
        }
    }
    
    // Enum pour les types d'entraineurs
    public enum TypeEntr{
        ENTR_PRINCIPAL("Entraineur principal"),
        ENTR_ADJOINT("Entraineur adjoint");



        public final String nom;

         // Constructeur privé pour initialiser le nom de la discipline
        private TypeEntr(String nom) {
            this.nom = nom;
        }

        @Override
        public String toString() {
            return nom;
        }
    }

    // Enum pour les types d'entraineurs
    public enum Specialite{
        MEDECIN_SPORT("Médecin du sport"),
        KINESITHERAPEUTE("Kinésithérapeute"),
        MASSEUR("Masseur");



        public final String nom;

         // Constructeur privé pour initialiser le nom de la discipline
        private Specialite(String nom) {
            this.nom = nom;
        }

        @Override
        public String toString() {
            return nom;
        }
    }

}
