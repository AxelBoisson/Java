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
		return super.toString() + " Effet: 2 Pièces." + 
				" Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.\n";
	}
	
	public void play(Player p) {
		// On incrémente le nombre de pièce de 2
		p.incrementMoney(2);
			
		// Pour chaque adversaire
		for(int i=0;i<p.getGame().otherPlayers(p).size();i++) {
			// Initialisation de la décision et de la carte du joueur
			String decision;
			Card playerCard;
			// Si l'adversaire a dans sa main une carte Moat
			if(p.otherPlayers().get(i).cardsInHand().getCard("Moat") != null) {
				// On appelle la fonction reaction de la carte qui va demander a l'adversaire si il veut utiliser sa carte Moat
				if(!((Moat) p.otherPlayers().get(i).cardsInHand().getCard("Moat")).reaction(p.otherPlayers().get(i))) {
					// Tant que le joueur a plus de 3 cartes en mains
					while(p.getGame().otherPlayers(p).get(i).cardsInHand().size()>3) {
						decision = p.getGame().otherPlayers(p).get(i).chooseCard("Choisissez la carte que vous voulez défausser", p.getGame().otherPlayers(p).get(i).cardsInHand(), false);
						// On récupère la carte de l'adversaire i que l'on a choisit
						playerCard = p.getGame().otherPlayers(p).get(i).cardsInHand().getCard(decision);
						// On ajoute cette carte dans la défausse de l'adversaire i
						p.getGame().otherPlayers(p).get(i).addDiscard(playerCard);
						// On retire cette carte de la main de l'adversaire i
						p.getGame().otherPlayers(p).get(i).removeHand(decision);			
					}	
				}
			}
			else {
				// Tant que le joueur a plus de 3 cartes en mains
				while(p.getGame().otherPlayers(p).get(i).cardsInHand().size()>3) {
					decision = p.getGame().otherPlayers(p).get(i).chooseCard("Choisissez la carte que vous voulez défausser", p.getGame().otherPlayers(p).get(i).cardsInHand(), false);
					// On récupère la carte de l'adversaire i que l'on a choisit
					playerCard = p.getGame().otherPlayers(p).get(i).cardsInHand().getCard(decision);
					// On ajoute cette carte dans la défausse de l'adversaire i
					p.getGame().otherPlayers(p).get(i).addDiscard(playerCard);
					// On retire cette carte de la main de l'adversaire i
					p.getGame().otherPlayers(p).get(i).removeHand(decision);
				}
			}
		}		
	}
}