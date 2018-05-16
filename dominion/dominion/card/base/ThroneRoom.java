package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {
	
	public ThroneRoom() {	
		super("Throne Room",4);
	}
	
	public String toString() {
		return super.toString() + "Choisissez 1 carte Action de votre main.\n" + 
				" * Jouez-la deux fois.";
	}
	
	public void play(Player p) {
		
		CardList actionInHand = new CardList();
		
		actionInHand = p.getActionCards();
		
		String decision;
		
		decision = p.chooseCard("Choisissez une carte Action de votre main", actionInHand, false);
		
		for(int i = 0; i<2;i++)
			p.playCard(decision);
	}
	
}