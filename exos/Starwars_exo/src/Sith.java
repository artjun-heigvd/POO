public class Sith extends ForceUser {
    private Sith master;

    public Sith(String name, int nbrMC, Sith master){
        super(name, nbrMC);
        this.master = master;
    }

    @Override
    protected ColorLaser getColorSaber() {
        return ColorLaser.RED;
    }

    @Override
    protected String getType() {
        return "Sith";
    }
}
