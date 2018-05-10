package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cuivre (Copper)
 * 
 * 1 Pièce
 */
public class Copper extends TreasureCard {
	
	private String description;
	
	public Copper() { 
		super("Copper", 0);	
		this.description = "+1 Pièce";
	}
	
	public int treasureValue() {
		return 1;
	}

	
	public void play(Player p) {
		p.incrementMoney(1);
		
	}

	
}
