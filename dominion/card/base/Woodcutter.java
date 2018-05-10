package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bûcheron (Woodcutter)
 * 
 * +1 Achat.
 * +2 Pièces.
 */
public class Woodcutter extends ActionCard {
	
	private String description;
	
	public Woodcutter(String name, int cost) {
		super(name, cost);
		this.description = "+1 Achat, +2 Pièces";
	}
	
	public void play(Player p) {
		p.incrementActions(1);
		p.incrementMoney(2);
	}
}