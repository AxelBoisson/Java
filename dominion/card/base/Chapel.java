package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {
	
	public Chapel() {
		super("Chapelle",2);
	}
	
	public String toString() {
		return super.toString() + "Écartez jusqu'à 4 cartes de votre main.";
	}
	
	public void play(Player p) {
		
		int nbRemove = 0;
		List<String> list = new ArrayList<String>();
		list.add(p.cardsInHand().toString());
		String decision;
		boolean stop = false;
		int i = 0;
		
		while(nbRemove < 4 && i<list.size() && stop == false) {
			decision = p.choose("Choisissez la carte que vous voulez défausser, pour arreter appuyez sur entrée directement", list, true);
			if(!decision.equals("")) {
				p.getGame().setTrashCard(p.cardsInHand().getCard(decision));
				p.cardsInHand().remove(decision);
				nbRemove++;
			}
			else
				stop = true;
			i++;
		}
	}
}