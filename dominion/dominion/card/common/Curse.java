package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Malédiction (Curse)
 * 
 * -1 VP
 */
public class Curse extends CurseCard {
	
	public Curse() { 
		super("Curse", 0);
	}
	
	public String toString() {
		return super.toString() + " -1 Victoire.\n";
	}
	
	public int victoryValue(Player p) {
		return -1;
	}

	
	public void play(Player p) {
	
	}
}