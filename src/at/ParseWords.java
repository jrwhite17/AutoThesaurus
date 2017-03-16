package at;

public class ParseWords {

	public static String[] toArray(String fileContents) {
		// parses file contents String (words) to array

		// parse special characters
		fileContents = SpecialCharacters.parseSpecialCharacters(fileContents);

		String[] words = fileContents.split("\\s+");
		int wordCount = words.length;

		for (int i = 0; i < wordCount; i++) {
			// System.out.println(i + 1 + " Word: " + words[i]);
		}
		return words;
	}// end of toArray function

}// end of ParseWords class
