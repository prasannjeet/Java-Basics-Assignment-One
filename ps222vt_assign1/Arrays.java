package ps222vt_assign1;
import java.util.InputMismatchException;
import java.util.ArrayList;
//Most methods in this program are self explanatory, except one or two, which are described.
public class Arrays {
	public static int sum(int[] arr){
		int s=0;
		for (int i=0;i<arr.length;i++){
			s=s+arr[i];
		}
		return s;
	}
	public static String toString(int[] arr){
		StringBuilder str = new StringBuilder("[");
		for (int i=0;i<arr.length;i++){
			str.append(String.valueOf(arr[i]));
			if (i!=(arr.length-1))str.append(",");
		}
		str.append("]");
		return (str.toString());
	}
	public static int[] addN(int[] arr, int n){
		for (int i=0;i<arr.length;i++)arr[i]+=n;
		return arr;
	}
	public static int[] reverse(int[] arr){
		int[] newArray = new int[arr.length];
		for (int i=0;i<arr.length;i++)newArray[i] = arr[arr.length-1-i];
		return newArray;
	}
	public static void replaceAll(int[] arr, int old, int nw){
		for (int i=0;i<arr.length;i++)if(arr[i]==old)arr[i]=nw;
	}
	public static int[] sort(int[] arr){
		int[] sortedArray = new int[arr.length];
		sortedArray = arr;
		java.util.Arrays.sort(sortedArray);
		/* Used Arrays.sort in java.util to sort the array. Had to include
		 * java.util in code because we already had this file called Arrays.
		 * Original array is unchanged.
		 */
		return sortedArray;
	}
	public static boolean hasSubsequence(int[] arr, int[] sub){
		/* Using ArrayList to find the subSequence, as the Collection Library
		 * has a good method containsAll() to find whether an ArrayList is a
		 * subset of another ArrayList.
		 */
		ArrayList<Integer> big = new ArrayList<>();
		ArrayList<Integer> small = new ArrayList<>();
		for (int a:arr)big.add(a);
		for (int a:sub)small.add(a);
		boolean returnValue = big.containsAll(small);
		return returnValue;	
	}
	public static int[] absDif(int[] arr1, int[] arr2){
		int[] arr3 = new int[arr1.length];
		try {
			if (arr1.length != arr2.length)throw new InputMismatchException();
			for (int i=0;i<arr1.length;i++)arr3[i]=Math.abs(arr1[i]-arr2[i]);
		}
		catch (InputMismatchException e){
			System.out.println("Both the arrays must have the same size. Program will now terminate!");
			System.exit(-1);
		}
		return arr3;
	}
}
