package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {
	
	public Remodel() {
		super("Remodel",4);
	}
	
	public String toStrin() {
		return super.toString() + " Effet: Écartez une carte de votre main." + 
				" Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.\n";
	}
	
	public void play(Player p) {
		// Initialisation de la décision, de la carte a écarté et des cartes de la réserve valables
		String decision;
		Card cardTrash;
	
		CardList cardAvailable = new CardList();
		
		// Si la main du joueur n'est pas vide
		if(!p.cardsInHand().isEmpty()) {
			decision = p.chooseCard("Choisissez la carte que vous voulez écarter", p.cardsInHand(), false);
			cardTrash = p.cardsInHand().getCard(decision); // On récupere la carte que l'on veut écarter
			p.removeHand(cardTrash.getName()); // On la retire de la main
			p.getGame().addTrashCard(cardTrash); // On l'écarte
			
					
			// Pour chaque carte disponible dans la réserve
			for(int i = 0; i<p.getGame().availableSupplyCards().size();i++) {
				// Si la carte a au moins un prix qui est supérieur de 2 pièces au moins à celle écarter
				if(p.getGame().availableSupplyCards().get(i).getCost() <= cardTrash.getCost() + 2 )   
					cardAvailable.add(p.getGame().availableSupplyCards().get(i)); // On stocke cette carte dans la liste des cartes valables				
			}
			
			
			decision = p.chooseCard("Choisissez la carte que vous désirez", cardAvailable, false);		
			p.gain(decision); // Le joueur gagne la carte de son choix	
		}
	}
}







