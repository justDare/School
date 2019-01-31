/* Author: Darian Sampare
 * ID: t00578132
 * Assignment 5
 * DeckOfCards.java
 */

import java.util.Arrays;
import java.util.Random;

// this class creates a deck of cards represented by an array holding card objects
public class DeckOfCards {

	private Card deck[];
	private int dealCount = 1;
	
	// constructor sets up a full 52 card deck
	public DeckOfCards(){
		
		deck = new Card[53];
		int counter = 1;
		
		//assigns indexes 1-52 of the deck array with the appropriate cards
		for(int i=1; i<=4;i++){
				for(int j=1; j<=13; j++){
					deck[counter] = new Card(i,j);
					counter ++;	
				}
		}
	}
	
	// simulates a deck shuffle by swapping random pairs of cards
	public void shuffle(){
		
		// swap every card in the deck with a random card from the deck
		Random randy = new Random();
		for(int i=1; i<=52; i++){
			int swap = randy.nextInt(52)+1;
			// use the 0 index as the temporary placeholder for the swap
			deck[0] = deck[i];
			//swap i with the random card
			deck[i] = deck[swap];
			deck[swap] = deck[0];
			// reset 0 to null
			deck[0] = null;
		}
	}
	
	// count the amount of cards remaining in the deck
	public String getAmount(){
		
		int amount = 0;
		int subtract = 0;
		String text;
		//counts the current amount of null references and subtracts from the total possible cards of 52
		for(int i = 1; i <=52; i++){
			if(deck[i] == null){
				subtract++;
			}
		}
		amount= 52 - subtract;	
		text = amount + " card(s) left in this deck.";
		return text;
	}
	
	// deals the first card in the deck
	public void deal(){
		
		// if there is no card at the index, skip it
		while(deck[dealCount] == null){
			dealCount++;
		}
		// deals
		System.out.println("You were dealt a: " + deck[dealCount].toString());
		//sets that index to null because the card is now gone
		deck[dealCount] = null;
		// increases count
		dealCount++;
		
	}
	
	// returns string representation of the deck
	public String toString(){
		String result = Arrays.toString(deck);
		return result;
	}

}
