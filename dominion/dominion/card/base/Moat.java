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
				" Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main.\n"
				+ " Dans ce cas, l’Attaque n’a pas d’effet sur vous.";
	}

	public boolean reaction(Player p){
		//Ajout des choix y et n
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		String decision;
		decision = p.choose("Voulez-vous dévoiler votre carte Réaction ?", choice, false);
		//Si le joueur choisit y, la carte est joué et la protection est activé
		if(decision.equalsIgnoreCase("y")){
			play(p);
			return true;	
		}
		//Sinon la carte ne fait rien
		else {
			return false;
			
		}
	
	}
	
	
	public void play(Player p) {
		// Le joueur pioche 2 fois
		for(int i = 0; i < 2; i++){
			p.addHand(p.drawCard());
		}	
	}
}