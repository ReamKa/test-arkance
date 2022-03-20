
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    // in the program:
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println(
                "Entrez le nom de votre fichier. Pour l'amour de Dieu, faites que ce soit \"input\" tout court");
        String input = scan.nextLine();

        try (Scanner scanner = new Scanner(Paths.get(input + ".txt"))) {
            Fichier fichier = new Fichier(scanner);
            System.out.println("Voulez-vous que votre liste soit triee selon l'odre [croissant] ou [decroissant]");
            String reponse = scan.nextLine().toLowerCase();
            fichier.sorting(reponse);

            // decommentez pour tester l'insertion sort
            // fichier.sortAlgoDecroissant();
            // fichier.sortAlgoCroissant();
        } catch (Exception e) {
            System.out.println("Promis, le mot magique c'est \"input\". Reessayez.");
        }
        scan.close();
    }

}