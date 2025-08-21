package pf.yozzman.risk;

import java.util.Random;

public class PhaseJeu {

    private final ListeJoueur joueurs;
    private final Carte carte;
    private final ConsoleReader lecteur;
    private final Random rnd;

    private boolean fin = false;
    private int tour = 1;

    public PhaseJeu(ListeJoueur joueurs, Carte carte, ConsoleReader lecteur, Random rnd) {
        this.joueurs = joueurs;
        this.carte = carte;
        this.lecteur = lecteur;
        this.rnd = rnd;
    }

    public void demarrer() {
        while (!fin) {
            for (Joueur joueur : joueurs) {
                jouerTour(joueur);
                if (fin) break;
            }
            tour++;
        }
    }

    private void jouerTour(Joueur joueur) {
        ConsoleWriter.println("\n=== Tour " + tour + " - " + joueur.getNom() + " ===");

        // Chaque phase est déléguée à une classe dédiée
        new PhaseRenforts(carte, joueur).executer();
        carte.afficherMiniCarte();

        new PhaseAttaque(carte, joueur, lecteur, rnd).executer();
        if (fin) return;

        new PhaseDeplacement(carte, joueur, lecteur).executer();

        // Vérification victoire
        if (carte.estVictoire(joueur)) {
            ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
            fin = true;
        }
    }
}
