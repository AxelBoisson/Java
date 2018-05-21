package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	
	
	public Moneylender() {
		super("Moneylender",4);
	}
	
	public String toString() {
		return super.toString() + " Effet: Écartez une carte Cuivre de votre main." 
								+ " Dans ce cas, +3 Pièces.\n";
	}
	
	public void play(Player p) {
		// Initialisation des cartes trésors, de l'index i et du boolean stop
		CardList treasureCard = new CardList();
		treasureCard = p.getTreasureCards();
		int i = 0;
		boolean stop = false;
		
		// Tant que l'index i est inférieur au total de carte trésors du joueur et que l'on a pas trouvé de carte cuivre
		while( i < p.getTreasureCards().size() && stop == false) {
			if(treasureCard.get(i).getName().equals("Copper")) {	// Si une carte cuivre est présente dans la main du joueur	
				p.removeHand(treasureCard.get(i).getName()); // On retire cette carte de sa main
				p.getGame().addTrashCard(treasureCard.get(i)); // On écarte cette carte
				p.incrementMoney(3); // On incrémente le nombre de pièce de 3
				stop = true; // on sort de la boucle
			}
			i++;
		}
		
		
	}
}