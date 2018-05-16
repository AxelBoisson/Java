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
		super("Cellar", 2);	
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
		boolean stop = false;
		cardInHand = p.cardsInHand();
		
		int i = 0;
		while(i < cardInHand.size() && stop == false) {
			decision = p.chooseCard("Entrez le nom de la carte que vous voulez défausser, appuyez sur entrée directement pour arrêter de défausser", cardInHand, true);
			if(decision != ""){
				p.setDiscard(cardInHand.getCard(decision));
				p.removeHand(decision);
				p.setHand(p.drawCard());
			}
			else
				stop = true;
			i++;
		}
		
	}
	
}