package pf.yozzman.risk.phase;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;

public interface PhaseJeu {
    void executer(Carte carte, Joueur joueur, int tour);
}
