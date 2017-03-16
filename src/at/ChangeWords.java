package at;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ChangeWords {

	public static String[] execute(String[] words) {
		// variables
		int wordCount = words.length;
		boolean specialCharFlag = false;
		boolean punctuationFlag = false;

		// loop through each word and check for synonym
		for (int i = 0; i < wordCount; i++) {
			// set flags
			specialCharFlag = false;
			punctuationFlag = false;

			// check for special character
			specialCharFlag = SpecialCharacters.checkForSpecialChar(words[i]);
			punctuationFlag = SpecialCharacters.checkForPunctuation(words[i]);

			// if flags are false change word
			if (specialCharFlag == false && punctuationFlag == false) {
				if (changeWord(words[i]) != "") {
					words[i] = changeWord(words[i]);
				}
			}

		}

		return words;
	}// end of execute function

	public static String changeWord(String word) {
		String xmlPath = "//home/john_riley/Desktop/DEV/thesaurus/thesaurus.xml";
		String newWord = "";

		try {
			FileInputStream file = new FileInputStream(new File(xmlPath));

			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			Document xmlDocument = builder.parse(file);

			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/thesaurus/word/" + word;
			// System.out.println(expression); //xpath expression
			String xpathElement = xPath.compile(expression).evaluate(
					xmlDocument);
			if (xpathElement != "") {
				System.out.println("New Word: " + xpathElement);
				newWord = xpathElement;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return newWord;
	}// end of changeWord function

}// end of ChangeWords class
