import java.io.File;

public class FindAllFiles {
	public static void AllFiles(String directory){
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();
		
		for (File f: listOfFiles){
			if(f.isDirectory() || f.isFile()){
				System.out.println(f.getName());
			}
		}
	}
}
