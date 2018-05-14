package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {
	
	public Chancellor() { 
		super("Chancellier", 3);	
	}
	
	public String toString() {
		return super.toString() + "+2 Pièces.\n" + 
				" * Vous pouvez immédiatement défausser votre deck.";
	}
	
	public void play(Player p) {
		p.incrementMoney(2);
		
		Card c;
		CardList total = new CardList();
		total = p.totalCards();
		for(int i = 0;i < total.size();i++) {
			c = total.get(i);
			p.setDiscard(c);	
		}
		
		
	}
	
}