package pf.yozzman.risk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import pf.yozzman.risk.util.ConsoleReader;
import pf.yozzman.risk.util.ConsoleWriter;

import java.util.Collections;
import java.util.Comparator;

public class Carte {

	private static final Carte INSTANCE = new Carte();

	private List<Pays> listePays = new ArrayList<>();
	private List<Continent> listeContinent = new ArrayList<>();
	private Map<String, Pays> indexPays = new HashMap<>();

	private static final String BLUE_BACKGROUND = "\u001B[44m";
    private static final String RESET_COLOR = "\u001B[0m";

	private Carte() {
		
	}

	public static Carte getInstance() {
        return INSTANCE;
    }

	public void initialiserPays() {

		// Continents
		Continent ameriqueNord = new Continent("Amérique du Nord");
		Continent ameriqueSud = new Continent("Amérique du Sud");
		Continent europe = new Continent("Europe");
		Continent afrique = new Continent("Afrique");
		Continent asie = new Continent("Asie");
		Continent oceanie = new Continent("Océanie");

		creerEtAjouterPays(ameriqueNord, "Alaska", "Territoire du Nord-Ouest", "Groenland", "Alberta", "Ontario", "Canada de l'Est", "États-Unis de l'Ouest", "États-Unis de l'Est", "Amérique Centrale");
		creerEtAjouterPays(ameriqueSud, "Vénézuela", "Brésil", "Pérou", "Argentine");
		creerEtAjouterPays(europe, "Islande", "Scandinavie", "Grande-Bretagne", "Russie", "Europe du Nord", "Europe du Sud", "Europe de l'Ouest");
		creerEtAjouterPays(afrique, "Afrique du Nord", "Égypte", "Afrique Orientale", "Afrique Centrale", "Afrique du Sud", "Madagascar");
		creerEtAjouterPays(asie, "Afghanistan", "Chine", "Inde", "Irkoutsk", "Japan", "Kamchatka", "Moyen Orient", "Mongolie", "Asie du Sud-Est", "Sibérie", "Oural", "Yakoutie");
		creerEtAjouterPays(oceanie, "Australie Orientale", "Australie Occidentale", "Indonésie", "Nouvelle Guinée");

		listeContinent.add(ameriqueNord);
		listeContinent.add(ameriqueSud);
		listeContinent.add(europe);
		listeContinent.add(afrique);
		listeContinent.add(asie);
		listeContinent.add(oceanie);

		for (Pays p : listePays) {
        	indexPays.put(p.getNom(), p);
    	}
    	initialiserVoisins();
	}

	private void creerEtAjouterPays(Continent continent, String... nomsDePays) {
		for (String nom : nomsDePays) {
			Pays pays = new Pays.Builder(nom).build();
			addPays(pays, continent);
		}
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
		lier("Afrique du Nord", "Afrique Occidentale");
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
		lier("Japan", "Mongolie");

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
		return Math.max(3, joueur.getPaysPossedes().size() / 3);
	}

