/* Author: Darian Sampare
 * ID: t00578132
 * Assignment 5
 * Dealer.java
 */

public class Dealer{

	// this is a driver for the DeckOfCards class to demonstrate it's various methods
	public static void main(String[] args) {
		
		// instantiates a deck and prints
		DeckOfCards deck1 = new DeckOfCards();
		System.out.println(deck1.toString());
		
		// shuffles the deck and prints
		deck1.shuffle();
		System.out.println(deck1.toString());
		System.out.println();
		
		// deals every card from the deck
		for (int i=1; i<=52; i++)
			deck1.deal();
		System.out.println();
		
		// instantiate second deck
		DeckOfCards deck2 = new DeckOfCards();
		System.out.println(deck2.toString());
		deck2.shuffle();
		System.out.println(deck2.toString());
		deck2.deal();
		deck2.deal();
		
		// demonstrate the getAmount method after 2 cards have been dealt from a shuffled deck
		System.out.println(deck2.getAmount());

	}

}
