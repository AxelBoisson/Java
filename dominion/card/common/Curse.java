package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Malédiction (Curse)
 * 
 * -1 VP
 */
public class Curse extends CurseCard {
	
	private String description;
	
	public Curse() { 
		super("Curse", 0);
		this.description = "-1 Victoire";
	}
	
	public int victoryValue(Player p) {
		return -1;
	}

	
	public void play(Player p) {
		
		
	}
}