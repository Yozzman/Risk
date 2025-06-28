package pf.yozzman.risk;

import java.util.List;

public class Carte {
	
	private List<Pays> ListePays;

	public void initialiserPays() {

		// Amérique du nord - 9 Pays
		this.ListePays.add(new Pays("Alaska"));
		this.ListePays.add(new Pays("Territoire du Nord-Ouest"));
		this.ListePays.add(new Pays("Groenland"));
		this.ListePays.add(new Pays("Alberta"));
		this.ListePays.add(new Pays("Ontario"));
		this.ListePays.add(new Pays("Canada de l'Est"));
		this.ListePays.add(new Pays("États-Unis de l'Ouest"));
		this.ListePays.add(new Pays("États-Unis de l'Est"));
		this.ListePays.add(new Pays("Amérique Centrale"));

		// Amérique du sud - 4 Pays
		this.ListePays.add(new Pays("Vénézuela"));
		this.ListePays.add(new Pays("Brésil"));
		this.ListePays.add(new Pays("Pérou"));
		this.ListePays.add(new Pays("Argentine"));

		// Europe - 7 Pays
		this.ListePays.add(new Pays("Islande"));
		this.ListePays.add(new Pays("Scandinavie"));
		this.ListePays.add(new Pays("Grande-Bretagne"));
		this.ListePays.add(new Pays("Russie"));
		this.ListePays.add(new Pays("Europe du Nord"));
		this.ListePays.add(new Pays("Europe du Sud"));
		this.ListePays.add(new Pays("Europe de l'Ouest"));

		// Afrique - 6 Pays
		this.ListePays.add(new Pays("Afrique du Nord"));
		this.ListePays.add(new Pays("Égypte"));
		this.ListePays.add(new Pays("Afrique Orientale"));
		this.ListePays.add(new Pays("Afrique Centrale"));
		this.ListePays.add(new Pays("Afrique du Sud"));
		this.ListePays.add(new Pays("Madagascar"));

		// Asie - 12 Pays
		this.ListePays.add(new Pays("Afghanistan"));
		this.ListePays.add(new Pays("Chine"));
		this.ListePays.add(new Pays("Inde"));
		this.ListePays.add(new Pays("Irkoutsk"));
		this.ListePays.add(new Pays("Japan"));
		this.ListePays.add(new Pays("Kamchatka"));
		this.ListePays.add(new Pays("Moyen Orient"));
		this.ListePays.add(new Pays("Mongolie"));
		this.ListePays.add(new Pays("Asie du Sud-Est"));
		this.ListePays.add(new Pays("Sibérie"));
		this.ListePays.add(new Pays("Oural"));
		this.ListePays.add(new Pays("Yakoutie"));

		// Océanie - 4 Pays

		this.ListePays.add(new Pays("Australie Orientale"));
		this.ListePays.add(new Pays("Australie Occidentale"));
		this.ListePays.add(new Pays("Indonésie"));
		this.ListePays.add(new Pays("Nouvelle Guinée"));
	}
	
	public void assignerPays() {

                this.ListePays.forEach(country -> {
                        int maxCountriesInPlayer = this.players.stream().reduce( 0, (subtotal, p) -> subtotal + p.getCountries().size(), Integer::sum) /  this.players.size();
                        List<Joueur> playerWithoutMaxCountries = this.players.stream().filter(p -> p.getCountries().size() <= maxCountriesInPlayer).toList();
                        Player player = playerWithoutMaxCountries.get(RandomGenerator.getInstance().nextInt(playerWithoutMaxCountries.size()));
                        
						country.setPlayer(player);
                        country.setSoldiers(1);
                        player.addCountry(country);
                        player.dropSoldiers(1);
                });
        }



	}
}
