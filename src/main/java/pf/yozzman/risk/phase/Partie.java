package pf.yozzman.risk.phase;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.ListeJoueur;
import pf.yozzman.risk.util.BarreChargement;
import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

public class Partie {

    private ListeJoueur listeJoueur;
    private Carte carte;
    private ConsoleReader lecteur;
    private Random rnd;

    private boolean fin = false;
    private int tour = 1;

    public void demarrer() {
        initialiserJeu();
        bouclePrincipale();
        ConsoleWriter.println("Fin de la partie");
    }

    private void initialiserJeu() {
        lecteur = new ConsoleReader();
        rnd = new Random();

        ConsoleWriter.clearAndPrintln("Bienvenue dans notre jeu RISK");
        ConsoleWriter.println("");
        ConsoleWriter.println("");

        int nombreJoueur = lecteur.demanderNombreJoueur();
        listeJoueur = lecteur.creerJoueurs(nombreJoueur);

        carte = Carte.getInstance();
        carte.initialiserPays();
        carte.assignerPays(listeJoueur);

        BarreChargement.afficherBarre("Préparation de la partie", 50, 10);

        ConsoleWriter.println("\nLe jeu peut commencer");
    }

    private void bouclePrincipale() {
        while (!fin) {
            for (Joueur joueur : listeJoueur) {
                jouerTour(joueur);
                if (fin) break;
            }
            tour++;
        }
    }

    


    private void jouerTour(Joueur joueur) {
        ConsoleWriter.clear();
        ConsoleWriter.println("\n=== Tour " + tour + " - " + joueur.getNom() + " ===");

        List<PhaseJeu> phases = Arrays.asList(
            new PhaseRenforts(),
            new PhaseAttaque(lecteur, rnd),
            new PhaseDeplacement(lecteur)
        );

        for (PhaseJeu phase : phases) {
            phase.executer(carte, joueur);
            if (fin) return;
        }

        if (carte.estVictoire(joueur)) {
            ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
            fin = true;
        }
    }
}
