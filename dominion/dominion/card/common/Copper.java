package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cuivre (Copper)
 * 
 * 1 Pièce
 */
public class Copper extends TreasureCard {
	
	public Copper() { 
		super("Copper", 0);	
	}
	
	public String toString() {
		return super.toString() + " Effet: +1 Pièce.\n";
	}
	
	public int treasureValue() {
		return 1;
	}

	public void play(Player p) {
		p.incrementMoney(1);
	}

	
}
