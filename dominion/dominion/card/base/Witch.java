package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {
	
	public Witch() {
		super("Witch", 5);
	}
	

	
	public String toString() {
		return super.toString() + "+2 Cartes.\n" + 
				"Tous vos adversaires recoivent une carte Curse.";
	}
	
	public void play(Player p) {
		for(int i = 0; i<2; i++)
			p.setHand(p.drawCard());
		
		Card c = p.getGame().getFromSupply("Curse");
		boolean reaction = false;
		boolean stop = false;
		int j = 0;

		for(int i=0;i<p.otherPlayers().size();i++) {
			while(j<p.otherPlayers().get(i).cardsInHand().size() && stop == false) {
				if(p.otherPlayers().get(i).cardsInHand().getCard("Moat") != null) {
					reaction = ((Moat) p.otherPlayers().get(i).cardsInHand().getCard("Moat")).reaction(p.otherPlayers().get(i));
					stop = true;
				}
				else 
					reaction = false;
				j++;
			}
			
			if(reaction == false) {
				p.otherPlayers().get(i).setDiscard(c);
				p.getGame().removeFromSupply("Curse");
			}
		}
	}
	
	
}