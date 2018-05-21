package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {
	
	public Spy() {
		super("Spy",4);
	}
	
	public String toString() {
		return super.toString() + " Effet: +1 Carte." 
				+ " +1 Action." 
				+ " Tous les joueurs (vous aussi) dévoilent la première carte de leur deck."
				+ " Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.\n";
	}
	
	public void play(Player p) {
		// Le joueur pioche une fois
		p.addHand(p.drawCard());
		// Incrémente le nombre d'action de 1
		p.incrementActions(1);
		
		// Initialisation de la 1ere carte du joueur, des joueurs et des choix
		Card firstCardPlayer;
		List<Player> playerGame = new ArrayList<Player>();
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
			
		// Pour chaque joueur présent dans la partie
		for(int i = 0; i<p.getGame().numberOfPlayers(); i++) {	
			
			// On ajoute le joueur i dans la liste
			playerGame.add(p.getGame().getPlayer(i));
			
			// Si la pioche du joueur n'est pas vide
			if(!playerGame.get(i).getDraw().isEmpty()){
				firstCardPlayer = playerGame.get(i).getDraw().get(0); // On récupere la 1ere carte de sa pioche
			}
			// Sinon
			else{
				firstCardPlayer = playerGame.get(i).getDiscard().get(0); // On récupere la 1ere carte de sa défausse
				playerGame.get(i).removeDiscard(firstCardPlayer.getName()); // On retire cette carte de sa défausse
			}
				
			String decision;
			// Si l'adversaire a dans sa main une carte Moat
			if(playerGame.get(i).cardsInHand().getCard("Moat") != null) {
				// On appelle la fonction reaction de la carte qui va demander a l'adversaire si il veut utiliser sa carte Moat
				if(!((Moat) playerGame.get(i).cardsInHand().getCard("Moat")).reaction(playerGame.get(i))) {
					decision = p.choose("Voulez vous défaussez cette carte ou la replacer sur son deck ?", choice, false);
					// Si le joueur souhaite défausser cette carte
					if(decision.equalsIgnoreCase("y")) {
						playerGame.get(i).removeDraw(firstCardPlayer.getName()); // On enleve la carte de la pioche de l'adversaire
						playerGame.get(i).addDiscard(firstCardPlayer);	// On ajoute la carte dans sa défausse
					}
					
					// Si le joueur choisit non et que ce n'est pas le joueur qui a joué la carte Spy
					if(decision.equalsIgnoreCase("n") && !playerGame.get(i).equals(playerGame.get(0))){
						playerGame.get(i).addDraw(firstCardPlayer); // On remet la carte dans la pioche
					}
				}
			}
			else {
				decision = p.choose("Voulez vous défaussez cette carte ou la replacer sur son deck ?", choice, false);
				// Si le joueur souhaite défausser cette carte
				if(decision.equalsIgnoreCase("y")) {
					playerGame.get(i).removeDraw(firstCardPlayer.getName()); // On enleve la carte de la pioche de l'adversaire
					playerGame.get(i).addDiscard(firstCardPlayer);	// On ajoute la carte dans sa défausse
				}
				
				// Si le joueur choisit non et que ce n'est pas le joueur qui a joué la carte Spy
				if(decision.equalsIgnoreCase("n") && !playerGame.get(i).equals(playerGame.get(0))){
					playerGame.get(i).addDraw(firstCardPlayer); // On remet la carte dans la pioche
				}
			}	
		}			
	}
}