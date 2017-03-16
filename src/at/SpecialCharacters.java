package at;

import java.util.Arrays;
import java.util.List;

public class SpecialCharacters {

	static String parseSpecialCharacters(String fileContents) {
		// add a space before each special character
		List<String> specialChars = Arrays.asList("`", "~", "@", "#", "$", "%",
				"^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "]", "{",
				"}", "\\", "|", "'", "<", ">", "/", ".", "?", "!", ",", ";",
				":");

		for (String specialChar : specialChars) {
			fileContents = fileContents.replace(specialChar, " " + specialChar);
		}

		return fileContents;
	}// end parseSpecialCharacters

	static boolean checkForSpecialChar(String word) {
		// List containing special characters
		List<String> specialChars = Arrays.asList("`", "~", "@", "#", "$", "%",
				"^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "]", "{",
				"}", "\\", "|", "'", "<", ">", "/");

		if (specialChars.contains(word)) {
			// word is a special char
			return true;
		} else {
			// word is not a special char
			return false;
		}
	}// end checkForSpecialChar function

	static boolean checkForPunctuation(String word) {
		// List containing punctuation characters
		List<String> punctuationChars = Arrays.asList(".", "?", "!", ",", ";",
				":");

		if (punctuationChars.contains(word)) {
			// word is a punctuation char
			return true;
		} else {
			// word is not a punctuation char
			return false;
		}
	}// end checkForPunctuation function

	static boolean checkForLeftQuote(String word) {

		if (word.charAt(0) == '"') {
			// word begins with a quote
			return true;
		} else {
			// word doesn't begin with a quote
			return false;
		}
	}// end checkForLeftQuote function

	static boolean checkForRightQuote(String word) {

		if (word.charAt(word.length() - 1) == '"') {
			// word ends with a quote
			return true;
		} else {
			// word doesn't end with a quote
			return false;
		}
	}// end checkForRightQuote function

}// end SpecialCharacters class