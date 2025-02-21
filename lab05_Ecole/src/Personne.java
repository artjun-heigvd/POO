public class Personne {
    private String nom, prenom;

    Personne(String prenom, String nom){
        this.prenom = prenom;
        this.nom = nom;
    }

    public String toString(){
        return prenom + " " + nom;
    }
}
