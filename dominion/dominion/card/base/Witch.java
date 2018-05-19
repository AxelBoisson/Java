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
		
		
		
		for(int i=0;i<p.otherPlayers().size();i++) {
			
			p.otherPlayers().get(i).setDiscard(c);
			p.otherPlayers().get(i).getGame().removeFromSupply("Curse");
			
		}
	}
	
	
}