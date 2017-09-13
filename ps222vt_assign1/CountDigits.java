package ps222vt_assign1;
import java.util.Scanner;
import java.util.*;
public class CountDigits {
    public static boolean isNumeric(String str) {
    /* Method checks whether the input taken by keyboard is numeric or not.
     * This is done because we do not use int to take the input, but rather
     * use String, so that even longer integers can be used in the program.
     */
        for (char c: str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public static int totalEven (int[] a, int len){
    //Self explanatory
    	int count = 0;
    	for (int i=0; i<len; i++)
    		if (a[i]!=0 && a[i]%2==0) count++;
    	return count;
    }
    public static int totalOdd (int[] a, int len) {
    //Self explanatory
    	int count = 0;
    	for (int i=0; i<len; i++)
    		if (a[i]%2==1) count++;
    	return count;
    }
    public static int countZeroes (int[] a, int len) {
    	int count = 0;
    	for (int i=0; i<len; i++){
    		if (a[i]==0)count++;
    	}
    	return count;
    }
    public static int calcSum(int[] a, int len){
    	int sum = 0;
    	for (int i=0; i<len; i++)
    		sum=sum+a[i];
    	return sum;
    }
    public static void main(String[] args) {
        System.out.print("Provide a Positive Integer of Unlimited Length: ");
        String str;
        try {
            Scanner scan = new Scanner(System.in);
            str = scan.nextLine();
            if (isNumeric(str) == false) {
            	scan.close();
                throw new InputMismatchException();
            }
            scan.close();
        } 
        catch (InputMismatchException e) {
            System.out.println("Please Enter Only Positive Integers!\nThe Program Will Now Terminate!");
            return;
        }
        int len = str.length();
        int[] a = new int[len];
        for (int i=0; i<len;i++)
        	a[i] = Character.getNumericValue(str.charAt(i));
        System.out.print("Zeros: "+countZeroes(a,len)+"\nOdd: "+totalOdd(a,len)+"\nEven: "+totalEven(a,len)+"\nSum: "+calcSum(a,len));
        
        //System.out.println("Debug: " + a);
        
    }

}