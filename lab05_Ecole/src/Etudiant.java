public class Etudiant extends Personne{
    private int matricule;
    private Groupe groupe;

    Etudiant(String prenom, String nom, int matricule){
        super(prenom, nom);
        this.matricule = matricule;
    }

    public String toString(){
        return "Etud. " + super.toString() + " (#" + matricule + ") - " + groupe.nom();
    }


}
