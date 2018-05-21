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

	public Village() {
		super("Village", 3);
	}
	
	public String toString() {
		return super.toString() + " Effet: +1 Carte" + 
				" +2 Actions.\n";
	}
	
	public void play(Player p) {
		// Incrémente le nombre d'actions de 2
		p.incrementActions(2);
		// Le joueur pioche une fois
		p.addHand(p.drawCard());
		
	}
	
}