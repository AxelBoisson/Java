package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {
	
	public Spy() {
		super("Spy",4);
	}
	
	public String toString() {
		return super.toString() + "+1 Carte.\n" + 
				" * +1 Action.\n" + 
				" * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.";
	}
	
	public void play(Player p) {
		p.drawCard();
		p.incrementActions(1);
		
		CardList firstCardPlayer = new CardList();
		int nbPlayer = p.getGame().numberOfPlayers();
		Player playerInGame [] = new Player [nbPlayer-1];
		for(int i = 0; i<nbPlayer; i++) {
			
			playerInGame[i] = p.getGame().getPlayer(i);
			CardList totalCardPlayer = new CardList();
			totalCardPlayer = playerInGame[i].totalCards();
			firstCardPlayer.add(totalCardPlayer.get(i));
			System.out.println(firstCardPlayer.get(i).toString());
		}
		
		String decision = "";
		
		for(int i = 0; i<nbPlayer;i++) {
			p.chooseCard("Voulez vous défaussez cette carte ou la replacer sur son deck ? Sélectionnez oui pour défausser et non pour la replaer", firstCardPlayer, false);
			if(decision.equals("oui")) {
				playerInGame[i].setDiscard(firstCardPlayer.get(i));
			}
			if(decision.equals("non")) {
				playerInGame[i].setHand(firstCardPlayer.get(i));
			}
					
		}
		
		
	}
	
}