package pf.yozzman.risk;

import java.util.Random;

public class Jeu {
    public static void main(String[] args) {
        ConsoleReader lecteur = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        Random rnd = new Random();

        writer.clearAndPrintln("=== RISK : DISTRIBUTION DES TROUPES ET AFFICHAGE DE LA CARTE ===");

        int nombreJoueur = lecteur.demanderNombreJoueur();
        ListeJoueur joueurs = lecteur.creerJoueurs(nombreJoueur);

        Carte carte = new Carte();
        carte.initialiserPays();
        carte.assignerPays(joueurs);

        ConsoleWriter.println("Le jeu RISK est lancé !");
        writer.println("\n=== Affichage de la carte ===");
        carte.afficherMiniCarte();

        // Boucle de jeu
        boolean fin = false;
        int tour = 1;
        while (!fin) {
            for (Joueur joueur : joueurs) {
                writer.println("\n=== Tour " + tour + " - " + joueur.getNom() + " ===");
                // Renforts
                int renforts = carte.calculRenforts(joueur);
                carte.distribuerRenfortsAuto(joueur, renforts);
                carte.afficherMiniCarte();

                // Phase d'attaque (optionnelle)
                String choix = lecteur.lireLigne("Voulez-vous attaquer ? (o/n) ");
                while (choix.equalsIgnoreCase("o")) {
                    String from = lecteur.lireLigne("Pays attaquant (nom exact) : ");
                    String to = lecteur.lireLigne("Pays défenseur (nom exact) : ");
                    Pays pFrom = carte.getPaysByName(from);
                    Pays pTo = carte.getPaysByName(to);
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
                        carte.attaquer(pFrom, pTo, rnd);
                        carte.afficherMiniCarte();
                        // Victoire ?
                        if (carte.estVictoire(joueur)) {
                            ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
                            fin = true;
                            break;
                        }
                    }
                    choix = lecteur.lireLigne("Autre attaque ? (o/n) ");
                }
                if (fin) break;

                // Déplacement (optionnel)
                String dep = lecteur.lireLigne("Voulez-vous déplacer des troupes ? (o/n) ");
                if (dep.equalsIgnoreCase("o")) {
                    String from = lecteur.lireLigne("Pays source : ");
                    String to = lecteur.lireLigne("Pays destination (voisin) : ");
                    int nb = lecteur.lireInt("Nombre de troupes à déplacer : ");
                    Pays pFrom = carte.getPaysByName(from);
                    Pays pTo = carte.getPaysByName(to);
                    if (pFrom == null || pTo == null) {
                        ConsoleWriter.println("Pays invalide.");
                    } else if (pFrom.getProprietaire() != joueur || pTo.getProprietaire() != joueur) {
                        ConsoleWriter.println("Les deux pays doivent vous appartenir.");
                    } else if (!pFrom.estVoisin(pTo)) {
                        ConsoleWriter.println("Les pays ne sont pas voisins.");
                    } else if (!carte.deplacer(pFrom, pTo, nb)) {
                        ConsoleWriter.println("Déplacement impossible (au moins 1 troupe doit rester).");
                    } else {
                        ConsoleWriter.println("Déplacement effectué.");
                        carte.afficherMiniCarte();
                    }
                }

                // Vérification victoire fin de tour
                if (carte.estVictoire(joueur)) {
                    ConsoleWriter.println("Victoire de " + joueur.getNom() + " !");
                    fin = true;
                    break;
                }
            }
            tour++;
        }

        writer.println("=== FIN ===");
    }
}
