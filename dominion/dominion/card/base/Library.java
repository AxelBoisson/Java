package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. 
 * Chaque carte Action piochée peut être mise de côté. 
 * Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {
	
	public Library() {
		super("Library",5);
	}
	
	public String toString() {
		return super.toString() + " Effet: Piochez jusqu'à ce que vous ayez 7 cartes en main."
				+ " Chaque carte Action piochée peut être mise de côté."
				+ " Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.\n";
	}
	
	
	public void play(Player p) {
		// Initialisation des choix, de la carte pioché et de la décision
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		Card cardDraw;
		String decision;
		
		// Tant que le joueur a moins de 7 cartes en mains
		while(p.cardsInHand().size()<7) {
			cardDraw = p.drawCard(); // On récupère la carte pioché
			if(cardDraw.getTypes().get(0) == CardType.Action) { // Si la carte pioché est de type action
				decision = p.choose("Voulez-vous mettre de côté cette carte ?", choice, false);
				if(decision.equalsIgnoreCase("y")) { // Si le joueur veut la mettre de côté
					p.addDiscard(cardDraw); // On défausse cette carte
				}
				// Sinon on l'ajoute dans sa main
				else 
					p.addHand(cardDraw);
			}
			// Si la carte n'est pas de type action on l'ajoute à la main automatiquement
			else
				p.addHand(cardDraw);			
			
		}
		
	}
	
}