import java.util.LinkedList;
import java.util.Random;

public class Henhouse {
    private int turn;
    private LinkedList<Hen> hens = new LinkedList<>();
    private static Random random = new Random(42);
    public void add(Hen h) {
        hens.add(h);
    }
    public void nextRound() {

        int size = hens.size();
        for(int j = 0; j < size; ++j){
            int eggsToLay = random.nextInt(3);
            for(int i = 0; i < eggsToLay; ++i) {
                add(hens.get(j).lay().hatch());
            }
        }
        // à compléter
    }

    public static void main(String... args) {
        Henhouse h = new Henhouse();
        h.add(new Hen("Cocotte"));
        h.add(new Hen("Rosette"));
        for (int i = 0; i < 10; i++)
            h.nextRound();
    }
}
