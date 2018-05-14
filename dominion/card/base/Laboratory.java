package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Laboratoire (Laboratory)
 * 
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends ActionCard {
	
	
	
	public Laboratory() {
		super("Laboratoire",5);
	}
	
	public String toString() {
		return super.toString() + "+2 Cartes.\n" + 
				" * +1 Action.";
	}
	
	public void play(Player p) {
		p.drawCard();
		p.drawCard();
		
		p.incrementActions(1);
	}
	
	
}