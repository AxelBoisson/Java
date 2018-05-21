package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Forgeron (Smithy)
 * 
 * +3 Cartes.
 */
public class Smithy extends ActionCard {
	
	public Smithy() {
		super("Smithy",4);
	}
	
	public String toString() {
		return super.toString() + " Effet: +3 Cartes.\n";
	}
	
	public void play(Player p) {
		// Le joueur pioche 3 fois
		for(int i = 0; i<3;i++) {
			p.addHand(p.drawCard());		
		}
	}
	
}