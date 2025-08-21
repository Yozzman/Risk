package pf.yozzman.risk;

public class PhaseRenforts {
    private final Carte carte;
    private final Joueur joueur;

    public PhaseRenforts(Carte carte, Joueur joueur) {
        this.carte = carte;
        this.joueur = joueur;
    }

    public void executer() {
        int renforts = carte.calculRenforts(joueur);
        carte.distribuerRenfortsAuto(joueur, renforts);
        ConsoleWriter.println(joueur.getNom() + " reçoit " + renforts + " renfort(s).");
    }
}
