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
			int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
			int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
			currentIndex = closeParen + 1;
			if (markdown.indexOf("[", currentIndex) == -1){
                break;
            }
			else if (markdown.indexOf("]", currentIndex) == -1){
                break;
            }
			if (openBracket!=0){
                if (!markdown.substring(openBracket + 1, closeBracket).equals("Image")&&
                !markdown.substring(openBracket - 1, openBracket).equals("!")){
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                }
            }
		currentIndex = closeParen + 1;
	}
		
		
		return toReturn;
		
	}

    public static void main(String[] args) throws IOException {
		String contents = Files.readString(Path.of("./test-file3.md"));
	    ArrayList<String> links = getLinks(contents);
		System.out.println(links);

    }


}