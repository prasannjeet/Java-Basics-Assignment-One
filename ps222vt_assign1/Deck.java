package ps222vt_assign1;
//Note. Enumeration has not been used
//import java.util.Collections;
import java.util.Random;
//import java.util.Arrays;
public class Deck {
	Card[] cardObjects = new Card[52];
	//Initialized 52 cards.
	int[] cardSequence = new int[52];
	/* This array will depict the card sequence. For example if array is sorted from 0
	 * to 51, that means the cards are arranged in order. But if the array is shuffled
	 * and now the sequence is random, that means the cards are not arranged randomly
	 * according to the array.
	 */
	int k=0; 
	int cardsInTheDeck = 52;
	Deck(){
		for (int i=0;i<4;i++)
			for(int j=0;j<13;j++)
				cardObjects[k++]=new Card (i,j);
		//Initialized deck with 52 different cards
		for (int i=0;i<52;i++)
			cardSequence[i]=i;
		//Arranged the cards in sequence
	}
	
	/*
	//Collections.shuffle function is not working for some reason.
	public void shuffle (){
		if (cardsInTheDeck!=52){
			System.out.println("Cannot shuffle, cards less than 52.\n"
					+ "Program will now terminate.");
			System.exit(-1);
		}
		Collections.shuffle(java.util.Arrays.asList(cardSequence));
		System.out.println(Arrays.toString(cardSequence));
	}
	*/
	
	public void shuffle() {
	//In this shuffle() method, I have randomly arranged the array.
		if (cardsInTheDeck!=52){
			System.out.println("Cannot shuffle, cards less than 52.\n"
					+ "Program will now terminate.");
			System.exit(-1);
		}
	    Random rgen = new Random(); // Random number generator
	    //int[] array = new int[size];
	    for (int i = 0; i < 52; i++) {
	        int randomPosition = rgen.nextInt(52);
	        int temp = cardSequence[i];
	        cardSequence[i] = cardSequence[randomPosition];
	        cardSequence[randomPosition] = temp;
	    }
		//System.out.println(Arrays.toString(cardSequence));

	}
	
	public Card handOutNextCard(){
		if (cardsInTheDeck == 0){
			System.out.println("Cannot draw next card. No more cards present in the deck.\n"
					+ "Program will now terminate.");
			System.exit(-1);
		}
		Card nextCard = cardObjects[cardSequence[0]];
		//took out the first card from the deck and saved it in "nextCard" variable
		for (int i=0;i<(cardsInTheDeck-1);i++){
			cardSequence[i]=cardSequence[i+1];
			//shifted the cardsequence one place to the left, thus effectively removing the first card
		}
		cardsInTheDeck--;
		//decreased the number of cards in the deck by 1
		return nextCard;
	}
	
	public int deckSize(){
		return cardsInTheDeck;
	}
}