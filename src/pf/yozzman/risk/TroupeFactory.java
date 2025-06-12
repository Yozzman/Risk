package pf.yozzman.risk;

import java.util.Optional;

public final class TroupeFactory {
	public static int IDS = 0;
    public static int valeur;

	public static Optional<Troupe> createTroupe(TroupeType type, int valeur) {
		IDS++;
		switch (type) {
		case ShipType.SOLDAT:
			return Optional.of(new Soldat(IDS), 1); 
		case ShipType.CAVALIER:
			return Optional.of(new Cavalier(IDS), 5); 
		case ShipType.CANON:
			return Optional.of(new Canon(IDS), 10); 
		default:
			return Optional.empty();
		}
	}
}
