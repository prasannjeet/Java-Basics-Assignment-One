package ps222vt_assign1;
import java.io.*;
/**
 * This program takes the path to file as in-parameter (argument) to the main method.
 * 
 * Sample command to run this file:
 * ================================================================================================================
 * java CountChars ps222vt_assign1\\SergioGarciaBeatsTheAmericans.txt											  |
 * ================================================================================================================
 * 
 * Note: Multiple arguments can also be given to this file, separated by a space, for example:
 * ================================================================================================================
 * java CountChars ps222vt_assign1\\SergioGarciaBeatsTheAmericans.txt ps222vt_assign1\\ArraysMain.java			  |
 * ================================================================================================================
 * 
 * @author Prasannjeet Singh
 *
 */
public class CountChars {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			for (int x = 0; x < args.length; x++) {
				//br = new BufferedReader(new FileReader("ps222vt_assign1\\SergioGarciaBeatsTheAmericans.txt"));
				br = new BufferedReader(new FileReader(args[x]));
				String str;
				int i = 0, u = 0, l = 0, w = 0, o = 0, n = 0;
				/* Using readLine() to read each line till we reach the end of the file
				 * and then using charAt(position) to individually check each
				 * character of that line. Using else if since it will effectively help
				 * in finding the remaining characters in the last 'else' token.
				 */
				while ((str = br.readLine()) != null) {
					i++;
					for (int k = 0; k < str.length(); k++) {
						if (Character.isDigit(str.charAt(k)))
							n++;
						else if (Character.isUpperCase(str.charAt(k)))
							u++;
						else if (Character.isLowerCase(str.charAt(k)))
							l++;
						else if (str.charAt(k) == ' ' || str.charAt(k) == '\t' || str.charAt(k) == '\n')
							w++;
						else
							o++;
					}
				}
				/* Int i is used to calculate total number of new lines in the file.
				 * Once out of the loop, the value of i reduced by 1 is also added to whitespaces,
				 * as the question asks us to include 'return' in whitespaces. Reducing the value
				 * by 1 because the last line of any file does not have a 'return' at the end.
				 */
				System.out.println("For Argument "+(x+1)+" :");
				System.out.println("Upper Case Letters: " + u + "\nLower Case Letters: " + l + "\nWhitespaces: "
						+ (w + i - 1) + "\nOther Characters: " + o + "\nNumbers: " + n);
				System.out.println("============================================================================");
			}

			//System.out.println("Debug Value of I: "+i);
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
			return;
		}
		catch (IOException e){
			System.out.println("IO Error, Sorry!");
			return;
		}
		finally {
				try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}