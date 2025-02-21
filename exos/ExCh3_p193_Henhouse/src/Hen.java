interface Egg<T>{
    T hatch();
}

public class Hen {
    private String name;
    private int nbEggs;
    public Hen(String s) {
        name = s;
    }
    public Egg<Hen> lay() { // pondre
        ++nbEggs;
        System.out.println(name + " pond son oeuf #" + nbEggs);
        return new Egg<Hen>() {
            Hen child;
            @Override
            public Hen hatch() {
                child = new Hen(name + nbEggs);
                System.out.println(child.name + " sort de l'oeuf #" + nbEggs + " de " + name);
                return child;
            }
        };
    }
}
