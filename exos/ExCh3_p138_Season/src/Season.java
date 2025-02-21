import java.util.Arrays;

public class Season {
    private final String name;
    private final int id;
    public static final Season Spring, Summer, Fall, Winter;
    private static final Season[] $VALUES;
    public static Season[] values(){
        return $VALUES.clone();
    }
    public static Season valueOf(String name){
        for(Season s : $VALUES){
            if(name.equals(s.name))
                return s;
        }
        return null;
    }
    private Season(String name, int id){
        this.name = name;
        this.id = id;
    }

    static {
        Spring = new Season("Spring", 0);
        Summer = new Season("Summer", 1);
        Fall = new Season("Fall", 2);
        Winter = new Season("Winter", 3);

        $VALUES = new Season[]{Spring, Summer, Fall, Winter};
    }

    public final String name(){
        return this.name;
    }

    public final int ordinal(){
        return this.id;
    }

    public final boolean equals(Object o){
        if(o == null || !o.getClass().equals(this.getClass())){
            return false;
        }
        return this.id == ((Season) o).id;
    }

    public static Season[] range(Season start, Season end){
        if(start == null || end == null){
            throw new NullPointerException("One of the parameters is null");
        }
        int newSize = end.id - start.id + 1;
        if(newSize <= 0){
            throw new IllegalArgumentException("The start is higher than the end");
        }
        Season[] temp = new Season[newSize];
        System.arraycopy(values(), start.id, temp, 0, newSize);
        return temp;
    }

    public Season previous(){
        int idPrev = this.id - 1 < 0 ? $VALUES.length - 1 : this.id - 1;
        return values()[idPrev];
    }

    public Season next(){
        int idNext = this.id + 1 >= $VALUES.length ? 0 : this.id + 1;
        return values()[idNext];
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
