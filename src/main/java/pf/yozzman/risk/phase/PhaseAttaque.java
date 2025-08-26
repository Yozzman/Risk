package pf.yozzman.risk.phase;

import java.util.List;
import java.util.Random;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.Pays;
import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

public class PhaseAttaque implements PhaseJeu{

    private final ConsoleReader lecteur;
    private final Random rnd;

    public PhaseAttaque(ConsoleReader lecteur, Random rnd) {
        this.lecteur = lecteur;
        this.rnd = rnd;
    }

    @Override
    public void executer(Carte carte, Joueur joueur) {

        carte.afficherCarte();

        String choix = lecteur.lireLigne("Voulez-vous attaquer ? (o/n) ");

        while (choix.equalsIgnoreCase("o")) {
            
            ConsoleWriter.clear();
            afficherPaysAttaquants(joueur);

            int idFrom = lecteur.lireInt("Entrez l'ID du pays attaquant : ");
            Pays paysAttaquant = carte.getPaysById(idFrom);

            if (paysAttaquant != null && paysAttaquant.getProprietaire() == joueur) {
                afficherPaysVoisins(paysAttaquant, joueur);
            }

            int idTo = lecteur.lireInt("Entrez l'ID du pays à attaqué : ");
            Pays paysAttaquer = carte.getPaysById(idTo);

            if (!verifierConditions(paysAttaquant, paysAttaquer, joueur)) {
                choix = lecteur.lireLigne("Autre attaque ? (o/n) ");
                continue;
            }

            carte.attaquer(paysAttaquant, paysAttaquer, rnd);
            lecteur.pause();

            if (carte.estVictoire(joueur)) {
                ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
                break;
            }
            choix = lecteur.lireLigne("Autre attaque ? (o/n) ");
        }
    }

    private boolean verifierConditions(Pays pFrom, Pays pTo, Joueur joueur) {
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

    private void afficherPaysVoisins(Pays pays, Joueur joueur) {
        ConsoleWriter.println("\n--- Pays voisins ennemis ---\n");
        List<Pays> voisins = pays.getVoisins();
        for (Pays voisin : voisins) {
            if (voisin.getProprietaire() == joueur) {
                continue;
            }
            ConsoleWriter.println("ID: " + voisin.getId() + " | " + voisin.getNom() + " (" + voisin.getNombreTroupe() + " troupes)");
        }
        ConsoleWriter.println("\n------------------------------------");
    }

    private void afficherPaysAttaquants(Joueur joueur) {
        ConsoleWriter.println("\n--- Vos pays prêts à l'attaque ---");
        boolean peutAttaquer = false;

        for (Pays pays : joueur.getPaysPossedes()) {
            
            if (pays.getNombreTroupe() <= 1) {
                continue;
            }

            boolean aUnVoisinEnnemi = false;
            for (Pays voisin : pays.getVoisins()) {
                if (voisin.getProprietaire() != joueur) {
                    aUnVoisinEnnemi = true;
                }
            }

            if (aUnVoisinEnnemi) {
                ConsoleWriter.println("ID: " + pays.getId() + " | " + pays.getNom() + " (" + pays.getNombreTroupe() + " troupes)");
                peutAttaquer = true;
            }
        }

        if (!peutAttaquer) {
            ConsoleWriter.println("Aucun de vos pays ne peut lancer d'attaque.");
        }
        ConsoleWriter.println("------------------------------------");
    }

}
