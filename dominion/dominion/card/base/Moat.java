package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. 
 * Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {
	
	private boolean reaction;
	
	public Moat (){
		super("Moat",2);
	}
	
	public String toString() {
		return super.toString() + "+2 Cartes.\n" + 
				"Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. \n"
				+ " Dans ce cas, l’Attaque n’a pas d’effet sur vous.";
	}

	public boolean reaction(Player p){
		List<Player> adversary = new ArrayList<Player>();
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		Card playCard;
		String decision;
		
		for(int i = 0; i<adversary.size();i++){
			playCard = adversary.get(i).getInPlay().get(0);
			if (playCard.getTypes().get(0) == CardType.Attack){
				decision = p.choose("Voulez-vous dévoiler votre carte Réaction ?", choice, false);
				if(decision.equalsIgnoreCase("y")){
					return true;
				}	
			}		
		}
		return false;		
	}
	
	
	public void play(Player p) {
		for(int i = 0; i<2;i++){
			p.setHand(p.drawCard());
		}	
	}
}