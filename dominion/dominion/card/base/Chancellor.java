package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck (pioche).
 */
public class Chancellor extends ActionCard {
	
	public Chancellor() { 
		super("Chancellor", 3);	
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
		String decision = "init";
		CardList totalDraw = new CardList();
		for(Card c : p.getDraw()){
			if(c != null){
				totalDraw.add(c);
			}
		}

		decision = p.choose("Voulez vous défausser votre deck", choice, false);
		
		if(decision != "" && decision.equalsIgnoreCase("y")){
			for(int i = 0;i < totalDraw.size();i++) {
				p.setDiscard(p.drawCard());
			}
		}
		
		
	}
	
}