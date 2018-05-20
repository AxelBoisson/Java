package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bûcheron (Woodcutter)
 * 
 * +1 Achat.
 * +2 Pièces.
 */
public class Woodcutter extends ActionCard {
	
	public Woodcutter() {
		super("Woodcutter", 3);
	}
	
	public String toString() {
		return super.toString() + " +1 Achat.\n" + " +2 Pièces.";
	}
	
	public void play(Player p) {
		// Incrémente le nombre d'achat de 1
		p.incrementBuys(1);
		// Incrémente le nombre de pièces de 2
		p.incrementMoney(2);
	}
}