	public void distribuerRenfortsAuto(Joueur joueur, int renforts) {
		ConsoleWriter.println(joueur.getNom() + " reçoit " + renforts + " renfort(s).");

		if (joueur.getPaysPossedes().isEmpty()){
			return;
		}
	
		Random random = new Random();
		List<Pays> paysDuJoueur = joueur.getPaysPossedes();
		int nombreDePays = paysDuJoueur.size();

		ConsoleWriter.println("Distribution des renforts (Aléatoirement) :");

		while (renforts > 0) {
			int indexAleatoire = random.nextInt(nombreDePays);
			Pays paysChoisi = paysDuJoueur.get(indexAleatoire);
			
        	paysChoisi.setNombreTroupe(paysChoisi.getNombreTroupe() + 1);
        	ConsoleWriter.println("-> +1 renfort sur " + paysChoisi.getNom());
			renforts--;
		}
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

	public Pays getPaysById(int id) {
		for (Pays pays : listePays) {
			if (pays.getId() == id)
				return pays;
		}
		return null;
	}

	public boolean attaquer(Pays attaquant, Pays defense, Random rnd) {
		if (attaquant.getProprietaire() == null || defense.getProprietaire() == null)
			return false;
		if (attaquant.getProprietaire() == defense.getProprietaire())
			return false;
		if (!attaquant.estVoisin(defense))
			return false;
		if (attaquant.getNombreTroupe() < 2)
			return false;

		int desAtt = Math.min(3, attaquant.getNombreTroupe() - 1);
		int desDef = Math.min(2, defense.getNombreTroupe());

		List<Integer> a = new ArrayList<>();
		List<Integer> d = new ArrayList<>();
		for (int i = 0; i < desAtt; i++)
			a.add(rnd.nextInt(6) + 1);
		for (int i = 0; i < desDef; i++)
			d.add(rnd.nextInt(6) + 1);
		a.sort(Comparator.reverseOrder());
		d.sort(Comparator.reverseOrder());

		ConsoleWriter.println("\n--- Début de la bataille ---\n");
		ConsoleWriter.delay(100);
		ConsoleWriter.println("Attaque : " + attaquant.getNom() + " (" + desAtt + " dés) vs " + defense.getNom() + " (" + desDef + " dés)");
		ConsoleWriter.delay(100);
		ConsoleWriter.println("Dés de l'attaquant : " + a);
		ConsoleWriter.delay(100);
		ConsoleWriter.println("Dés du défenseur   : " + d);
		ConsoleWriter.delay(100);
		ConsoleWriter.println("----------------------------\n");

		int comparaisons = Math.min(a.size(), d.size());
		int pertesAttaquant = 0;
		int pertesDefenseur = 0;

		for (int i = 0; i < comparaisons; i++) {
			if (a.get(i) > d.get(i)) {
				pertesDefenseur++;
				ConsoleWriter.delay(100);
				ConsoleWriter.println("-> Dé " + (i+1) + " : L'attaquant (" + a.get(i) + ") gagne contre le défenseur (" + d.get(i) + "). Le défenseur perd 1 troupe.");
			} else {
				pertesAttaquant++;
				ConsoleWriter.delay(100);
				ConsoleWriter.println("-> Dé " + (i+1) + " : Le défenseur (" + d.get(i) + ") gagne contre l'attaquant (" + a.get(i) + "). L'attaquant perd 1 troupe.");
			}
		}

		attaquant.setNombreTroupe(attaquant.getNombreTroupe() - pertesAttaquant);
		defense.setNombreTroupe(defense.getNombreTroupe() - pertesDefenseur);
		
		ConsoleWriter.delay(100);
		ConsoleWriter.println("--- Résultat de la bataille ---");
		ConsoleWriter.println("Pertes de l'attaquant : " + pertesAttaquant);
		ConsoleWriter.println("Pertes du défenseur   : " + pertesDefenseur);
		ConsoleWriter.println(attaquant.getNom() + " a maintenant " + attaquant.getNombreTroupe() + " troupes.");
		ConsoleWriter.println(defense.getNom() + " a maintenant " + defense.getNombreTroupe() + " troupes.");
		ConsoleWriter.println("-------------------------------\n");

		 if (defense.getNombreTroupe() <= 0) {
			ConsoleWriter.println(">>> Territoire conquis ! " + attaquant.getNom() + " a vaincu toutes les troupes de " + defense.getNom() + " !");

			Joueur jAtt = attaquant.getProprietaire();
			Joueur jDef = defense.getProprietaire();

			// Mise à jour des propriétaires
			jDef.getPaysPossedes().remove(defense);
			defense.setProprietaire(jAtt);
			jAtt.addPaysPossede(defense);
			
			// Déplacement des troupes sur le nouveau territoire
			int troupesAttaquantesRestantes = attaquant.getNombreTroupe();
			ConsoleWriter.println("\nIl y a " + troupesAttaquantesRestantes + " troupe(s) restantes sur " + attaquant.getNom() + "\nCombien de troupe(s) déplacer sur " + defense.getNom() + " ?");
			int troupesADeplacer = ConsoleReader.lireInt("");
			
			attaquant.setNombreTroupe(troupesAttaquantesRestantes - troupesADeplacer);
			defense.setNombreTroupe(troupesADeplacer);

			ConsoleWriter.println(jAtt.getNom() + " a déplacé " + troupesADeplacer + " troupe(s) sur " + defense.getNom() + ".");
			
			ConsoleWriter.println(attaquant.getNom() + " a maintenant " + attaquant.getNombreTroupe() + " troupes.");
			ConsoleWriter.println(defense.getNom() + " a maintenant " + defense.getNombreTroupe() + " troupes.");

			return true;
		}

		return false;

	}

	public boolean deplacer(Pays from, Pays to, int nb) {
		if (from.getProprietaire() == null || to.getProprietaire() == null)
			return false;
		if (from.getProprietaire() != to.getProprietaire())
			return false;
		if (!from.estVoisin(to))
			return false;
		if (nb <= 0 || from.getNombreTroupe() - nb < 1)
			return false;
		from.setNombreTroupe(from.getNombreTroupe() - nb);
		to.setNombreTroupe(to.getNombreTroupe() + nb);
		return true;
	}

	public boolean estVictoire(Joueur j) {
		for (Pays p : listePays) {
			if (p.getProprietaire() != j)
				return false;
		}
		return true;
	}

	public void afficherCarteVoisin(Pays attaquant) {
	    ConsoleWriter.clear();
	    if (attaquant == null) {
	        ConsoleWriter.println("Pays attaquant invalide.");
	        return;
	    }
	    Joueur proprietaire = attaquant.getProprietaire();
	    if (proprietaire == null) {
	        ConsoleWriter.println("Le pays attaquant n'a pas de propriétaire.");
	        return;
	    }

	    Map<Continent, List<Pays>> map = new HashMap<>();
	    
	    List<Pays> voisinsEnnemis = new ArrayList<>();
	    for (Object o : attaquant.getVoisins()) {
	        Pays v = (Pays) o;
	        if (v.getProprietaire() != null && v.getProprietaire() != proprietaire) {
	            voisinsEnnemis.add(v);
	        }
	    }

	    for (Continent c : listeContinent) {
	        List<Pays> subset = new ArrayList<>();
	        for (Pays p : voisinsEnnemis) {
	            if (c.getPays().contains(p)) {
	                subset.add(p);
	            }
	        }
	        map.put(c, subset);
	    }

	    ConsoleWriter.println("=== PAYS ENNEMIS VOISINS (" + attaquant.getNom() + ") ===");
	    afficherCarte();
	}

	public void afficherCarte() {
        ConsoleWriter.println("");
        ConsoleWriter.println("=== Carte du Monde ===");
        ConsoleWriter.println("");

        for (Pays p : indexPays.values()) {
            StringBuilder ligne = new StringBuilder();
            ligne.append(p.getNom())
                 .append(" (Propriétaire: ")
                 .append(p.getProprietaire().getNom())
                 .append(" - Troupe : ")
				 .append(p.getNombreTroupe())
                 .append(") : ");

            List<Pays> voisins = p.getVoisins();
            for (Pays voisin : voisins) {
                ligne.append(voisin.getNom()).append(", ");
            }

            // Supprimer la dernière virgule et espace
            if (!voisins.isEmpty()) {
                ligne.setLength(ligne.length() - 2);
            }

            ConsoleWriter.println(ligne.toString());
        }

        ConsoleWriter.println("");

		List<String> asciiMap = new ArrayList<>(
			Arrays.asList(
            BLUE_BACKGROUND + " CARTE DU MONDE " + RESET_COLOR
        ));

        asciiMap.forEach(ConsoleWriter::println);
    }


}
