package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {
	
	public Remodel() {
		super("Rénovation",4);
	}
	
	public String toStrin() {
		return super.toString() + "Écartez une carte de votre main.\n" + 
				" * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.";
	}
	
	public void play(Player p) {
		String decision;
		Card c;
		CardList totalCardAvailable = new CardList();
		CardList cardAvailable = new CardList();
		totalCardAvailable = p.getGame().availableSupplyCards();
		
		decision = p.chooseCard("Choisissez la carte que vous voulez écarter", p.cardsInHand(), true);
		if(!decision.equals("")) {
			c = p.cardsInHand().getCard(decision);
			p.setDiscard(c);
			for(int i = 0; i<totalCardAvailable.size();i++) {
				if(totalCardAvailable.get(i).getCost() <= c.getCost()+2) {
					cardAvailable.add(totalCardAvailable.get(i));
				}
			}
			decision = p.chooseCard("Choisissez la carte que vous désirez", cardAvailable, true);
			if(!decision.equals("")) {
				p.setHand(cardAvailable.getCard(decision));
			}
		}
		
		
		
		
	}
}