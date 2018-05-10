package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Duché (Duchy)
 * 
 * 3 VP
 */
public class Duchy extends VictoryCard {
	
	private String description;
	
	public Duchy() { 
		super("Duchy", 5);
		this.description = "+3 Victoires";
	}
	
	public int victoryValue(Player p) {
		return 3;
	}

	@Override
	public void play(Player p) {
		// TODO Auto-generated method stub
		
	}
}