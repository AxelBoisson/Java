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
		return super.toString() + "Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).";
	}
	
	public int victoryValue(Player p) {
		play(p);
		return this.nbVictory;
	}
	
	public void play(Player p) {
		CardList totalCardPlayer = new CardList();
		totalCardPlayer = p.totalCards();
		this.nbVictory = totalCardPlayer.size() / 10;
	}
}