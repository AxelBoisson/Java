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
	
	private String description;
	
	public CouncilRoom() { 
		super("Chambre du conseil", 2);	
		this.description = "+4 Cartes.\n" + 
				" +1 Achat.\n" + 
				" Tous vos adversaires piochent 1 carte.";
	}
	
	public void play(Player p) {
		p.incrementBuys(1);
		
		for(int i = 0; i<4; i++)
			p.drawCard();
		
		List<Player> other = new ArrayList<Player>();
		other = p.getGame().otherPlayers(p);
		
		for(int i = 0; i<other.size();i++)
			other.get(i).drawCard();
		
	}
	
}