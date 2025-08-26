package pf.yozzman.risk.phase;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.util.ConsoleReader;

public class PhaseRenforts implements PhaseJeu {

    private String phase = "Phase de renforts";

    @Override
    public void executer(Carte carte, Joueur joueur, int tour) {
        
        carte.afficherCarteEtInfoTour(tour, joueur, phase);

        int renforts = carte.calculRenforts(joueur);
        carte.distribuerRenfortsAuto(joueur, renforts);
        ConsoleReader.pause();
    }
}
