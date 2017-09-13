package ps222vt_assign1;
import java.util.Scanner;
import java.util.*;
public class LargestK {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Provide The Number \"N\": ");
		int N = 0;
		try {
			N = scan.nextInt();
		}
		catch (InputMismatchException e){
			System.out.println("Oops! Enter only numbers, other characters are not allowed!\nProgram will now terminate.");
			scan.close();return;
		}			
		int i = 0, totalSum = 0;
		for (i=0; totalSum<=N; i++){
			totalSum = totalSum+(i)*2;
			/* The 'for' adds 0, 2, 6, 8, etc
			 * in each loop in 'totalSum' until the sum
			 * does not become greater than 'N'
			 */
		}
		System.out.print("\nValue of \"K\" is: "+(i-2)*2);
		scan.close();
	}

}
