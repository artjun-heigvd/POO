import java.util.LinkedList;

public class Cat {
    private static final LinkedList<Cat> allCats = new LinkedList<>();
    private final int id;
    Cat(){
        allCats.add(this);
        id = allCats.size();
        System.out.println(this + " cree.");
    }

    public void mreow(){
        System.out.println(this + " miaule !");
    }

    public static void info(){
        System.out.println("Population : " + allCats.size() + " " + allCats);
    }

    public static void mreowAll(){
        for(Cat cat: allCats){
            cat.mreow();
        }
    }

    public void die(){
        System.out.println(this + " rejoint le royaume des chats.");
        allCats.remove(this);
    }

    public String toString(){
        return "Chat #" + id;
    }
}
