import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);
	}


  @Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }

  @Test
  public void testReverseInPlaceUnsymmetrical() {
    int[] input = {3, 4, 5};
    ArrayExamples.reverseInPlace(input);
    assertArrayEquals(new int[]{5, 4, 3}, input);
  }

  @Test
  public void testReverseNotEmpty() {
    int[] input = {1, 2, 3};
    assertArrayEquals(new int[]{3, 2, 1}, ArrayExamples.reversed(input));
  }

  @Test
  public void testAverageWithoutLowest() {
    double[] input = {1, 2, 3};
    assertEquals(2.5, ArrayExamples.averageWithoutLowest(input), 0.001);

    input = new double[]{1, 1, 2, 3};
    assertEquals(2.0, ArrayExamples.averageWithoutLowest(input), 0.001);
  }
}