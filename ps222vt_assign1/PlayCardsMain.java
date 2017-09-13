package ps222vt_assign1;
//Note. Enumeration has not been used
import java.util.InputMismatchException;
import java.util.Scanner;
public class PlayCardsMain {

	public static void main(String[] args) {
		Deck newDeck = new Deck();
		Scanner scan = new Scanner (System.in);
		int choice;
		System.out.println("Welcome to the cards program. We have already created a deck of cards and arranged them in sequence.\n"
				+ "Following are the operations that can be performed on the cards.");
		try {
			while (true) {
				System.out.print("==============================================\n"
								+ "1. Shuffle (Can only be performed in full deck)\n"
								+ "2. Deal a card and disiplay\n"
								+ "3. Find out number of remaining cards\n"
								+ "4. Exit\n"
								+ "Choose Your Option :");
				choice = scan.nextInt();
				switch (choice){
				case 1: newDeck.shuffle();
						System.out.println("Cards have been shuffled successfully!");
						break;
				case 2:	Card card;
						card = newDeck.handOutNextCard();
						System.out.println("Successfully dealt a card. This is your card: "+card.toString());
						break;
				case 3: System.out.println("There are "+newDeck.deckSize()+" cards remaining.");
						break;
				case 4: System.out.println("Thank you for using the program. It will now terminate.");
						System.exit(-1);
						break;
				default:	System.out.println("Wrong choice selected. Try again...");
				 			break;
				}
			}
		}
		catch (InputMismatchException e){
			System.out.println("Error. Enter only integer values. Program will now terminate: "+e);
			System.exit(-1);
		}
		finally {
			scan.close();
		}
	}
}
