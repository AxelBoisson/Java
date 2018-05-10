package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Domaine (Estate)
 * 
 * 1 VP
 */
public class Estate extends VictoryCard {
	
	private String description;
	
	public Estate() { 
		super("Estate", 2);	
		this.description = "+1 Victoire";
		
	}
	
	public int victoryValue(Player p) {
		return 1;
	}

	@Override
	public void play(Player p) {
		// TODO Auto-generated method stub
		
	}
}