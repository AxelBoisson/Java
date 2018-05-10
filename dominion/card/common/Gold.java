package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Or (Gold)
 * 
 * 3 Pièces
 */
public class Gold extends TreasureCard {
	
	private String description;
	
	public Gold() { 
		super("Gold", 6);	
		this.description = "+3 Pièces";
	}
	
	public int treasureValue() {
		return 3;
	}

	
	public void play(Player p) {
		p.incrementMoney(3);
		
	}
}
