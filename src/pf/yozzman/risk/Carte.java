package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

public class Carte {

    private List<Pays> listePays = new ArrayList<>();
    private List<Continent> listeContinent = new ArrayList<>();
    private Map<String, Pays> indexPays = new HashMap<>();

    public void initialiserPays() {
        // Continents
        Continent ameriqueNord = new Continent("Amérique du Nord");
        Continent ameriqueSud = new Continent("Amérique du Sud");
        Continent europe = new Continent("Europe");
        Continent afrique = new Continent("Afrique");
        Continent asie = new Continent("Asie");
        Continent oceanie = new Continent("Océanie");

        // Helper
        java.util.function.Consumer<String> addAN = n -> { Pays p = new Pays(n); addPays(p, ameriqueNord); };
        java.util.function.Consumer<String> addAS = n -> { Pays p = new Pays(n); addPays(p, ameriqueSud); };
        java.util.function.Consumer<String> addEU = n -> { Pays p = new Pays(n); addPays(p, europe); };
        java.util.function.Consumer<String> addAF = n -> { Pays p = new Pays(n); addPays(p, afrique); };
        java.util.function.Consumer<String> addASIE = n -> { Pays p = new Pays(n); addPays(p, asie); };
        java.util.function.Consumer<String> addOC = n -> { Pays p = new Pays(n); addPays(p, oceanie); };

        // Amérique du nord - 9
        addAN.accept("Alaska");
        addAN.accept("Territoire du Nord-Ouest");
        addAN.accept("Groenland");
        addAN.accept("Alberta");
        addAN.accept("Ontario");
        addAN.accept("Canada de l'Est");
        addAN.accept("États-Unis de l'Ouest");
        addAN.accept("États-Unis de l'Est");
        addAN.accept("Amérique Centrale");

        // Amérique du sud - 4
        addAS.accept("Vénézuela");
        addAS.accept("Brésil");
        addAS.accept("Pérou");
        addAS.accept("Argentine");

        // Europe - 7
        addEU.accept("Islande");
        addEU.accept("Scandinavie");
        addEU.accept("Grande-Bretagne");
        addEU.accept("Russie");
        addEU.accept("Europe du Nord");
        addEU.accept("Europe du Sud");
        addEU.accept("Europe de l'Ouest");

        // Afrique - 6
        addAF.accept("Afrique du Nord");
        addAF.accept("Égypte");
        addAF.accept("Afrique Orientale");
        addAF.accept("Afrique Centrale");
        addAF.accept("Afrique du Sud");
        addAF.accept("Madagascar");

        // Asie - 12
        addASIE.accept("Afghanistan");
        addASIE.accept("Chine");
        addASIE.accept("Inde");
        addASIE.accept("Irkoutsk");
        addASIE.accept("Japan");
        addASIE.accept("Kamchatka");
        addASIE.accept("Moyen Orient");
        addASIE.accept("Mongolie");
        addASIE.accept("Asie du Sud-Est");
        addASIE.accept("Sibérie");
        addASIE.accept("Oural");
        addASIE.accept("Yakoutie");

        // Océanie - 4
        addOC.accept("Australie Orientale");
        addOC.accept("Australie Occidentale");
        addOC.accept("Indonésie");
        addOC.accept("Nouvelle Guinée");

        listeContinent.add(ameriqueNord);
        listeContinent.add(ameriqueSud);
        listeContinent.add(europe);
        listeContinent.add(afrique);
        listeContinent.add(asie);
        listeContinent.add(oceanie);

        // Index pour accès rapide par nom
        for (Pays p : listePays) indexPays.put(p.getNom(), p);

        initialiserVoisins();
    }

    private void addPays(Pays p, Continent c) {
        listePays.add(p);
        c.addPays(p);
    }

    private void lier(String a, String b) {
        Pays pa = indexPays.get(a);
        Pays pb = indexPays.get(b);
        if (pa != null && pb != null) {
            pa.addVoisin(pb);
            pb.addVoisin(pa);
        }
    }

