package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Marché (Market)
 * 
 * +1 Carte.
 * +1 Action.
 * +1 Achat.
 * +1 Pièce.
 */
public class Market extends ActionCard {
	
	public Market() {
		super("Market",5);
	}
	
	public String toString() {
		return super.toString() + " Effet: +1 Carte." + 
				" +1 Action." + 
				" +1 Achat." + 
				" +1 Pièce.\n";
	}
	
	public void play(Player p) {
		// Le joueur pioche une fois
		p.addHand(p.drawCard());
		// Incrémente le nombre d'action de 1
		p.incrementActions(1);
		// Incrémente le nombre d'achat de 1
		p.incrementBuys(1);
		// Incrémente le nombre de pièce de 1
		p.incrementMoney(1);
	}
}