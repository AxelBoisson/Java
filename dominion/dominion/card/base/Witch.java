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
		return super.toString() + " +2 Cartes.\n" + 
				" Tous vos adversaires recoivent une carte Curse.";
	}
	
	public void play(Player p) {
		// Le joueur pioche 2 fois
		for(int i = 0; i<2; i++)
			p.addHand(p.drawCard());

		// Pour chaque adversaire
		for(int i=0;i<p.otherPlayers().size();i++) {
				// Si l'adversaire a dans sa main une carte Moat
				if(p.otherPlayers().get(i).cardsInHand().getCard("Moat") != null) {
					// On appelle la fonction reaction de la carte qui va demander a l'adversaire si il veut utiliser sa carte Moat
					if(!((Moat) p.otherPlayers().get(i).cardsInHand().getCard("Moat")).reaction(p.otherPlayers().get(i))) {
						p.otherPlayers().get(i).gain("Curse"); // Si le joueur refuse il reçoit une carte Curse sinon il n'en reçoit pas 
					}	
				}
				// Si l'adversaire n'a pas de carte Moat il reçoit automatiquement une carte Curse
				else {
					p.otherPlayers().get(i).gain("Curse");
			}
		}
	}
}