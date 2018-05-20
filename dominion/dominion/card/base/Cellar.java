package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {
	
	public Cellar() { 
		super("Cellar", 2);	
	}
	
	public String toString() {
		return super.toString() + " +1 Action.\n" + 
				" Défaussez autant de cartes que vous voulez." + 
				" +1 Carte par carte défaussée.";
	}
	
	public void play(Player p) {
		// Incrémente le nombre d'action de 1
		p.incrementActions(1);
		
		// Initialisation de decision, stop et i
		String decision;
		boolean stop = false;
		int i = 0;
		
		// Tant que i est inférieur au toal de cartes dans la main du joueur et que le joueur continu de défausser
		while(i < p.cardsInHand().size() && stop == false) {
			decision = p.chooseCard("Entrez le nom de la carte que vous voulez défausser, appuyez sur entrée directement pour arrêter de défausser", p.cardsInHand(), true);
			// Si le joueur choisit une carte à défausser
			if(!decision.equalsIgnoreCase("")){
				p.addDiscard(p.cardsInHand().getCard(decision)); // Défausse la carte choisit
				p.removeHand(decision); // Retire la carte choisit de sa main
				p.addHand(p.drawCard()); // Pioche une carte
			}
			// Si le joueur veut arrêter de défausser
			else
				stop = true; // Permet de sortir de la boucle
			i++;
		}
		
	}
	
}