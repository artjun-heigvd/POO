public class Humanoide {
    private String name;

    public Humanoide(String name){
        this.name = name;
    }

    protected String getType(){
        return "Humanoide";
    }

    protected String getName(){
        return name;
    }

    public String toString() {
        return "type: " + getType() + ", nom: " + name;
    }
}
