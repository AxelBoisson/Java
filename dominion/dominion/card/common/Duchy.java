package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Duché (Duchy)
 * 
 * 3 VP
 */
public class Duchy extends VictoryCard {
	
	public Duchy() { 
		super("Duchy", 5);
	}
	
	public String toString() {
		return super.toString() + " +3 Victoires.\n";
	}
	
	public int victoryValue(Player p) {
		return 3;
	}

	
	public void play(Player p) {
		
	}
}