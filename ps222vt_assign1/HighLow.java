package ps222vt_assign1;
import java.util.*;
public class HighLow {

	public static void main(String[] args) {
		Random rand = new Random();
		int n = 0;
		while (true){
			n = rand.nextInt(100)+1;
			if (n%2==1)break;
		}
		int[] a = new int[10];
		//@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		try {
			for (int i=0; i<10; i++){
				System.out.print("Guess "+(i+1)+": ");
				a[i]=scan.nextInt();
				if(a[i]<1 || a[i]>100)
					throw new InputMismatchException();
				if (a[i]>n && i!=9) System.out.println("   Hint: lower");
				else if (a[i]<n && i!=9) System.out.println("   Hint: higher");
				/* i!=9 is used so that the system does not give out hint
				 * in the very last attempt. If the user makes an error at the
				 * tenth attempt, a separate message is printed below.
				 */
				else {
					if (i==0)System.out.println("Correct in the very first guess! - Fantastic!");
					//A special output if guessed in the very first attempt!
					else System.out.println("Correct after only "+(i+1)+" guesses - Brilliant!");
					return;
				}
				if (i==9) System.out.println("Sorry! This was your last chance. The program will not terminate.");
			}
		}
		catch (InputMismatchException e){
			System.out.println("Input Error! Please Enter only ODD numbers from 1 to 100. Thank You!");
		}
		finally {
			scan.close();
		}
	}
}
