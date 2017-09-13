package ps222vt_assign1;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ArraysMain extends Arrays{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = new int[]{23,45,65,22,5,9,0,12,23,56,1,9};
		System.out.print("Hello! These are the list of methods in this program:\n"
				+ "1. int sum(int[] arr)\n"
				+ "2. String toString(int[] arr)\n"
				+ "3. int[] addN(int[] arr, int n)\n"
				+ "4. int[] reverse(int[] arr)\n"
				+ "5. void replaceAll(int[] arr, int old, int nw)\n"
				+ "6. int[] sort(int[] arr)\n"
				+ "7. boolean hasSubsequence(int[] arr, int[] sub)\n"
				+ "8. int[] absDif(int[] arr1, int[] arr2)\n"
				+ "Note that main array is already defined in the code and can be checked/edited by browsing the code at line 7.\n"
				+ "Please press the appropriate number to use the specific method: ");
		Scanner scan = new Scanner (System.in);
		try{
				int choice = scan.nextInt();
				//int choice = new Scanner (System.in).nextInt();
				switch (choice){
				case 1:	int arraySum = Arrays.sum (array1);
						System.out.println("The Sum Is: "+arraySum);
						break;
				case 2: String str = Arrays.toString(array1);
						System.out.println("n = " + str);
						break;
				case 3:	System.out.print("Enter the number to be added: ");
						int numberToBeAdded = scan.nextInt();
						//int[] addedArray = new int[array1.length];
						System.out.println("Resultant array is: "+ Arrays.toString(Arrays.addN(array1, numberToBeAdded)));
						break;
				case 4: int[] reversedArray = new int[array1.length];
						reversedArray = Arrays.reverse(array1);
						System.out.println("The reversed array is: "+Arrays.toString(reversedArray));
						break;
				case 5:	int target, newValue;
						System.out.print("Enter the target value to be replaced:");
						target = scan.nextInt();
						System.out.print("Enter the new value: ");
						newValue = scan.nextInt();
						Arrays.replaceAll(array1, target, newValue);
						System.out.println("Replacement Done (If Applicable)! New Array is: "+Arrays.toString(array1));
						break;
				case 6:	int[] sortedArray = new int[array1.length];
						sortedArray = Arrays.sort(array1);
						System.out.println("Sorting Done! New Array is: "+Arrays.toString(sortedArray));
						break;
				case 7:	int[] subArrayGood = new int[]{22,5,9,0};
						int[] subArrayBad = new int[]{3,65,7,1,45,3};
						System.out.print("======================================================\n"
								+ "Two arrays have already been defined, one (1) which is a subset, and one (2) which isn't.\n"
								+ "This can be changed by editing the code at line 51 and 52.\n"
								+ "Which one would you like to use? (1 or 2) ");
						int subChoice = scan.nextInt();
						switch (subChoice) {
						case 1: boolean isSubset = Arrays.hasSubsequence(array1, subArrayGood);
								System.out.println("Your Output Is: "+isSubset);
								break;
						case 2: isSubset = Arrays.hasSubsequence(array1, subArrayBad);
								System.out.println("Your Output Is: "+isSubset);
								break;
						default:	System.out.println("Wrong Choice! System will now exit!");
									System.exit(-1);
						}
						break;
				case 8:	int[] array2 = new int[]{43,56,3,8,0,21,4,8,3,12,87,99};
						System.out.println("======================================================\n"
								+ "Array has been initialized with random values whose size(or length) is equal to the original array\n"
								+ "This can be changed by editing the code at line 69.");
						int[] differenceArray = new int[array1.length];
						differenceArray = Arrays.absDif(array1, array2);
						System.out.println("The resultant Array is: "+Arrays.toString(differenceArray));
						break;
				default:	System.out.println("Wrong Choice! System will now exit!");
							System.exit(-1);
			
						
				}
		}
		catch (InputMismatchException e){
			System.out.println("Input Mismatch Exception Has Occured, Program Will Now Terminate: "+e);
			System.exit(-1);
		}
		finally {
			scan.close();
		}
	}

}

//InputMismatchException