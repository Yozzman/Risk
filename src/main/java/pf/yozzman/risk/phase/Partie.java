package pf.yozzman.risk.phase;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.ListeJoueur;
import pf.yozzman.risk.util.BarreChargement;
import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

public class Partie {

    private ListeJoueur listeJoueur;
    private Carte carte;
    private boolean fin = false;
    private int tour = 1;

    private final PhaseJeu phaseRenforts;
    private final PhaseJeu phaseAttaque;
    private final PhaseJeu phaseDeplacement;

    public Partie() {
        this.phaseRenforts = new PhaseRenforts();
        this.phaseAttaque = new PhaseAttaque();
        this.phaseDeplacement = new PhaseDeplacement();
    }

    public void demarrer() {
        initialiserJeu();
        bouclePrincipale();
        ConsoleWriter.println("Fin de la partie");
    }

    private void initialiserJeu() {
        ConsoleWriter.clearAndPrintln("Bienvenue dans notre jeu RISK");
        ConsoleWriter.println("");

        int nombreJoueur = ConsoleReader.demanderNombreJoueur();
        listeJoueur = ConsoleReader.creerJoueurs(nombreJoueur);

        carte = Carte.getInstance();
        carte.initialiserPays();
        carte.assignerPays(listeJoueur);

        BarreChargement.afficherBarre("\nPréparation de la partie", 50, 10);

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

        if (tour > 1) {
            phaseRenforts.executer(carte, joueur, tour);
        } 
        
        phaseAttaque.executer(carte, joueur, tour);

        if (fin) return;

        phaseDeplacement.executer(carte, joueur, tour);

        if (carte.estVictoire(joueur)) {
            ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
            fin = true;
        }
    }

    public int getTour() {
        return this.tour;
    }  
}
