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
	
	private String description;
	
	public Market() {
		super("Marché",2);
		this.description = "+1 Carte. +1 Action. +1 Achat. +1 Pièce";
	}
	
	public void play(Player p) {
		p.drawCard();
		p.incrementActions(1);
		p.incrementBuys(1);
		p.incrementMoney(1);
	}
}