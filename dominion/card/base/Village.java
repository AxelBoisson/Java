package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Village
 * 
 * +1 Carte.
 * +2 Actions.
 */
public class Village extends ActionCard {

	public Village(String name, int cost) {
		super(name, cost);
		
	}
	
	public void play(Player p) {
		p.incrementActions(2);
		p.drawCard();
		
	}
	
}