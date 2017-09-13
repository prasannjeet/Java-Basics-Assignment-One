package ps222vt_assign1;
//A fairly self-explanatory program.
import java.util.Scanner;
public class Play123Main {
	public static boolean play213(Deck d){
		//int k=-1;
		Card c;
		boolean flag=true;
		for (int i=0,k=1;i<52;i++, k=((k%3)+1)){
			c = d.handOutNextCard();
			if (c.rankPointer==(k-1)){
				flag = false;
				break;
			}
		}
		//if (flag==true)System.out.println("");
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck d = new Deck();
		d.shuffle();
		System.out.print("Deck initialed, shuffled and ready to go!\n"
				+ "Press Enter to start the game...");
		try {
			@SuppressWarnings({ "resource", "unused" })
			String str = (new Scanner (System.in)).nextLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Some input error has occured! Program will now exit.\n");
			System.exit(-1);
		}
		System.out.println("Program has started playing the game ten thousand times!");
		int win=0;
		for (int i=0;i<10000;i++){
			d = new Deck();
			d.shuffle();
			if (play213(d)==true)win++;
		}
		double prob = (double)(win)/100;
		System.out.println("After playing 10,000 times, the game was won only "+win+" times!\n"
				+ "Therefore, the probability % to win the game is: "+prob+"%");
	}

}