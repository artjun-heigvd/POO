public class ForceUser extends Humanoide{
    public enum ColorLaser{BLUE, GREEN, YELLOW, PURPLE, ORANGE, WHITE, RED}
    private int numberMidiChlorien;

    ForceUser master;

    protected ColorLaser getColorSaber(){
        return null;
    }

    ForceUser(String name, int nbrMC){
        super(name);
        numberMidiChlorien = nbrMC;
    }

    @Override
    protected String getType() {
        return "ForceUser";
    }

    @Override
    public String toString() {
        return super.toString() + ", lightsaber: " +;
    }
}
