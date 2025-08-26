package pf.yozzman.risk.util;

import java.util.Scanner;

import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.ListeJoueur;

public class ConsoleReader {
    private static Scanner scanner = new Scanner(System.in);

    public int demanderNombreJoueur() {
        Integer nombreFinal = null;
        while (nombreFinal == null) {
            ConsoleWriter.println("Nous allons commencer une partie de RISK.");
            ConsoleWriter.print("Combien de joueurs ? ");
            ConsoleWriter.print("Entrez le nombre de joueurs (entre 2 et 5) : ");
            try {
                int entree = Integer.parseInt(scanner.nextLine().trim());
                if (entree >= 2 && entree <= 5) {
                    nombreFinal = entree;
                } else {
                    if (entree < 2) ConsoleWriter.println("Il doit y avoir au moins 2 joueurs.");
                    if (entree > 5) ConsoleWriter.println("Il doit y avoir au maximum 5 joueurs.");
                }
            } catch (NumberFormatException e) {
                ConsoleWriter.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
        return nombreFinal;
    }

    public String demanderNomJoueur(int numJoueur) {
        String nom = null;
        while (nom == null || nom.trim().isEmpty()) {
            ConsoleWriter.print("Nom du joueur " + (numJoueur) + " : ");
            nom = scanner.nextLine().trim();
        }
        return nom;
    }

    public ListeJoueur creerJoueurs(int nbJoueurs) {
        ListeJoueur liste = new ListeJoueur();
        for (int i = 0; i < nbJoueurs; i++) {
            Joueur joueur = new Joueur();
            joueur.setNom(demanderNomJoueur(i + 1));
            liste.add(joueur);
        }
        return liste;
    }

    public String lireLigne(String prompt) {
        ConsoleWriter.print(prompt);
        return scanner.nextLine();
    }

    public static int lireInt(String prompt) {
        while (true) {
            ConsoleWriter.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                ConsoleWriter.println("Nombre invalide.");
            }
        }
    }

    public void pause() {
        ConsoleWriter.print("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }
}
