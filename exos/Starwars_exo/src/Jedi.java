public class Jedi extends ForceUser{

    ColorLaser saberColor;

    Jedi master;

    public Jedi(String name, int nbrMC, ColorLaser saberColor){
        super(name, nbrMC);
        this.saberColor = saberColor;
        this.master = null;
    }

    public Jedi(String name, int nbrMC, ColorLaser saberColor, Jedi master){
        this(name, nbrMC, saberColor);
        this.master = master;
    }

    @Override
    protected ColorLaser getColorSaber() {
        return saberColor;
    }

    @Override
    protected String getType() {
        return "Jedi";
    }
}
