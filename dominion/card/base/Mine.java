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
		return super.toString() + "Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.";
	}

	public void play(Player p) {
		CardList cardTreasurePlayer = new CardList();
		CardList cardAvailable = new CardList();
		CardList cardTreasureAvailable = new CardList();
		String decision;
		int i = 0;
		
		cardTreasurePlayer = p.getTreasureCards();
		Card c;
		cardAvailable = p.getGame().availableSupplyCards();
		if(cardTreasurePlayer.size()!=0) {
			decision = p.chooseCard("Choisissez la carte trésor que vous voulez écarter", cardTreasurePlayer, true);
			if(!decision.equals("")) {
				c = cardTreasurePlayer.getCard(decision);
				p.getGame().setTrashCard(c);
				i = c.getCost();
				for(int j = 0; j<cardAvailable.size();j++) {
					if(cardAvailable.get(j).getCost() <= i+3) {
						cardTreasureAvailable.add(cardAvailable.get(j));
					}
				}
				decision = p.chooseCard("Choisissez la carte trésor que vous voulez recevoir",cardTreasureAvailable, true);
				if(!decision.equals(""))
					p.setHand(cardTreasureAvailable.getCard(decision));
			}
			
		}
		
	}
	
}