package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {
	
	public Militia() {
		super("Militia", 4);
	}
	
	public String toString() {
		return super.toString() + "2 Pièces.\n" + 
				"Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.";
	}
	
	public void play(Player p) {
		p.incrementMoney(2);
		
		List<Player> playerList = new ArrayList<Player>();
		playerList = p.getGame().otherPlayers(p);
		
		for(int i=0;i<playerList.size();i++) {
			Player P;
			String decision;
			Card c;
			
			P = playerList.get(i);
			
			while(P.cardsInHand().size()>3) {
				decision = P.chooseCard("Choisissez la carte que vous voulez défausser", P.cardsInHand(), false);
				c = P.cardsInHand().getCard(decision);
				P.setDiscard(c);
				P.removeHand(decision);			
			}		
		}		
	}
}