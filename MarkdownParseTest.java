import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class MarkdownParseTest {
  @Test
  public void addition() {
    assertEquals(2, 1 + 1);
  }
  
  @Test
  public void linksTest() throws IOException {
    Path fileName = Path.of("test-file.md");
    String content = Files.readString(fileName);
    ArrayList<String> links = MarkdownParse.getLinks(content);
    ArrayList<String> correctOutput = new ArrayList<String>();
    correctOutput.add("https://something.com");
    correctOutput.add("some-thing.html");
    assertEquals(correctOutput, links);
  }

  @Test
  public void test2() throws IOException {
    Path fileName = Path.of("test-file2.md");
    String content = Files.readString(fileName);
    ArrayList<String> links = MarkdownParse.getLinks(content);
    ArrayList<String> correctOutput = new ArrayList<String>();
    correctOutput.add("https://something.com");
    correctOutput.add("https://something.com");
    assertEquals(correctOutput, links);
  }

  @Test
  public void test3() throws IOException {
    Path fileName = Path.of("test-file3.md");
    String content = Files.readString(fileName);
    ArrayList<String> links = MarkdownParse.getLinks(content);
    ArrayList<String> correctOutput = new ArrayList<String>();
    correctOutput.add("https://something.com");
    correctOutput.add("https://something.com");
    assertEquals(correctOutput, links);
  }


// @Test
// public void test4() throws IOException {
//   Path fileName = Path.of("test-file5.md");
//   String content = Files.readString(fileName);
//   ArrayList<String> links = MarkdownParse.getLinks(content);
//   ArrayList<String> correctOutput = new ArrayList<String>();
//   assertEquals(correctOutput, links);
// }
}


//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
