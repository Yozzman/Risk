package pf.yozzman.risk.phase;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.util.ConsoleWriter;

public class PhaseRenforts implements PhaseJeu {

    @Override
    public void executer(Carte carte, Joueur joueur) {
        int renforts = carte.calculRenforts(joueur);
        carte.distribuerRenfortsAuto(joueur, renforts);
    }
}
