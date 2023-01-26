import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ListTests {
    @Test
    public void testFilter() {
        class ExampleStringChecker implements StringChecker {
            @Override
            public boolean checkString(String s) {
                return !s.equals("a");
            }
        }
        String[] arr1 = {"a", "m", "p"};
        List<String> input1 = Arrays.asList(arr1);
        String[] arr1Output = {"m", "p"};
        List<String> expected1 = Arrays.asList(arr1Output);
        assertEquals(expected1, ListExamples.filter(input1, new ExampleStringChecker()));

        String[] arr2 = {"b", "n", "z"};
        List<String> input2 = Arrays.asList(arr2);
        String[] arr2Output = {"b", "n", "z"};
        List<String> expected2 = Arrays.asList(arr2Output);
        assertEquals(expected2, ListExamples.filter(input2, new ExampleStringChecker()));
    }

    @Test
    public void testMerge() {
        String[] input1Array = {"a", "a", "c"};
        List<String> input1 = Arrays.asList(input1Array);
        String[] input2Array = {"d", "z", "z"};
        List<String> input2 = Arrays.asList(input2Array);
        String[] expectedArray = {"a", "a", "c", "d", "z", "z"};
        List<String> expected = Arrays.asList(expectedArray);
        List<String> actual = ListExamples.merge(input1, input2);
        assertEquals(expected, actual);
    }
}
