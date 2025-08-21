package pf.yozzman.risk.phase;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.Pays;
import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

public class PhaseDeplacement {

    private final Carte carte;
    private final Joueur joueur;
    private final ConsoleReader lecteur;

    public PhaseDeplacement(Carte carte, Joueur joueur, ConsoleReader lecteur) {
        this.carte = carte;
        this.joueur = joueur;
        this.lecteur = lecteur;
    }

    public void executer() {
        String dep = lecteur.lireLigne("Voulez-vous déplacer des troupes ? (o/n) ");
        if (!dep.equalsIgnoreCase("o")) return;

        String from = lecteur.lireLigne("Pays source : ");
        String to = lecteur.lireLigne("Pays destination (voisin) : ");
        int nb = lecteur.lireInt("Nombre de troupes à déplacer : ");

        Pays pFrom = carte.getPaysByName(from);
        Pays pTo = carte.getPaysByName(to);

        if (!verifierConditions(pFrom, pTo, nb)) return;

        if (carte.deplacer(pFrom, pTo, nb)) {
            ConsoleWriter.println("Déplacement effectué.");
            carte.afficherCarte();
        } else {
            ConsoleWriter.println("Déplacement impossible (au moins 1 troupe doit rester).");
        }
    }

    private boolean verifierConditions(Pays pFrom, Pays pTo, int nb) {
        if (pFrom == null || pTo == null) {
            ConsoleWriter.println("Pays invalide.");
        } else if (pFrom.getProprietaire() != joueur || pTo.getProprietaire() != joueur) {
            ConsoleWriter.println("Les deux pays doivent vous appartenir.");
        } else if (!pFrom.estVoisin(pTo)) {
            ConsoleWriter.println("Les pays ne sont pas voisins.");
        } else if (nb <= 0) {
            ConsoleWriter.println("Nombre de troupes invalide.");
        } else {
            return true;
        }
        return false;
    }
}
