package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Province
 * 
 * 6 VP
 */
public class Province extends VictoryCard {
	
	private String description;
	
	public Province() { 
		super("Province", 8);	
		this.description = "+6 Victoires";
		
	}
	
	public int victoryValue(Player p) {
		return 6;
	}

	@Override
	public void play(Player p) {
		// TODO Auto-generated method stub
		
	}
}