    private void initialiserVoisins() {
        // Amérique du Nord
        lier("Alaska", "Territoire du Nord-Ouest");
        lier("Alaska", "Kamchatka");
        lier("Territoire du Nord-Ouest", "Alberta");
        lier("Territoire du Nord-Ouest", "Ontario");
        lier("Territoire du Nord-Ouest", "Groenland");
        lier("Groenland", "Ontario");
        lier("Groenland", "Canada de l'Est");
        lier("Alberta", "Ontario");
        lier("Alberta", "États-Unis de l'Ouest");
        lier("Ontario", "États-Unis de l'Est");
        lier("Ontario", "Canada de l'Est");
        lier("États-Unis de l'Ouest", "États-Unis de l'Est");
        lier("États-Unis de l'Ouest", "Amérique Centrale");
        lier("États-Unis de l'Est", "Amérique Centrale");
        // Connexions intercontinentales
        lier("Groenland", "Islande");
        lier("Amérique Centrale", "Vénézuela");

        // Amérique du Sud
        lier("Vénézuela", "Brésil");
        lier("Vénézuela", "Pérou");
        lier("Brésil", "Pérou");
        lier("Brésil", "Argentine");

        // Europe
        lier("Islande", "Grande-Bretagne");
        lier("Grande-Bretagne", "Scandinavie");
        lier("Grande-Bretagne", "Europe du Nord");
        lier("Europe du Nord", "Scandinavie");
        lier("Europe du Nord", "Europe de l'Ouest");
        lier("Europe du Nord", "Europe du Sud");
        lier("Europe du Sud", "Europe de l'Ouest");
        lier("Russie", "Scandinavie");
        lier("Russie", "Europe du Nord");
        lier("Russie", "Moyen Orient");
        lier("Russie", "Oural");

        // Europe vers Afrique
        lier("Europe du Sud", "Afrique du Nord");
        lier("Europe du Sud", "Égypte");

        // Afrique
        lier("Afrique du Nord", "Égypte");
        lier("Afrique du Nord", "Afrique Occidentale"); // Remplacé par "Afrique Centrale" et "Afrique Orientale" dans ce set
        // Correction adaptée:
        lier("Afrique du Nord", "Afrique Centrale");
        lier("Égypte", "Afrique Orientale");
        lier("Afrique Centrale", "Afrique Orientale");
        lier("Afrique Centrale", "Afrique du Sud");
        lier("Afrique Orientale", "Afrique du Sud");
        lier("Afrique Orientale", "Madagascar");

        // Afrique vers AmSud
        lier("Brésil", "Afrique du Nord");

        // Asie
        lier("Oural", "Sibérie");
        lier("Oural", "Afghanistan");
        lier("Sibérie", "Yakoutie");
        lier("Sibérie", "Irkoutsk");
        lier("Yakoutie", "Kamchatka");
        lier("Irkoutsk", "Kamchatka");
        lier("Irkoutsk", "Mongolie");
        lier("Mongolie", "Chine");
        lier("Mongolie", "Kamchatka");
        lier("Chine", "Sibérie");
        lier("Chine", "Afghanistan");
        lier("Chine", "Asie du Sud-Est");
        lier("Chine", "Inde");
        lier("Afghanistan", "Inde");
        lier("Afghanistan", "Moyen Orient");
        lier("Moyen Orient", "Inde");
        lier("Japan", "Kamchatka");
        lier("Japan", "Mongolie"); // accès via mer simplifié

        // Asie vers Océanie
        lier("Asie du Sud-Est", "Indonésie");

        // Océanie
        lier("Indonésie", "Nouvelle Guinée");
        lier("Nouvelle Guinée", "Australie Orientale");
        lier("Australie Orientale", "Australie Occidentale");
        lier("Indonésie", "Australie Occidentale");
    }

    public void assignerPays(ListeJoueur joueurs) {
        List<Pays> copie = new ArrayList<>(listePays);
        Collections.shuffle(copie, new Random());
        int i = 0;
        for (Pays pays : copie) {
            Joueur joueur = joueurs.get(i % joueurs.size());
            pays.setProprietaire(joueur);
            joueur.addPaysPossede(pays);
            pays.setPossedeJoueur(true);
            i++;
        }
    }

    public int calculRenforts(Joueur joueur) {
        int nb = Math.max(3, joueur.getPaysPossedes().size() / 3);
        return nb;
    }

    public void distribuerRenfortsAuto(Joueur joueur, int renforts) {
        ConsoleWriter.println(joueur.getNom() + " reçoit " + renforts + " renfort(s).");
        if (joueur.getPaysPossedes().isEmpty()) return;
        int idx = 0;
        while (renforts > 0) {
            Pays p = joueur.getPaysPossedes().get(idx % joueur.getPaysPossedes().size());
            p.setNombreTroupe(p.getNombreTroupe() + 1);
            renforts--;
            idx++;
        }
    }

    public void afficherCarte() {
        ConsoleWriter.clear();
        for (Pays pays : listePays) {
            String proprietaire = pays.getProprietaire() == null ? "--" : pays.getProprietaire().getNom();
            ConsoleWriter.println(pays.getNom() + " (Proprietaire : " + proprietaire +
                    ", Troupes : " + pays.getNombreTroupe() + ")");
        }
    }

