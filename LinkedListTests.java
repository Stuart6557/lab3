import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import org.junit.Test;

public class LinkedListTests {
    @Test
    public void testPrepend() {
        LinkedList testList = new LinkedList();
        testList.prepend(3);
        testList.prepend(2);
        testList.prepend(1);
        assertEquals(1, testList.root.value);
        assertEquals(2, testList.root.next.value);
        assertEquals(3, testList.root.next.next.value);
    }

    @Test
    public void testAppend() {
        LinkedList testList = new LinkedList();
        testList.append(1);
        testList.append(2);
        testList.append(3);
        assertEquals(1, testList.root.value);
        assertEquals(2, testList.root.next.value);
        assertEquals(3, testList.root.next.next.value);
    }

    @Test (expected = NoSuchElementException.class)
    public void testFirstEmpty() {
        LinkedList testList = new LinkedList();
        testList.first();
    }

    @Test
    public void testFirstNotEmpty() {
        LinkedList testList = new LinkedList();
        testList.prepend(2);
        assertEquals(2, testList.first());
        testList.prepend(1);
        assertEquals(1, testList.first());
    }

    @Test (expected = NoSuchElementException.class)
    public void testLastEmpty() {
        LinkedList testList = new LinkedList();
        testList.last();
    }

    @Test
    public void testLastNotEmpty() {
        LinkedList testList = new LinkedList();
        testList.append(2);
        assertEquals(2, testList.last());
        testList.prepend(1);
        assertEquals(2, testList.last());
        testList.append(3);
        assertEquals(3, testList.last());
    }

    @Test
    public void testToString() {
        LinkedList testList = new LinkedList();
        assertEquals("", testList.toString());
        testList.append(2);
        assertEquals("2 ", testList.toString());
        testList.prepend(1);
        assertEquals("1 2 ", testList.toString());
        testList.append(3);
        assertEquals("1 2 3 ", testList.toString());
    }

    @Test
    public void testLength() {
        LinkedList testList = new LinkedList();
        assertEquals(0, testList.length());
        testList.append(2);
        assertEquals(1, testList.length());
        testList.prepend(1);
        assertEquals(2, testList.length());
        testList.append(3);
        assertEquals(3, testList.length());
    }
}
