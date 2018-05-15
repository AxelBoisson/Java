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
				"Vous pouvez immédiatement défausser votre deck.";
	}
	
	public void play(Player p) {
		p.incrementMoney(2);
		
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		String decision;
		Card c;
		CardList total = new CardList();
		total = p.totalCards();
		
		decision = p.choose("Voulez vous défausser votre deck", choice, false);
		
		for(int i = 0;i < total.size();i++) {
				if(decision.equals("y")){
					c = total.get(i);
					p.setDiscard(c);
			}
		}
		
		
	}
	
}