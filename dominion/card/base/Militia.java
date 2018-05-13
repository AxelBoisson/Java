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
	
private String description;
	
	public Militia() {
		super("Milice", 4);
		this.description = "2 Pièces.\n" + 
				" Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.";
	}
	
	public void play(Player p) {
		p.incrementMoney(2);
		int i = 1;
		int j = 1;
		List<Player> playerList = new ArrayList<Player>();
		playerList = p.getGame().otherPlayers(p);
		while(i<=playerList.size()) {
			playerList.add(p.getGame().otherPlayers(p).get(i));
			i++;
		}
		
		while(j<playerList.size()) {
			Player P;
			String decision;
			Card c;
			
			P = playerList.get(j);
			
			while(P.cardsInHand().size()>3) {
				decision = P.chooseCard("Choisissez la carte que vous voulez défausser", P.cardsInHand(), false);
				c = P.cardsInHand().getCard(decision);
				P.cardsInHand().remove(decision);
				P.setDiscard(c);
				
			}
			
			
		}
			
		
	}
	
}