package at;


public class AutoThesaurus {

	public static void main(String[] args) {
		final String DOCUMENT_DIRECTORY = "/home/john_riley/Desktop/DEV/at_test.txt";
		// final String THESAURUS_DIRECTORY =
		// "/home/john_riley/Desktop/DEV/thesaurus/thesaurus.xml";

		FileInformation.debug(DOCUMENT_DIRECTORY);

		String[] words = ParseWords.toArray(FileInformation
				.fileContents(DOCUMENT_DIRECTORY));
		String[] newWords = ChangeWords.execute(words);

		System.out.println(RebuildFile.execute(newWords));

	}// end main function

}// end AutoThesaurus class
