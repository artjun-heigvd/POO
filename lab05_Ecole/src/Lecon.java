import java.util.List;

public class Lecon {
    private String matiere, salle;
    private int jourDeSemaine, periodeDebut, duree;

    private List<Professeur> professeurs;

    public static String horaires(){


        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("     | Lun         | Mar         | Mer         | Jeu         | Ven         |%n");
        System.out.format("     |-------------|-------------|-------------|-------------|-------------|%n");
        System.out.format("| Column name     | ID   |%n");
        System.out.format("+-----------------+------+%n");
        for (int i = 0; i < 5; i++) {
            System.out.format(leftAlignFormat, "some data" + i, i * i);
        }
        System.out.format("+-----------------+------+%n");









        return "";
    }

}
