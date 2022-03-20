import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Fichier {
    private Scanner file;
    private ArrayList<Integer> integers = new ArrayList<Integer>();
    private int chiffre;

    // Constructeur
    public Fichier(Scanner scanner) {
        this.file = scanner;
    }

    // lecture de fichier
    public void lectureFichier() throws IOException {
        // on lit tout le fichier
        while (file.hasNext()) {
            // on lit ligne par ligne
            chiffre = file.nextInt();
            // on ajoute la valeur dans notre ArrayList
            integers.add(chiffre);
        }
    }

    // rend la liste decroissante
    private void stockageDecroissant() {
        // on arrange la liste dans l'ordre decroissant
        Collections.sort(integers, Collections.reverseOrder());
        try {
            // on ecrit notre nouvelle liste dans un fichier output
            FileWriter output = new FileWriter("output.txt");
            for (int i = 0; i < integers.size(); i++) {
                output.write(integers.get(i) + " \n");
            }
            System.out.println("La liste apres un tri decroissant :");
            // on peut lire directement depuis le fichier mais cela fait tres moche et
            // encombré.
            // mais surtout du code repetitif.
            // on prefera une boucle for.
            // voir les commentaires ci-dessous pour voir comment faire en lisant
            // directement depuis un fichier.
            output.close();
        } catch (Exception e) {
            System.out.println("Problème d'ouverture probablement.");
            e.printStackTrace();
        }
    }

    // rend la liste croissante
    public void stockageCroissant() throws IOException {
        // on arrange la liste dans l'ordre croissant
        Collections.sort(integers);
        try {
            // on ecrit notre nouvelle liste dans un fichier output
            FileWriter output = new FileWriter("output.txt");
            for (int i = 0; i < integers.size(); i++) {
                output.write(integers.get(i) + " \n");
            }
            System.out.println("La liste apres un tri croissant :");
            output.close();
        } catch (Exception e) {
            System.out.println("Problème d'ouverture probablement.");
            e.printStackTrace();
        }
    }

    // affichage test pour tester que nos valeurs sont bien entrées
    public void affichageFichier() {
        for (Integer marks : integers) {
            System.out.println(marks);
        }
    }

    public void sorting(String str) throws IOException {
        if (str.equals("croissant")) {
            stockageCroissant();
            affichageFichier();
        } else if (str.equals("decroissant") || str.equals("décroissant")) { // c'est interessant, il ne reconnait pas
                                                                             // l'accent
            stockageDecroissant();
            affichageFichier();
        } else {
            System.out.println("Il faut choisir entre un ordre croissant ou decroissant!");
        }
    }

    /*
     * try {
     * String str =null;
     * // on ecrit notre nouvelle liste dans un fichier output
     * FileWriter output = new FileWriter("output.txt");
     * output.write("" + integers);
     * System.out.println("La liste apres un tri croissant :");
     * 
     * //on peut lire directement du fichier mais cela fait tres moche et encombré.
     * //on prefera une boucle for.
     * //voir les commentaires ci-dessous pour voir comment faire.
     * 
     * // on ouvre un nouveau FileReader pour afficher le nouveau contenu
     * FileReader fr = new FileReader("output.txt");
     * BufferedReader br = new BufferedReader(fr);
     * // on affiche le contenu tant qu'on arrive pas à la fin du fichier
     * while ((str = br.readLine()) != null) {
     * System.out.println(str);
     * }
     * // on ferme les fichiers
     * output.close();
     * br.close();
     */
}
