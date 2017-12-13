package ps222vt_assign1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This program uses recursion to list all the java files in a directory as well
 * as it's subdirectories. The recursive method is: returnAllFiles
 * 
 * @author Prasannjeet Singh
 *
 */
public class CountJava {
	/**
	 * Takes the final ArrayList containing all the java files inside a directory
	 * (and subdirectory) and prints out the requested data to console.
	 * 
	 * @param str
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 */
	public static void listAllJavaFiles(String str) throws IOException, FileNotFoundException, NullPointerException {
		File dir = new File(str);
		ArrayList<File> allJavaFiles = new ArrayList<File>(returnAllFiles(listAllFilesFromDirectory(dir)));
		System.out.println("Root director: " + dir.getAbsolutePath());
		int i = 0;
		for (File tempFile : allJavaFiles) {
			int lines = 0;
			BufferedReader br = new BufferedReader(new FileReader(tempFile));
			while ((str = br.readLine()) != null)
				lines++;
			Path p = Paths.get(tempFile.toURI());
			String file = p.getFileName().toString();
			System.out.println("  " + (i + 1) + " " + file.toString() + "  lines = " + lines);
			i++;
			// System.out.println(i);
			br.close();
		}
	}

	/**
	 * Method recursively goes inside all the directories and filters out the java
	 * files, and stores it in the ArrayList named "returnList".
	 * 
	 * @param homeDirectoryFileList
	 * @return
	 */
	public static ArrayList<File> returnAllFiles(ArrayList<File> homeDirectoryFileList) {
		ArrayList<File> returnList = new ArrayList<File>();
		if (homeDirectoryFileList.isEmpty())
			return returnList;
		File dir = new File(homeDirectoryFileList.get(0).getParent());
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".java");
			}
		});
		returnList.addAll(convertFileToList(files));
		for (File tempFile : homeDirectoryFileList) {
			if (tempFile.isDirectory()) {
				// Recursively calling sub-directory
				returnList.addAll(returnAllFiles(listAllFilesFromDirectory(tempFile)));
			}
		}
		return returnList;
	}

	/**
	 * This method takes a directory path as an inptu and returns an arraylist
	 * containing all the files/folders inside that directory.
	 * 
	 * @param dir
	 * @return
	 */
	public static ArrayList<File> listAllFilesFromDirectory(File dir) {
		return new ArrayList<File>(convertFileToList(dir.listFiles()));
	}

	/**
	 * This method does nothing but convert a File-Array into an arraylist.
	 * 
	 * @param inFile
	 * @return
	 */
	public static ArrayList<File> convertFileToList(File[] inFile) {
		ArrayList<File> returnList = new ArrayList<File>();
		for (File file : inFile)
			returnList.add(file);
		return returnList;
	}

	/**
	 * We only call the listAllJavaFiles method from main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// listAllJavaFiles("ps222vt_assign1");
			listAllJavaFiles("ps222vt_assign1");
			// had to use double backslashes to pass the path because of the escape
			// sequence.
		} catch (FileNotFoundException e) {
			System.out.println("Error: file not found! Program will now terminate: " + e);
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Error: Some IO Error has occured. Program will now terminate: " + e);
		} catch (NullPointerException e) {
			// e.printStackTrace();
			System.out.println("Error: Wrong directory given as parameter. Program will now terminate: " + e);
		} catch (Exception e) {
			System.out.println("Some exception occured. Program will now terminate: "+ e);
		}
	}
}