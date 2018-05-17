package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {
	
	public Library() {
		super("Library",5);
	}
	
	public String toString() {
		return super.toString() + "Piochez jusqu'à ce que vous ayez 7 cartes en main. "
				+ " Chaque carte Action piochée peut être mise de côté. "
				+ " Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.";
	}
	
	
	public void play(Player p) {
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		Card c;
		String decision;
		
		while(p.cardsInHand().size()<7) {
			c = p.drawCard();
			if(c.getTypes().get(0) == CardType.Action) {
				decision = p.choose("Voulez-vous écarter cette carte ?", choice, false);
				if(decision.equalsIgnoreCase("y")) {
					p.setDiscard(c);
				}
				else
					p.setHand(c);
			}
			else
				p.setHand(c);			
			
		}
		
	}
	
}