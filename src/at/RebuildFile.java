package at;

public class RebuildFile {

	public static String execute(String[] words) {
		// variables
		int wordCount = words.length;
		String fileContents = "";

		for (int i = 0; i < wordCount; i++) {
			fileContents = fileContents + " " + words[i];
		}

		return fileContents;
	}

}// end of RebuildFile class
