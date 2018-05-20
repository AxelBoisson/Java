package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {
	

	
	public Adventurer() { 
		super("Adventurer", 6);	
		
		
	}
	
	public String toString() {
		return super.toString() + " Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées.\n"
				+ " Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.";
	}

	
	public void play(Player p) {
		// Initialisation de la carte pioché, de l'index i, du nombre de cartes trésors et du booléen stop
		Card card; 
		int i = 0;
		int nbTreasure = 0;
		boolean stop = false;
		
		// Tant que 2 cartes trésors n'ont pas été dévoiler
		while(nbTreasure < 2 ) {
			i = 0; // On remet l'index i à 0
			stop = false; // On remet stop à false
			card = p.drawCard(); // On récupère la carte pioché
			// Tant que i est inférieur au nombre de type de la carte et que on a pas trouvé de carte trésor
			while(i<card.getTypes().size() && stop == false) {
				if(card.getTypes().get(0) == CardType.Treasure) { // Si la carte est de type trésor
					p.addHand(card); // On ajoute la carte dans la main du joueur
					nbTreasure++; // On incrémente le nombre de carte trésor trouvé
					stop = true; // On sort de la boucle
				}
				i++; 
			}
			if(stop == false) // Si on a pas trouvé de carte trésor
				p.gain(card); // On gagne la carte et elle s'ajoute dans la défausse
			
		}
	}
	
	
}