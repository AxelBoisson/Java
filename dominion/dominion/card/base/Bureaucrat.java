package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {
	
	public Bureaucrat(){
		super("Bureaucrat",4);
	}
	
	public String toString() {
		return super.toString()+" Recevez une carte Argent; placez-la sur votre deck.\n" + 
				" Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck\n"
				+ " (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).";
	}
	
	public void play(Player p){
		// Initalisation de la liste des cartes victoire du joueur et de la décision
		CardList victoryCardPlayer = new CardList();
		String decision;
		
		// Ajoute une carte silver dans la pioche du joueur puis la retire de la réserve
		p.addDraw(p.getGame().removeFromSupply("Silver"));
		
		// Pour chaque adversaire de la partie
		for(int i = 0; i<p.getGame().otherPlayers(p).size(); i++){
			// Si l'adversaire a dans sa main une carte Moat
			if(p.otherPlayers().get(i).cardsInHand().getCard("Moat") != null) {
				// On appelle la fonction reaction de la carte qui va demander a l'adversaire si il veut utiliser sa carte Moat
				if(!((Moat) p.otherPlayers().get(i).cardsInHand().getCard("Moat")).reaction(p.otherPlayers().get(i))) {
					// On récupère les cartes victoires de l'adversaire i
					victoryCardPlayer = p.getGame().otherPlayers(p).get(i).getVictoryCards();
					// Si l'adversaire a au moins une carte victoire
					if(victoryCardPlayer.size() != 0){
						decision = p.getGame().otherPlayers(p).get(i).chooseCard("Choisissez la carte trésor que vous voulez dévoiler puis placer là sur votre deck", victoryCardPlayer, false);
						// On ajoute dans la pioche du joueur i la carte victoire choisit
						p.getGame().otherPlayers(p).get(i).addDraw(victoryCardPlayer.getCard(decision));
						// On enleve de la main du joueur i la carte victoire choisit
						p.getGame().otherPlayers(p).get(i).removeHand(victoryCardPlayer.getCard(decision).getName());
					}
				}
			}
			else {
				// On récupère les cartes victoires de l'adversaire i
				victoryCardPlayer = p.getGame().otherPlayers(p).get(i).getVictoryCards();
				// Si l'adversaire a au moins une carte victoire
				if(victoryCardPlayer.size() != 0){
					decision = p.getGame().otherPlayers(p).get(i).chooseCard("Choisissez la carte trésor que vous voulez dévoiler puis placer là sur votre deck", victoryCardPlayer, false);
					// On ajoute dans la pioche du joueur i la carte victoire choisit
					p.getGame().otherPlayers(p).get(i).addDraw(victoryCardPlayer.getCard(decision));
					// On enleve de la main du joueur i la carte victoire choisit
					p.getGame().otherPlayers(p).get(i).removeHand(victoryCardPlayer.getCard(decision).getName());
				}
			}
		}		
	}
}