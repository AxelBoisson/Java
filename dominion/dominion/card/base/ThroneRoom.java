package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {
	
	public ThroneRoom() {	
		super("Throne Room",4);
	}
	
	public String toString() {
		return super.toString() + " Effet: Choisissez 1 carte Action de votre main." + 
				" Jouez-la deux fois.\n";
	}
	
	public void play(Player p) {
		// Initialisation de la carte à jouer et de la décision	
		Card cardPlayed;
		String decision;
		
		// Si le joueur a une carte action dans sa main
		if(!p.getActionCards().isEmpty()) {
			// Si il a au moins 2 cartes actions dans sa main, il aura la possibilité de rejouer la carte Throne Room
			if(p.getActionCards().size()>=2) {
				decision = p.chooseCard("Choisissez une carte Action de votre main", p.getActionCards(), false);
			}
			// Sinon on retire la carte Throne Room de sa main pour éviter qu'il puisse la rejouer 2 fois (il doit avoir au moins 2 cartes actions dans sa main pour la rejouer)
			else {
				p.getActionCards().remove("Throne Room");
				decision = p.chooseCard("Choisissez une carte Action de votre main", p.getActionCards(), false);
			}
			
			cardPlayed = p.getActionCards().getCard(decision);
			
			p.playCard(cardPlayed); // On joue la carte choisit
			p.removeInPlay(cardPlayed.getName()); // On la retire du jeu
			p.playCard(cardPlayed); // Et on la rejoue encore une fois
		}
		
		
	}
	
}