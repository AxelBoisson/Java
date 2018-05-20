package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festival
 * 
 * +2 Actions.
 * +1 Achat.
 * +2 Pièces.
 */
public class Festival extends ActionCard {
		
	public Festival() { 
		super("Festival", 2);	
	}
	
	public String toString() {
		return super.toString() + "+2 Actions." + 
				" +1 Achat." + 
				" +2 Pièces.";
	}
	
	public void play(Player p) {
		// Incrémente le nombre d'action de 2
		p.incrementActions(2);
		// Incrémente le nombre d'achat de 1
		p.incrementBuys(1);
		// Incrémente le nombre de pièce de 2
		p.incrementMoney(2);
	}
	
	
}