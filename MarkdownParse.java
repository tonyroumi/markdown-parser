// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/ 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

	public static ArrayList<String> getLinks(String markdown) {

		ArrayList<String> toReturn = new ArrayList<>();
		// Find the next [, then find ], then find (, then take up to the next )
		int currentIndex = 0;
		while(currentIndex < markdown.length()) {
			int nextOpenBracket = markdown.indexOf("[", currentIndex);
			int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
			int openParan = markdown.indexOf("(", nextCloseBracket);
			int closeParan = markdown.indexOf(")", openParan);
			toReturn.add(markdown.substring(openParan + 1, closeParan));
			currentIndex = closeParan + 1;
		}
		
		return toReturn;
		
	}

    public static void main(String[] args) throws IOException {
		String contents = Files.readString(Path.of("./test-file2.md"));
	    ArrayList<String> links = getLinks(contents);
		System.out.println(links);

    }


}