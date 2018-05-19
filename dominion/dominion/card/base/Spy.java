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
		return super.toString() + " +1 Carte.\n" 
				+ " +1 Action.\n" 
				+ " Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. "
				+ " Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.";
	}
	
	public void play(Player p) {
		p.setHand(p.drawCard());
		p.incrementActions(1);
		
		Card firstCardPlayer;
		List<Player> playerGame = new ArrayList<Player>();
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
			
		
		for(int i = 0; i<p.getGame().numberOfPlayers(); i++) {	
			playerGame.add(p.getGame().getPlayer(i));
			if(!playerGame.get(i).getDraw().isEmpty()){
				firstCardPlayer = playerGame.get(i).getDraw().get(0);
			}
			else{
				firstCardPlayer = playerGame.get(i).getDiscard().get(0);
				playerGame.get(i).removeDiscard(firstCardPlayer.getName());
			}
				
			String decision = "noChoice";
			decision = p.choose("Voulez vous défaussez cette carte ou la replacer sur son deck ?", choice, false);
			if(decision.equalsIgnoreCase("y")) {
				playerGame.get(i).removeDraw(firstCardPlayer.getName());
				playerGame.get(i).setDiscard(firstCardPlayer);	
			}
			
			if(decision.equalsIgnoreCase("n") && !playerGame.get(i).equals(playerGame.get(0))){
				playerGame.get(i).setDraw(firstCardPlayer);
			}
			
			
				
		}
					
	}
	
}