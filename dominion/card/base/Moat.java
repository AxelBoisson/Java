package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {
	
	private String description;
	
	public Moat (){
		super("Douves",2);
		this.description = "Lorsqu’un adversaire joue une carte Attaque,"
				+ " vous pouvez dévoiler cette carte de votre main."
				+ " Dans ce cas, l’Attaquen’a pasd’effet sur vous.";
	}

	
	public void play(Player p) {
		p.drawCard();
		p.drawCard();
		
	}
	
	
}