package pf.yozzman.risk.phase;

import java.util.List;
import java.util.stream.Collectors;

import pf.yozzman.risk.model.Carte;
import pf.yozzman.risk.model.Joueur;
import pf.yozzman.risk.model.Pays;
import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

public class PhaseDeplacement implements PhaseJeu{
    
    private String phase = "Phase de déplacement";

    public PhaseDeplacement() {
    }

    @Override
    public void executer(Carte carte, Joueur joueur, int tour) {
        String choix;

        while (true) {

            carte.afficherCarteEtInfoTour(tour, joueur, phase);

            choix = ConsoleReader.lireLigne("Voulez-vous déplacer des troupes ? (o/n) ");

            if (!choix.equalsIgnoreCase("o")) {
                break;
            }

            String choix2;

            while (true) {

                carte.afficherCarteEtInfoTour(tour, joueur, phase);

                List<Pays> paysSourcesPossibles = afficherPaysSources(joueur);
                if (paysSourcesPossibles.isEmpty()) {
                    ConsoleWriter.println("Vous n'avez aucun pays depuis lequel vous pouvez déplacer des troupes.");
                    ConsoleReader.pause();
                    break;
                }

                Pays pFrom = null;
                while (pFrom == null) {
                    int idFrom = ConsoleReader.lireInt("ID du pays de départ : ");
                    Pays tempPFrom = carte.getPaysById(idFrom);
                    if (tempPFrom != null && paysSourcesPossibles.contains(tempPFrom)) {
                        pFrom = tempPFrom;
                    } else {
                        ConsoleWriter.println("ID invalide. Veuillez choisir un pays depuis la liste ci-dessus.");
                    }
                }

                carte.afficherCarteEtInfoTour(tour, joueur, phase);

                List<Pays> paysDestinationsPossibles = afficherPaysDestinations(pFrom);
                if (paysDestinationsPossibles.isEmpty()) {
                    ConsoleWriter.println("Ce pays n'a aucun voisin allié vers lequel déplacer des troupes.");
                    ConsoleReader.pause();
                    continue;
                }

                Pays pTo = null;
                while (pTo == null) {
                    int idTo = ConsoleReader.lireInt("ID du pays de destination : ");
                    Pays tempPTo = carte.getPaysById(idTo);
                    if (tempPTo != null && paysDestinationsPossibles.contains(tempPTo)) {
                        pTo = tempPTo;
                    } else {
                        ConsoleWriter.println("ID invalide. Veuillez choisir un pays de la liste des voisins.");
                    }
                }

                carte.afficherCarteEtInfoTour(tour, joueur, phase);

                int nbMax = pFrom.getNombreTroupe() - 1;
                ConsoleWriter.println("Vous pouvez déplacer jusqu'à " + nbMax + " troupe(s).");
                int nb = ConsoleReader.lireInt("Nombre de troupes à déplacer : ");


                if (nb > 0 && nb <= nbMax) {
                    if (carte.deplacer(pFrom, pTo, nb)) {

                        carte.afficherCarteEtInfoTour(tour, joueur, phase);

                        ConsoleWriter.println("Déplacement de " + nb + " troupe(s) de " + pFrom.getNom() + " vers " + pTo.getNom() + " effectué.");
                    }
                } else {
                    carte.afficherCarteEtInfoTour(tour, joueur, phase);

                    ConsoleWriter.println("Nombre de troupes invalide. Le déplacement est annulé.");
                }

                choix2 = ConsoleReader.lireLigne("\nVoulez-vous déplacer à nouveau des troupes? (o/n) ");

                if (!choix2.equalsIgnoreCase("o")) {
                    choix = "n";
                    break;
                }
            }
        
        if (!choix.equalsIgnoreCase("o")) {
            break;
        }

        }
    }

    private List<Pays> afficherPaysSources(Joueur joueur) {
        ConsoleWriter.println("--- La liste de vos pays pouvant déplacer des troupes ---\n ");
        List<Pays> paysPossibles = joueur.getPaysPossedes().stream()
            .filter(p -> p.getNombreTroupe() > 1 && aVoisinAllie(p, joueur))
            .collect(Collectors.toList());

        if (paysPossibles.isEmpty()) {
            ConsoleWriter.println("Aucun pays ne remplit les conditions pour un déplacement.");
        } else {
            for (Pays pays : paysPossibles) {
                ConsoleWriter.println("ID: " + pays.getId() + " | " + pays.getNom() + " (" + pays.getNombreTroupe() + " troupes)");
            }
        }
        ConsoleWriter.println("\n-------------------------------------------");
        return paysPossibles;
    }

    private boolean aVoisinAllie(Pays pays, Joueur joueur) {
        return pays.getVoisins().stream().anyMatch(v -> v.getProprietaire() == joueur);
    }

    private List<Pays> afficherPaysDestinations(Pays paysSource) {
        ConsoleWriter.println("--- Déplacer vers (voisins alliés) ---\n");
        List<Pays> destinationsPossibles = paysSource.getVoisins().stream()
            .filter(v -> v.getProprietaire() == paysSource.getProprietaire())
            .collect(Collectors.toList());

        for (Pays voisin : destinationsPossibles) {
            ConsoleWriter.println("ID: " + voisin.getId() + " | " + voisin.getNom() + " (" + voisin.getNombreTroupe() + " troupes)");
        }
        ConsoleWriter.println("\n----------------------------------------");
        return destinationsPossibles;
    }

}
