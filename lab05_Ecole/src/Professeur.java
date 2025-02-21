import java.util.List;

public class Professeur extends Personne{

    private String abreviation;

    private List<Lecon> lecons;

    Professeur(String prenom, String nom, String abrev){
        super(prenom, nom);
        this.abreviation = abrev;
    }

    public String abreviation(){
        return abreviation;
    }

    @Override
    public String toString(){
        return "Prof. " + super.toString() + " (" + abreviation + ")";
    }

    public String horaire(){
        return "";
    }

}
