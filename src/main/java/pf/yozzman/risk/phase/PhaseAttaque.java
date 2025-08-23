package pf.yozzman.risk.phase;

import java.util.Random;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.Pays;
import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

public class PhaseAttaque {

    private final Carte carte;
    private final Joueur joueur;
    private final ConsoleReader lecteur;
    private final Random rnd;

    public PhaseAttaque(Carte carte, Joueur joueur, ConsoleReader lecteur, Random rnd) {
        this.carte = carte;
        this.joueur = joueur;
        this.lecteur = lecteur;
        this.rnd = rnd;
    }

    public void executer() {
        String choix = lecteur.lireLigne("Voulez-vous attaquer ? (o/n) ");
        while (choix.equalsIgnoreCase("o")) {
            
            String from = lecteur.lireLigne("Pays attaquant (nom exact) : ");
            Pays pFrom = carte.getPaysByName(from);

            if (pFrom != null && pFrom.getProprietaire() == joueur) {
                carte.afficherCarteVoisin(pFrom);
            }

            String to = lecteur.lireLigne("Pays défenseur (nom exact) : ");
            Pays pTo = carte.getPaysByName(to);

            pFrom = carte.getPaysByName(from);
            pTo = carte.getPaysByName(to);

            if (!verifierConditions(pFrom, pTo)) {
                choix = lecteur.lireLigne("Autre attaque ? (o/n) ");
                continue;
            }

            carte.attaquer(pFrom, pTo, rnd);
            carte.afficherCarte();

            if (carte.estVictoire(joueur)) {
                ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
                break;
            }
            choix = lecteur.lireLigne("Autre attaque ? (o/n) ");
        }
    }

    private boolean verifierConditions(Pays pFrom, Pays pTo) {
        if (pFrom == null || pTo == null) {
            ConsoleWriter.println("Pays invalide.");
        } else if (pFrom.getProprietaire() != joueur) {
            ConsoleWriter.println("Ce pays ne vous appartient pas.");
        } else if (pFrom.getNombreTroupe() < 2) {
            ConsoleWriter.println("Pas assez de troupes pour attaquer (minimum 2).");
        } else if (!pFrom.estVoisin(pTo)) {
            ConsoleWriter.println("Ces pays ne sont pas voisins.");
        } else if (pTo.getProprietaire() == joueur) {
            ConsoleWriter.println("Le défenseur vous appartient déjà.");
        } else {
            return true;
        }
        return false;
    }
}
