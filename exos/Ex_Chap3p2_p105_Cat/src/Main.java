public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.mreow();
        Cat.info();

        for(int i = 0; i < 3; ++i){
            new Cat();
        }
        Cat.info();

        Cat.mreowAll();

        c.die();
        Cat.info();
    }
}