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
		super("Sorcière",2);
	}
	
	public void play(Player p) {
		Card c;
		for(int i=0;i<p.otherPlayers().size();i++) {
			c=p.otherPlayers().get(i).getGame().getFromSupply("Curse");
			if(c!=null) {
				p.otherPlayers().get(i).setHand(c);
				p.otherPlayers().get(i).getGame().removeFromSupply("curse");
			}
		}
	}
	
	
}