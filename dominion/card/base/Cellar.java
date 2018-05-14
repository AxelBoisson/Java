package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {
	
	public Cellar() { 
		super("Cave", 2);	
	}
	
	public String toString() {
		return super.toString() + "+1 Action.\n" + 
				" * Défaussez autant de cartes que vous voulez.\n" + 
				" * +1 Carte par carte défaussée.";
	}
	
	public void play(Player p) {
		p.incrementActions(1);
		
		String decision = "noChoice";
		CardList cardInHand = new CardList();
		
		cardInHand = p.cardsInHand();
		
		int i = 0;
		while(i < cardInHand.size()) {
			decision = p.chooseCard("Entrez le nom de la carte que vous voulez défausser, appuyez sur entrée directement pour ne pas la défausser", cardInHand, true);
			if(!decision.equals(""))
				p.setDiscard(cardInHand.get(i));
			i++;
		}
	}
	
}