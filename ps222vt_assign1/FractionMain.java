package ps222vt_assign1;
//Note that each fraction output is first simplified before printing.
import java.util.InputMismatchException;
import java.util.Scanner;
public class FractionMain {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		int n1=1,d1=1,n2=1,d2=1,choice=0;
		Fraction f1=null,f2=null;
		System.out.println("Enter values for two fractions. For operations which involve only one fraction, the first fraction will be used.\n"
				+ "Enter the numerator of the first fraction: ");
		try {
			n1=scan.nextInt();
			System.out.println("Enter the denominator of the first fraction: ");
			d1=scan.nextInt();
			f1 = new Fraction (n1,d1);
			System.out.println("Enter the numerator of the second fraction: ");
			n2=scan.nextInt();
			System.out.println("Enter the denominator of the second fraction: ");
			d2=scan.nextInt();
			f2 = new Fraction (n2,d2);
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occured. Enter only integer values: "+e+"\n"
					+ "Program will now terminate.");
			System.exit(-1);
		}
		finally {
			//scan.close();
		}
		
		
		
		System.out.print("========================================\n"
				+ "Following methods can be used:\n"
				+ "1.getNumerator()\n"
				+ "2.getDenominator()\n"
				+ "3.isNegative()\n"
				+ "4.add()\n"
				+ "5.subtract()\n"
				+ "6.multiply()\n"
				+ "7.divide()\n"
				+ "8.isEqualTo()\n"
				+ "9.toString()\n"
				+ "10.simplifiedFraction() Note: This converts the fraction to its simplified form\n"
				+ "Choose the appropriate option: ");
		try {
			choice=scan.nextInt();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occured. Enter only integer values from 1 to 10: "+e+"\n"
					+ "The program will now terminate.");
			System.exit(-1);
		}
		switch(choice){
		case 1: System.out.println("The numerator is: "+f1.getNumerator());
				break;
		case 2:	System.out.println("The numerator is: "+f1.getDenominator());
				break;
		case 3: System.out.println("The output is: "+f1.isNegative());
				break;
		case 4: Fraction f3 = f1.add(f1, f2);
				System.out.println("Resultant simplified output is: "+f3.toString());
				break;
		case 5: f3 = f1.subtract(f1, f2);
				System.out.println("Resultant simplified output is: "+f3.toString());
				break;
		case 6: f3 = f1.multiply(f1, f2);
				System.out.println("Resultant simplified output is: "+f3.toString());
				break;
		case 7:	f3 = f1.divide(f1, f2);
				System.out.println("Resultant simplified output is: "+f3.toString());
				break;
		case 8: boolean b = f1.isEqualTo(f1, f2);
				System.out.println("The output is: "+b);
				break;
		case 9: String str = f1.toString();
				System.out.println("The output is: "+str);
				break;
		case 10:	f3 = f1.simplifiedFraction(f1);
					System.out.println("Simplified form of fraction is: "+f3.toString());
					break;
		default:	System.out.println("Wrong choice selected! Program will now terminate.");
					System.exit(-1);	
		}
	}
}
