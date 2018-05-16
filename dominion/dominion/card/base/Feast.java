package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {
	
	public Feast() {
		super("Feast", 4);
	}
	
	public String toString() {
		return super.toString() + "Écartez cette carte.\n" + 
				" * Recevez une carte coûtant jusqu'à 5 Pièces.";
	}
	
	public void play(Player p) {
		CardList cardInHand = new CardList();
		cardInHand = p.cardsInHand();
		String decision ="noChoice";
		CardList totalCardAvailable = new CardList();
		totalCardAvailable = p.getGame().availableSupplyCards();
		CardList cardAvailable = new CardList(); 
		for(int i = 0; i< totalCardAvailable.size();i++) {
			if(totalCardAvailable.get(i).getCost()<=5)
				cardAvailable.add(totalCardAvailable.get(i));
		}
		
		decision = p.chooseCard("Choisissez la carte que vous voulez écarter, appuyez directement sur entrée pour passer", cardInHand, true);
		if(!decision.equals("")) {
			p.getGame().setTrashCard(this);
		}
		
		decision = p.chooseCard("Choisisssez la carte que vous voulez recevoir, appuyez directement sur entrée pour passer", cardAvailable, true);
		if(!decision.equals("")) {
			p.gain(decision);
		}
		
		
	}
}