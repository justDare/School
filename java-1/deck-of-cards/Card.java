/* Author: Darian Sampare
 * ID: t00578132
 * Assignment 5
 * Card.java
 */

import java.util.Random;

// this class creates a card object to represent a a card from a standard deck
// can be a random or chosen card of any 4 suites with values ace-king
public class Card {

	// instantiate 2 arrays for the suit and face value representations
	// index 1-13 = facevalues
	private String[] faceValues = {"null","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
	// index 1-4 = suits
	private String[] suitTypes = {"null","Hearts","Diamonds","Clubs","Spades"};
	Random generator = new Random();
	private int suit, value;
	
	// default constructor, generates random ints to represent the faceValue and suit of the card
	public Card(){
		
		suit = generator.nextInt(4)+1;
		value = generator.nextInt(13)+1;
	}
	
	// second constructor takes in 2 ints to set the face value and suit of the card
	public Card(int pickSuit, int pickValue){
		
		suit = pickSuit;
		value = pickValue;
	}
	
	// changes the values of the suit and face value of the card
		public void setValues(int setSuit, int setValue){
			
			suit = setSuit;
			value = setValue;
		}
	
	// returns an int representation of the suit
	public int getSuit(){
		
		int theSuitValue = suit;
		return theSuitValue;
	}
	
	// returns an int representation of the face value
	public int getFace(){
		
		int theFaceValue = value;
		return theFaceValue;
	}
	
	// returns a text representation of the suit of the card
	public String getSuitTextValue(){
		
				String SuitTextValue = suitTypes[suit];
				return SuitTextValue;
		}
	
	// returns a text representation of the face value of the card
	public String getFaceTextValue(){
	
			String FaceTextValue = faceValues[value];
			return FaceTextValue;
	}
	
	// returns a string with the info of the card
	public String toString(){
		
		String result = (getFaceTextValue() + " of " + getSuitTextValue());
		return result;
	}
}

