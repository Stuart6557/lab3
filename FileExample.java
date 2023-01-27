import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class FileExample {

  /*

  Given a File (which can represent either a file or directory), return a list
  of all the files in that directory and all its subdirectories.

  If given the path of a file (rather than a directory), it returns a list with
  just that element.
  
  For example, for the following structure:

  some-files/
  |-  a.txt
  |-  more-files/
      |-  b.txt
      |-  c.java
  |-  even-more-files/
      |-  d.java
      |-  a.txt

  Given new File("some-files/") as a parameter, we'd expect [some-files/a.txt,
  some-files/more-files/b.txt, some-files/more-files/c.java,
  some-files/even-more-files/d.java, some-files/even-more-files/a.txt] as results

  Given new File("some-files/more-files") as a parameter, we'd expect
  [some-files/more-files/b.txt, some-files/more-files/c.java] as results

  Given new File("some-files/a.txt") as a parameter, we'd expect
  [some-files/a.txt] and a result

  See the File documentation here: https://docs.oracle.com/javase/8/docs/api/java/io/File.html

  */

	static List<File> getFiles(File start) throws IOException {
	  File f = start;
	  List<File> result = new ArrayList<>();
    /*
     * Old buggy code:
     * result.add(start);
	   * if(f.isDirectory()) {
	   *   File[] paths = f.listFiles();
	   *   for(File subFile: paths) {
	   *     result.add(subFile);
	   *   }
	   * }
     */
	  if(f.isDirectory()) {
	    File[] paths = f.listFiles();
	    for(File subFile: paths) {
        if(subFile.isDirectory()) {
          List<File> moreFiles = getFiles(subFile);
          for(File file : moreFiles) {
            result.add(file);
          }
        } else {
          result.add(subFile);
        }
	    }
	  } else {
      result.add(start);
    }
	  return result;
	}

  public static void main(String[] args) throws IOException {
    File[] expectedArr = {new File("some-files/even-more-files/d.java"),
        new File("some-files/even-more-files/a.txt"),
        new File("some-files/more-files/c.java"),
        new File("some-files/more-files/b.txt"),
        new File("some-files/a.txt")};
    List<File> expected = Arrays.asList(expectedArr);
    File start = new File("some-files");
    List<File> actual = FileExample.getFiles(start);
    for(int i = 0; i < expected.size(); i++) {
      System.out.println(expected.get(i));
      System.out.println(actual.get(i));
      System.out.println();
    }
  }
}
