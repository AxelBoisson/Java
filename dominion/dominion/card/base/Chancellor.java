package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck (pioche).
 */
public class Chancellor extends ActionCard {
	
	public Chancellor() { 
		super("Chancellor", 3);	
	}
	
	public String toString() {
		return super.toString() + " Effet: +2 Pièces.\n" + 
				" Vous pouvez immédiatement défausser votre deck.\n";
	}
	
	public void play(Player p) {
		// Incrémente le nombre de pièce de 2
		p.incrementMoney(2);
		
		// Initialisation des choix, décision et total des cartes dans la pioche
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		String decision;
		CardList totalDraw = new CardList();
		for(Card c : p.getDraw()){ // Récupère toutes les cartes non nulles de la pioche du joueur
			if(c != null){
				totalDraw.add(c);
			}
		}

		
		decision = p.choose("Voulez vous défausser votre deck", choice, false);
		// Si le joueur veut défausser son deck
		if(decision.equalsIgnoreCase("y")){
			for(int i = 0;i < totalDraw.size();i++) { // Ajoute dans la défausse les cartes piochés tant que la pioche n'est pas vide
				p.addDiscard(p.drawCard()); 
			}
		}
		
		
	}
	
}