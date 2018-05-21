package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chambre du conseil (Council Room)
 * 
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends ActionCard {
	
	
	public CouncilRoom() { 
		super("Council Room", 2);		
	}
	
	public String toString() {
		return super.toString() + " Effet: +4 Cartes." + 
				" +1 Achat." + 
				" Tous vos adversaires piochent 1 carte.\n";
	}
	
	public void play(Player p) {
		// Incrémente le nombre d'achat de 1
		p.incrementBuys(1);
		
		// Le joueur pioche 4 fois
		for(int i = 0; i<4; i++)
			p.addHand(p.drawCard());
		
		
		// Tous les adversaires du joueur pioche une carte
		for(int i = 0; i<p.getGame().otherPlayers(p).size();i++)
			p.getGame().otherPlayers(p).get(i).addHand(p.getGame().otherPlayers(p).get(i).drawCard());
		
	}
	
}