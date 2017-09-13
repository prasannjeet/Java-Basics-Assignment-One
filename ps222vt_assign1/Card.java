package ps222vt_assign1;
/* Note. Enumeration has not been used as enumeration is not able to take
 * any integer values, i.e. 1,2, etc. Instead I have used String. The integer
 * suitePointer and rankPointer tells us which card is this. For example if suitePointer
 * is 1 and rankPointer is 1, then the card is Ace of Spades, and so on. suitePointer ranges
 * from 0 to 3 and rankPointer ranges from 0 to 12.
 * 
 */
public class Card {
	String[] suite = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    int suitePointer, rankPointer;
    Card (int a, int b){
    	suitePointer = a;
    	rankPointer =b;
    }
    public String toString(){
    	String str = (ranks[rankPointer]+" of "+suite[suitePointer]);
    	return str;
    }
}
