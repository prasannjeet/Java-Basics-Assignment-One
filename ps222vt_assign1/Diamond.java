package ps222vt_assign1;
import java.util.Scanner;

import java.util.*;
public class Diamond {
	int x;
	
	public void noWay (int a) {
		int temp;
		this.x =a;
		
		this.temp = 5;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			System.out.print("Provide an odd integer: ");
			int n = scan.nextInt();
			if (n<=0 || n%2==0) throw new InputMismatchException();
			for (int i=0;i<=(n/2);i++){
				for (int k=0;k<(n/2-i);k++){
					System.out.print(" ");
				}
				for (int k=0;k<(1+2*i);k++){
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i=n/2;i>0;i--){
				for (int k=0;k<(n/2+1-i);k++){
					System.out.print(" ");
				}
				for (int k=0;k<(1+2*(i-1));k++){
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
		catch (InputMismatchException e){
			System.out.println("Enter only a POSITIVE and ODD integer.");
		}
		finally {
			scan.close();
		}
		
	}

}