    private String padRight(String s, int n) {
		if (s == null) s = "";
		if (s.length() >= n) return s.substring(0, n);
		StringBuilder sb = new StringBuilder(s);
		while (sb.length() < n) sb.append(' ');
		return sb.toString();
	}

	public void afficherMiniCarte() {
		ConsoleWriter.clear();
		ConsoleWriter.println("=== CARTE RISK (noms complets, propriétaire, troupes) ===");
		// Déterminer largeur max pour aligner proprement
		int maxNom = 0, maxProp = 0;
		for (Continent c : listeContinent) {
			for (Pays p : c.getPays()) {
				maxNom = Math.max(maxNom, p.getNom().length());
				String proprietaire = (p.getProprietaire() == null) ? "--" : p.getProprietaire().getNom();
				maxProp = Math.max(maxProp, proprietaire.length());
			}
		}
		maxNom = Math.min(maxNom, 28);   // éviter des colonnes trop larges
		maxProp = Math.min(maxProp, 20);

		for (Continent continent : listeContinent) {
			ConsoleWriter.println("\n--- " + continent.getNom() + " ---");
			for (Pays pays : continent.getPays()) {
				String proprietaire = (pays.getProprietaire() == null) ? "--" : pays.getProprietaire().getNom();
				String ligne = padRight(pays.getNom(), maxNom) + " | "
							+ padRight(proprietaire, maxProp) + " | "
							+ "Troupes: " + pays.getNombreTroupe();
				ConsoleWriter.println(ligne);
			}
		}
		ConsoleWriter.println("");
	}



    public List<Pays> getListePays() {
        return listePays;
    }

    public List<Continent> getContinents() {
        return listeContinent;
    }

    public Pays getPaysByName(String nom) {
        return indexPays.get(nom);
    }

    // Combat simple avec dés
    public boolean attaquer(Pays attaquant, Pays defense, Random rnd) {
        if (attaquant.getProprietaire() == null || defense.getProprietaire() == null) return false;
        if (attaquant.getProprietaire() == defense.getProprietaire()) return false;
        if (!attaquant.estVoisin(defense)) return false;
        if (attaquant.getNombreTroupe() < 2) return false; // besoin d'au moins 2 pour attaquer

        int desAtt = Math.min(3, attaquant.getNombreTroupe() - 1);
        int desDef = Math.min(2, defense.getNombreTroupe());

        List<Integer> a = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < desAtt; i++) a.add(rnd.nextInt(6) + 1);
        for (int i = 0; i < desDef; i++) d.add(rnd.nextInt(6) + 1);
        a.sort(Comparator.reverseOrder());
        d.sort(Comparator.reverseOrder());

        ConsoleWriter.println("Attaque: " + attaquant.getNom() + " (" + desAtt + " dés) contre " + defense.getNom() + " (" + desDef + " dés)");
        ConsoleWriter.println("Dés attaquant: " + a + " | Défenseur: " + d);

        int comparaisons = Math.min(a.size(), d.size());
        for (int i = 0; i < comparaisons; i++) {
            if (a.get(i) > d.get(i)) {
                defense.setNombreTroupe(defense.getNombreTroupe() - 1);
            } else {
                attaquant.setNombreTroupe(attaquant.getNombreTroupe() - 1);
            }
        }

        if (defense.getNombreTroupe() <= 0) {
            // Conquête
            Joueur jAtt = attaquant.getProprietaire();
            Joueur jDef = defense.getProprietaire();
            jDef.getPaysPossedes().remove(defense);
            defense.setProprietaire(jAtt);
            jAtt.addPaysPossede(defense);
            defense.setPossedeJoueur(true);

            // Déplacer au moins 1 troupe
            int deplace = Math.min(desAtt, attaquant.getNombreTroupe() - 1);
            deplace = Math.max(deplace, 1);
            attaquant.setNombreTroupe(attaquant.getNombreTroupe() - deplace);
            defense.setNombreTroupe(deplace);

            ConsoleWriter.println("Conquête de " + defense.getNom() + " !");
            return true;
        }
        return false;
    }

    public boolean deplacer(Pays from, Pays to, int nb) {
        if (from.getProprietaire() == null || to.getProprietaire() == null) return false;
        if (from.getProprietaire() != to.getProprietaire()) return false;
        if (!from.estVoisin(to)) return false;
        if (nb <= 0 || from.getNombreTroupe() - nb < 1) return false;
        from.setNombreTroupe(from.getNombreTroupe() - nb);
        to.setNombreTroupe(to.getNombreTroupe() + nb);
        return true;
    }

    public boolean estVictoire(Joueur j) {
        for (Pays p : listePays) {
            if (p.getProprietaire() != j) return false;
        }
        return true;
    }
}
