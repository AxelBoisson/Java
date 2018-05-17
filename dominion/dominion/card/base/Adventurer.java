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
		super("Adventurer", 6);	
		
		
	}
	
	public String toString() {
		return super.toString() + "Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. "
				+ "Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.";
	}

	
	public void play(Player p) {
		Card card; 
		int i = 0;
		int nbTreasure = 0;
		boolean treasure = false;
		while(nbTreasure < 2 ) {
			i = 0;
			treasure = false;
			card = p.drawCard();
			while(i<card.getTypes().size() && treasure == false) {
				if(card.getTypes().get(0) == CardType.Treasure) {
					p.setHand(card);
					treasure = true;
					nbTreasure++;
				}
				i++;
			}
			if(treasure == false)
				p.gain(card);
			
		}
	}
	
	
}