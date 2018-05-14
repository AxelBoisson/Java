package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {
	

	
	public Adventurer() { 
		super("Aventurier", 6);	
		
		
	}
	
	public String toString() {
		return super.toString() + "Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. "
				+ "Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.";
	}

	
	public void play(Player p) {
		Card card; 
		
		card = p.drawCard();
		int i = 0;
		int nbTreasure = 0;
		while(nbTreasure < 2 ) {
			i = 0;
			while(i<card.getTypes().size()) {
				if(card.getTypes().get(i) == CardType.Treasure) {
					p.setHand(card);
					nbTreasure++;
				}
				else
					p.gain(card);
				i++;
			}
		}
	}
	
	
}