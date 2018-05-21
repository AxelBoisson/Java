package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {
	
	public Feast() {
		super("Feast", 4);
	}
	
	public String toString() {
		return super.toString() + " Effet: Écartez cette carte." + 
				" Recevez une carte coûtant jusqu'à 5 Pièces.\n";
	}
	
	public void play(Player p) {
		// Initialisation de la décision et des cartes valables
		String decision;
		CardList cardAvailable = new CardList(); 
		
		// Pour toutes les cartes disponibles de la réserve
		for(int i = 0; i< p.getGame().availableSupplyCards().size();i++) {
			// Si la carte de la réserve a un prix inférieur ou égal à 5
			if(p.getGame().availableSupplyCards().get(i).getCost()<=5)
				cardAvailable.add(p.getGame().availableSupplyCards().get(i)); // On stocke cette carte dans la liste des cartes valables
		}
		
		// Si la liste des cartes valables n'est pas vide
		if(!cardAvailable.isEmpty()) {
			p.getGame().addTrashCard(p.getInPlay().getCard("Feast")); // On écarte la carte feast 
			p.removeInPlay("Feast"); // On retire la carte feast du jeu
			
			decision = p.chooseCard("Choisisssez la carte que vous voulez recevoir, appuyez directement sur entrée pour passer", cardAvailable, false);	
			p.gain(decision); // Le joueur choisit une des cartes valables
					
		}
	}
}