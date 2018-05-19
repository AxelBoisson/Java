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
	
	public Moat (){
		super("Moat",2);
	}
	
	public String toString() {
		return super.toString() + "+2 Cartes.\n" + 
				" Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. \n"
				+ " Dans ce cas, l’Attaque n’a pas d’effet sur vous.";
	}

	public boolean reaction(Player p){
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		String decision;
		decision = p.choose("Voulez-vous dévoiler votre carte Réaction ?", choice, false);
		if(decision.equalsIgnoreCase("y")){
			play(p);
			return true;	
		}
		else {
			return false;
			
		}
	
	}
	
	
	public void play(Player p) {
		for(int i = 0; i < 2; i++){
			p.setHand(p.drawCard());
		}	
	}
}