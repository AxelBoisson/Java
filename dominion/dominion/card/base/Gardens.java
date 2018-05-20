package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Jardins (Gardens)
 * 
 * Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).
 */
public class Gardens extends VictoryCard {
	
	private int nbVictory;
	
	public Gardens() { 
		super("Jardins", 4);	
	}
	
	public String toString() {
		return super.toString() + " Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).";
	}
	
	public int victoryValue(Player p) {
		// Joue la carte pour récupérer le total de VP
		play(p); 
		// Retourne le total de VP
		return this.nbVictory;
	}
	
	public void play(Player p) {
		// Récupère le total des cartes du joueurs puis divise par 10
		this.nbVictory = p.totalCards().size() / 10;
	}
}