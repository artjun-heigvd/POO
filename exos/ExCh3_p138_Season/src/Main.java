public class Main {
    public static void main(String[] args) {

        for (Season s : Season.values())
            System.out.printf("%s ", s);
        System.out.println();
        System.out.println();
        for (Season s : Season.range(Season.Spring, Season.Fall))
            System.out.printf("%10s <- %10s -> %10s\n", s.previous(), s, s.next());
        System.out.println();
        Season winter = Season.valueOf("Winter");
        if (winter == Season.Winter)
            System.out.println("Winter is coming");
    }
}