package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {
	
	public Workshop() {
		super("Workshop",3);
	}
	
	public String toString() {
		return super.toString() + " Effet: Recevez une carte coûtant jusqu'à 4 Pièces. \n";
	}
	
	public void play(Player p) {
		// Initialisation de décision et des cartes valables
		String decision;
		CardList cardAvailable = new CardList();
		
		// Pour toutes les cartes disponible dans la réserve
		for(int i = 0; i<p.getGame().availableSupplyCards().size();i++) { 
			if(p.getGame().availableSupplyCards().get(i).getCost()<=4) { // Si la carte de la réserve à un prix inférieur ou égale a 4
				cardAvailable.add(p.getGame().availableSupplyCards().get(i)); // On stocke cette carte dans la cardlist des cartes valables
			}
		}	
		
		decision = p.chooseCard("Choisissez la carte parmis celle disponible", cardAvailable, false);
		p.gain(p.getGame().removeFromSupply(decision)); // Le joueur gagne la carte choisit et elle est retiré de la réserve
				
		
	}
	
}