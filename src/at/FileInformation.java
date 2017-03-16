package at;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInformation {

	public static String fileContents(String fileDirectory) {
		File file = new File(fileDirectory);
		FileInputStream fis = null;
		StringBuilder fileContents = new StringBuilder();

		try {
			fis = new FileInputStream(file);

			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and append it
				fileContents.append((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return fileContents.toString();
	}// end of fileContents

	public static int fileSize(String fileDirectory) {
		// return the size of the file in bytes
		File file = new File(fileDirectory);
		FileInputStream fs = null;
		int fileSize = 0;

		try {
			fs = new FileInputStream(file);
			fileSize = fs.available();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fs != null)
					fs.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return fileSize; // in bytes
	}// end of fileSize function

	public static String fileNameLinux(String fileDirectory) {

		int index = fileDirectory.lastIndexOf("/");
		String fileNameType = fileDirectory.substring(index + 1);
		int nameEnd = fileNameType.indexOf(".");
		if (nameEnd != -1) {
			String fileName = fileNameType.substring(0, nameEnd);
			return fileName;
		}

		// there is not an extension type
		return fileNameType;
	}// end of fileNameLinux function

	public static String fileNameWindows(String fileDirectory) {

		int index = fileDirectory.lastIndexOf("\\");
		String fileNameType = fileDirectory.substring(index + 1);
		int nameEnd = fileNameType.indexOf(".");
		if (nameEnd != -1) {
			String fileName = fileNameType.substring(0, nameEnd);
			return fileName;
		}

		// there is not an extension type
		return fileNameType;
	}// end of fileNameWindows function

	public static String fileType(String fileDirectory) {

		int index = fileDirectory.lastIndexOf(".");
		String fileType = fileDirectory.substring(index + 1);

		return fileType;
	}// end of fileType function

	public static void debug(String fileDirectory) {
		// prints file information to console
		System.out.println("File Name: " + fileNameLinux(fileDirectory));
		System.out.println("File Type: " + fileType(fileDirectory));
		System.out.println("File Size: " + fileSize(fileDirectory) + " bytes");
		System.out.println("File Contents: " + fileContents(fileDirectory));
	}// end of debug function

}// end of FileInformation class
