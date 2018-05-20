package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	
	public Mine() {
		super("Mine",5);
	}
	
	public String toString() {
		return super.toString() + " " + " Écartez une carte Trésor de votre main."
				+ " Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus "
				+ " et ajoutez cette carte à votre main.";
	}

	public void play(Player p) {
		
		// Initialisation de la décision, de la carte trésor à écarter de la liste des cartes trésors valables
		CardList cardTreasureAvailable = new CardList();
		String decision;
		Card cardTrash;
		
		// Si le joueur a au moins une carte trésor dans sa main
		if(!p.getTreasureCards().isEmpty()) {
			decision = p.chooseCard("Choisissez la carte trésor que vous voulez écarter", p.getTreasureCards(), false);		
			cardTrash = p.getTreasureCards().getCard(decision); // On récupere la carte que le joueur veut écarter
			p.removeHand(cardTrash.getName()); // On l'a retire de sa main
			p.getGame().addTrashCard(cardTrash); // On l'écarte du jeu

			
			// Pour chaque carte disponible dans la réserve
			for(int i = 0; i<p.getGame().availableSupplyCards().size();i++) {
				// Si la carte est de type trésor et elle a un coût inférieur ou égal à 3 pièces de plus que celle écarter
				if(p.getGame().availableSupplyCards().get(i).getTypes().get(0) == CardType.Treasure && p.getGame().availableSupplyCards().get(i).getCost() <= cardTrash.getCost() + 3) {
					cardTreasureAvailable.add(p.getGame().availableSupplyCards().get(i)); // On stocke cette carte dans la liste des cartes valables
				}
			}	
			
			
			decision = p.chooseCard("Choisissez la carte trésor que vous voulez recevoir",cardTreasureAvailable, false);
			p.addHand(p.getGame().removeFromSupply(decision));	 // On ajoute dans la main la carte que le joueur a choisit et on la retire de la réserve
		}
		
	}
	
}