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
		super("Moneylender",4);
	}
	
	public String toString() {
		return super.toString() + " Écartez une carte Cuivre de votre main.\n" + "Dans ce cas, +3 Pièces.";
	}
	
	public void play(Player p) {
		
		CardList treasureCard = new CardList();
		treasureCard = p.getTreasureCards();
		int i = 0;
		boolean stop = false;
		while( i < p.getTreasureCards().size() && stop == false) {
			if(treasureCard.get(i).getName().equals("Copper")) {		
				p.removeHand(treasureCard.get(i).getName());
				p.getGame().setTrashCard(treasureCard.get(i));
				p.incrementMoney(3);
				stop = true;
			}
			i++;
		}
		
		
	}
}