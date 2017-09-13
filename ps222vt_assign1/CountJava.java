package ps222vt_assign1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
//import java.net.URI;
//import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CountJava {
	public static void listJavaFiles (String str) throws IOException, FileNotFoundException, NullPointerException{
		//Exceptions are handled in the main function.
		File dir = new File (str);
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".java");
		    }
		});
		/* Created an array of files from a particular path which is 'str'
		 * but added only the files that ends with the extension .java using
		 * the endsWith(str) function.
		 */
		int l = files.length;
		System.out.println("Root director: "+dir.getAbsolutePath());
		for (int i=0;i<l;i++){
			int lines = 0;
			BufferedReader br = new BufferedReader (new FileReader(files[i]));
			while ((str=br.readLine()) != null)lines++;
			Path p = Paths.get(files[i].toURI());
			String file = p.getFileName().toString();
			System.out.println("  "+(i+1)+" "+file.toString()+"  lines = "+lines);
			//System.out.println(i);
			br.close();
		}
	}
	public static void main(String[] args) {
		try {
			listJavaFiles("src\\ps222vt_assign1");
			//had to use double backslashes to pass the path because of the escape sequence.
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error: file not found! Program will now terminate: "+e);
			//e.printStackTrace();
		}
		catch (IOException e){
			//e.printStackTrace();
			System.out.println("Error: Some IO Error has occured. Program will now terminate: "+e);
		}
		catch (NullPointerException e){
			//e.printStackTrace();
			System.out.println("Error: Wrong directory given as parameter. Program will now terminate: "+e);
		}
		//listJavaFiles();
	}
}