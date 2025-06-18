package pf.yozzman.risk;

import java.util.Optional;

import pf.yozzman.risk.Troupe.Atomique;
import pf.yozzman.risk.Troupe.Humvee;
import pf.yozzman.risk.Troupe.Soldat;
import pf.yozzman.risk.Troupe.Tank;

public final class TroupeFactory {
	public static int IDS = 0;
    public static int valeur;

	public static Optional<Troupe> createTroupe(TroupeType type, int valeur) {
		IDS++;
		switch (type) {
		case TroupeType.SOLDAT:
			return Optional.of(new Soldat(IDS), 1); 
		case TroupeType.HUMVEE:
			return Optional.of(new Humvee(IDS), 5); 
		case TroupeType.TANK:
			return Optional.of(new Tank(IDS), 10);
		case TroupeType.ATOMIQUE:
			return Optional.of(new Atomique(IDS), 20); 
		default:
			return Optional.empty();
		}
	}
}
