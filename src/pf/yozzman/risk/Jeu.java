package pf.yozzman.risk;

import java.util.Random;

public class Jeu {
    public static void main(String[] args) {

        ConsoleReader lecteur = new ConsoleReader();
        Random rnd = new Random();

        ConsoleWriter.clearAndPrintln("--------     Bienvenue dans notre jeu RISK    --------");
        ConsoleWriter.println("--------                                      --------");
        ConsoleWriter.println("");

        int nombreJoueur = lecteur.demanderNombreJoueur();
        ListeJoueur joueurs = lecteur.creerJoueurs(nombreJoueur);

        Carte carte = new Carte();
        carte.initialiserPays();
        carte.assignerPays(joueurs);

        BarreChargement.afficherBarre("Préparation des joueurs", 50, 10);
        BarreChargement.afficherBarre("Chargement de la carte", 50, 50);

        
        ConsoleWriter.println("\nLe jeu peut commencer");
        ConsoleWriter.println("\n-------- Affichage de la carte --------");

        // Lancement de la phase de jeu
        PhaseJeu phase = new PhaseJeu(joueurs, carte, lecteur, rnd);
        
        phase.demarrer();

        ConsoleWriter.println("=== FIN ===");
    }
}
