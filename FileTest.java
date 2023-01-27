import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;

public class FileTest {
    @Test
    public void test() throws IOException {
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
