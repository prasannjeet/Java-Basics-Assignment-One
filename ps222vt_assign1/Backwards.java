package ps222vt_assign1;
import java.util.Scanner;
public class Backwards {
	public static void main (String [] args) throws Exception{
		Scanner scan = new Scanner (System.in);
		System.out.print("Type a line of text: ");
		System.out.println("Backwards: "+new StringBuilder (new String(scan.nextLine())).reverse().toString());
		/* 1. Taken a new input
		 * 2. Converted it to StringBuilder
		 * 3. Used the function reverse() to reverse it.
		 * 4. Converted it back to string using toString().
		 * 5. Printed it using System.out.println 
		 */
		scan.close();
		}
	}