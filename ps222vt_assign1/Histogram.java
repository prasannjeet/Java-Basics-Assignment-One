package ps222vt_assign1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//A Self explanatory program
public class Histogram {
	public static void main(String[] args) {
		try {
		
			FileReader file;
			Scanner sc1 = null;
			String str = null;
			File f = null;
			try {
				str = "src\\ps222vt_assign1\\integers.dat";
				file = new FileReader(str);
				//System.out.println("Debug, Created File f");
				f = new File(str);
				sc1 = new Scanner(file);				
			} catch (FileNotFoundException e) {
				System.out.println("Error. File not found. Program will now terminate: \n"+e);
				System.exit(-1);
			}
			int i=0;
			ArrayList<Integer> x = new ArrayList<Integer>();
			while (sc1.hasNext()){
				i++;
				x.add(sc1.nextInt());
				//System.out.println(a+"abx");
			}
			int countUnder100=0, countUnder200=0;
			System.out.println("Reading integers from the file: "+f.getAbsolutePath());
			for (int j=0;j<i;j++){
				if (x.get(j)>=1 && x.get(j)<=100)countUnder100++;
				else if (x.get(j)>=101 && x.get(j)<=200)countUnder200++;
			}
			System.out.println("Number of integers in the interval [1,100]: "+countUnder100);
			System.out.println("in the interval [101,200]: "+countUnder200+"\n");
			int[] data = new int[11];
			for (@SuppressWarnings("unused") int y: data)y=0;
			for(int j=0;j<i;j++){
				for (int k=0;k<11;k++){
					if (x.get(j)>10*k && x.get(j)<=(10*k+10)){
						data[k]++;
					}
				}
			}
			System.out.println("Histogram");
			for (int k=0;k<10;k++){
				System.out.print((k*10+1)+"-"+(k*10+10)+"\t| ");
				for (int l=0;l<data[k];l++){
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.print("101-200\t| ");
			for (int k=0; k<countUnder200; k++)System.out.print("*");
		} catch (Exception e) {
			System.out.println("Oops! Some error with the file has occured.\n"
					+ "Make sure the file only has integer values separated by a line.\n"
					+ "Error code: "+e);
		}
	}

}
