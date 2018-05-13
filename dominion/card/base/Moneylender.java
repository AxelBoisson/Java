package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	
	
	public Moneylender() {
		super("Prêteur sur gages",2);
		
	}
	
	public void play(Player p) {
		
		CardList inHand = new CardList();
		
		inHand = p.cardsInHand();
		Card c;
		int i = 0;
		boolean cardFind = false;
		while( i < inHand.size() && cardFind == false) {
			c = inHand.get(i);
			if(c.getName().equals("Copper")) {
				p.incrementMoney(3);
				p.getGame().setTrashCard(c);
				cardFind = true;
			}
			i++;
		}
		
		
	}
}