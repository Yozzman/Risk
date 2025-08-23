package pf.yozzman.risk.phase;

import java.util.Random;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.ListeJoueur;
import pf.yozzman.risk.util.BarreChargement;
import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

public class Partie {

    private ListeJoueur joueurs;
    private Carte carte;
    private ConsoleReader lecteur;
    private Random rnd;

    private boolean fin = false;
    private int tour = 1;

    public void demarrer() {
        initialiserJeu();
        bouclePrincipale();
        ConsoleWriter.println("=== FIN ===");
    }

    private void bouclePrincipale() {
        while (!fin) {
            for (Joueur joueur : joueurs) {
                jouerTour(joueur);
                if (fin) break;
            }
            tour++;
        }
    }

    private void initialiserJeu() {
        lecteur = new ConsoleReader();
        rnd = new Random();

        ConsoleWriter.clearAndPrintln("--------     Bienvenue dans notre jeu RISK    --------");
        ConsoleWriter.println("--------                                      --------");
        ConsoleWriter.println("");

        int nombreJoueur = lecteur.demanderNombreJoueur();
        joueurs = lecteur.creerJoueurs(nombreJoueur);

        carte = new Carte();
        carte.initialiserPays();
        carte.assignerPays(joueurs);

        BarreChargement.afficherBarre("Préparation des joueurs", 50, 10);
        BarreChargement.afficherBarre("Chargement de la carte", 50, 50);

        ConsoleWriter.println("\nLe jeu peut commencer");
    }


    private void jouerTour(Joueur joueur) {
        ConsoleWriter.clear();
        ConsoleWriter.println("\n=== Tour " + tour + " - " + joueur.getNom() + " ===");

        new PhaseRenforts(carte, joueur).executer();
        //carte.afficherCarte();

        carte.afficherCarteAttaquant(joueur);
        new PhaseAttaque(carte, joueur, lecteur, rnd).executer();
        if (fin) return;

        new PhaseDeplacement(carte, joueur, lecteur).executer();

        if (carte.estVictoire(joueur)) {
            ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
            fin = true;
        }
    }
}
