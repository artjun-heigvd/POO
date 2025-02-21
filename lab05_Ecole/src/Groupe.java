import java.util.List;

public class Groupe {
    private int numero, trimestre;

    private String orientation;

    private List<Etudiant> etudiants;

    private List<Lecon> lecons;

    public Groupe(int numero,String orientation,int trimestre, List<Etudiant> etudiants){
        this.numero = numero;
        this.orientation = orientation;
        this.trimestre = trimestre;
        this.etudiants = etudiants;
    }
    public String horaire(){
     return "Bonne chance ! ";
    }

    public int getNumero(){
        return numero;
    }

    public String getOrientation(){
        return orientation;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public int nombreEtudiant(){
        return etudiants.size();
    }

    public void definirLecons(List<Lecon> args){

    }

    public String nom(){
        return orientation + trimestre + "-" + numero;
    }

}
