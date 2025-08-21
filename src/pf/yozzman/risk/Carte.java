package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Carte {
	
	private List<Pays> listePays = new ArrayList<>();
	private List<Continent> listeContinent = new ArrayList<>();

	public void initialiserPays() {

		// Amérique du nord - 9 Pays
		Continent ameriqueNord = new Continent("Amérique du Nord");
		this.listePays.add(new Pays("Alaska"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Territoire du Nord-Ouest"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Groenland"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Alberta"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Ontario"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Canada de l'Est"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("États-Unis de l'Ouest"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("États-Unis de l'Est"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Amérique Centrale"));
        ameriqueNord.addPays(listePays.get(listePays.size() - 1));

		// Amérique du sud - 4 Pays
		Continent ameriqueSud = new Continent("Amérique du Sud");
		this.listePays.add(new Pays("Vénézuela"));
        ameriqueSud.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Brésil"));
        ameriqueSud.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Pérou"));
        ameriqueSud.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Argentine"));
        ameriqueSud.addPays(listePays.get(listePays.size() - 1));

		// Europe - 7 Pays
		Continent europe = new Continent("Europe");
		this.listePays.add(new Pays("Islande"));
        europe.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Scandinavie"));
        europe.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Grande-Bretagne"));
        europe.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Russie"));
        europe.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Europe du Nord"));
        europe.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Europe du Sud"));
        europe.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Europe de l'Ouest"));
        europe.addPays(listePays.get(listePays.size() - 1));

		// Afrique - 6 Pays
		Continent afrique = new Continent("Afrique");
		this.listePays.add(new Pays("Afrique du Nord"));
        afrique.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Égypte"));
        afrique.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Afrique Orientale"));
        afrique.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Afrique Centrale"));
        afrique.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Afrique du Sud"));
        afrique.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Madagascar"));
        afrique.addPays(listePays.get(listePays.size() - 1));

		// Asie - 12 Pays
		Continent asie = new Continent("Asie");
		this.listePays.add(new Pays("Afghanistan"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Chine"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Inde"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Irkoutsk"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Japan"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Kamchatka"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Moyen Orient"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Mongolie"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Asie du Sud-Est"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Sibérie"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Oural"));
        asie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Yakoutie"));
        asie.addPays(listePays.get(listePays.size() - 1));

		// Océanie - 4 Pays
		Continent oceanie = new Continent("Oceanie");
		this.listePays.add(new Pays("Australie Orientale"));
        oceanie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Australie Occidentale"));
        oceanie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Indonésie"));
        oceanie.addPays(listePays.get(listePays.size() - 1));
		this.listePays.add(new Pays("Nouvelle Guinée"));
        oceanie.addPays(listePays.get(listePays.size() - 1));

		listeContinent.add(ameriqueNord);
		listeContinent.add(ameriqueSud);
		listeContinent.add(europe);
		listeContinent.add(afrique);
		listeContinent.add(asie);
		listeContinent.add(oceanie);

	}
	
	public void assignerPays(ListeJoueur joueurs) {
		Random random = new Random();
		for (Pays pays : listePays) {
			int randomNumJoueur = random.nextInt(joueurs.size());
			Joueur joueur = joueurs.get(randomNumJoueur);
			pays.setProprietaire(joueur);
			joueur.addPaysPossede(pays);
			pays.setPossedeJoueur(true);
		}
	}

	public void distribuerRenforts(Joueur joueur, int renforts) {
        ConsoleWriter.println(joueur.getNom() + " reçoit " + renforts + " renfort(s).");
        for (Pays pays : joueur.getPaysPossedes()) {
            pays.setNombreTroupe(pays.getNombreTroupe() + 1);
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

	public void afficherMiniCarte() {
		 Map<String, String> abreviations = new HashMap<>();

		// Amérique du Nord
		abreviations.put("Alaska", "ALA");
		abreviations.put("Territoire du Nord-Ouest", "TNO");
		abreviations.put("Groenland", "GRO");
		abreviations.put("Alberta", "ALB");
		abreviations.put("Ontario", "ONT");
		abreviations.put("Canada de l'Est", "CDE");
		abreviations.put("États-Unis de l'Ouest", "EUO");
		abreviations.put("États-Unis de l'Est", "EUE");
		abreviations.put("Amérique Centrale", "AMC");

		// Amérique du Sud
		abreviations.put("Vénézuela", "VEN");
		abreviations.put("Brésil", "BRE");
		abreviations.put("Pérou", "PER");
		abreviations.put("Argentine", "ARG");

		// Europe
		abreviations.put("Islande", "ISL");
		abreviations.put("Scandinavie", "SCA");
		abreviations.put("Grande-Bretagne", "GBR");
		abreviations.put("Russie", "RUS");
		abreviations.put("Europe du Nord", "EUN");
		abreviations.put("Europe du Sud", "EUS");
		abreviations.put("Europe de l'Ouest", "EUO");

		// Afrique
		abreviations.put("Afrique du Nord", "AFN");
		abreviations.put("Égypte", "EGY");
		abreviations.put("Afrique Orientale", "AFO");
		abreviations.put("Afrique Centrale", "AFC");
		abreviations.put("Afrique du Sud", "AFS");
		abreviations.put("Madagascar", "MAD");

		// Asie
		abreviations.put("Afghanistan", "AFG");
		abreviations.put("Chine", "CHI");
		abreviations.put("Inde", "IND");
		abreviations.put("Irkoutsk", "IRK");
		abreviations.put("Japan", "JAP");
		abreviations.put("Kamchatka", "KAM");
		abreviations.put("Moyen Orient", "MOY");
		abreviations.put("Mongolie", "MON");
		abreviations.put("Asie du Sud-Est", "ASE");
		abreviations.put("Sibérie", "SIB");
		abreviations.put("Oural", "OUR");
		abreviations.put("Yakoutie", "YAK");

		// Océanie
		abreviations.put("Australie Orientale", "AUO");
		abreviations.put("Australie Occidentale", "AUC");
		abreviations.put("Indonésie", "INO");
		abreviations.put("Nouvelle Guinée", "NOU");

		ConsoleWriter.clear();
    	ConsoleWriter.println("=== MINI-CARTE RISK ===");

		for (Continent continent : listeContinent) {
			ConsoleWriter.println("\n--- " + continent.getNom() + " ---");
			int i = 0;
			for (Pays pays : continent.getPays()) {
				String joueur = pays.getProprietaire() == null ? "-" 
					: pays.getProprietaire().getNom().substring(0, 1);
				String abrev = abreviations.getOrDefault(pays.getNom(), pays.getNom().substring(0, 3));
				ConsoleWriter.print("[" + abrev + ":" + joueur + pays.getNombreTroupe() + "] ");
				if (++i % 4 == 0) ConsoleWriter.println("");
			}
			ConsoleWriter.println("");
		}
	}

	public List<Pays> getListePays() {
        return listePays;
    }

    public List<Continent> getContinents() {
        return listeContinent;
    }
}
