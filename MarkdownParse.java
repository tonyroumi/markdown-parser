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
		while(true) {
			while(true) {
                int openBracket = markdown.indexOf("[", currentIndex);
                if(openBracket == -1) { 
                    break; 
                }
                if(openBracket > 0) {
                    if(markdown.charAt(openBracket - 1) == '!') {
                        currentIndex = openBracket + 1;
                        continue;
                    }
                }
			int closeBracket = markdown.indexOf("]", openBracket);
            if(closeBracket == -1) {
                break;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            if(openParen == -1) {
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen == -1) {
                break;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }
			
		
	
    }
	


    public static void main(String[] args) throws IOException {
		String contents = Files.readString(Path.of("./test-file2.md"));
	    ArrayList<String> links = getLinks(contents);
		System.out.println(links);

    }


}