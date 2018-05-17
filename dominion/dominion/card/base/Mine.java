package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	
	public Mine() {
		super("Mine",5);
	}
	
	public String toString() {
		return super.toString() + " " + "Écartez une carte Trésor de votre main. "
				+ "Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; "
				+ "ajoutez cette carte à votre main.";
	}

	public void play(Player p) {
		
		CardList cardAvailable = new CardList();
		CardList cardTreasureAvailable = new CardList();
		String decision;
		
		Card c;
		
		
		if(!p.getTreasureCards().isEmpty()) {
			decision = p.chooseCard("Choisissez la carte trésor que vous voulez écarter", p.getTreasureCards(), false);		
			c = p.getTreasureCards().getCard(decision);
			p.removeHand(c.getName());

			
			cardAvailable.addAll(p.getGame().availableSupplyCards());
			for(int i = 0; i<cardAvailable.size();i++) {
				if(cardAvailable.get(i).getTypes().get(0) == CardType.Treasure && cardAvailable.get(i).getCost() <= c.getCost() + 3) {
					cardTreasureAvailable.add(cardAvailable.get(i));
				}
			}	
			
			
			decision = p.chooseCard("Choisissez la carte trésor que vous voulez recevoir",cardTreasureAvailable, false);
			p.setHand(p.getGame().removeFromSupply(decision));	
		}
		
	}
	
}