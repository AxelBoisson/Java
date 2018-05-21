package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Province
 * 
 * 6 VP
 */
public class Province extends VictoryCard {
	
	public Province() { 
		super("Province", 8);			
	}
	
	public String toString() {
		return super.toString() + " +6 Victoires.\n";
	}
	
	public int victoryValue(Player p) {
		
		return 6;
	}

	public void play(Player p) {
			
	}
}