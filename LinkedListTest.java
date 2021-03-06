/**
 *
 */
package prj5;

import java.util.Iterator;
import student.TestCase;

/**
 * @author Eric
 * @author maellis1
 * @version 11-2-15
 *
 */
public class LinkedListTest extends TestCase {
    private Iterator iter;
    private Iterator rIter;
    /**
     * the list we will use
     */
    private LinkedList<String> list;


    /**
     * run before every test case
     */
    @Override
    public void setUp() {
        list = new LinkedList<String>();
        iter = list.iterator();
        rIter = list.reverseIterator();

    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("", list.toString());
        list.add("A");
        assertEquals("A", list.toString());
        list.add("B");
        assertEquals("A\nB", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        LinkedList<String> emptyList = new LinkedList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * tests the has next method
     */
    public void testHasNext() {

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test1");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test2");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test3");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test4");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test5");
        assertFalse(iter.hasNext());

    }


    /**
     * tests the next method and checks for exceptions
     */
    public void testNext() {

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test1");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test2");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test3");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test4");
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), "test5");
        assertFalse(iter.hasNext());
        String testNext = null;
        try {
            iter.next();
        }
        catch (Exception e) {

            testNext = "caught";

        }
        assertNotNull(testNext);

    }


    /**
     * tests the remove method
     * checks for exceptions
     */
    public void testRemove() {

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        String test = null;
        try {
            iter.remove();
        }
        catch (Exception e) {

            test = "caught";

        }
        assertNotNull(test);
        iter.next();
        iter.remove();
        String test1 = null;
        try {
            iter.remove();
        }
        catch (Exception e) {

            test1 = "caught";

        }
        assertNotNull(test1);
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.hasNext();
        assertTrue(iter.hasNext());
        iter.next();
    }


    /**
     * tests the has next method for a reverse iterator
     */
    public void testRHasNext() {

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test5");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test4");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test3");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test2");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test1");
        assertFalse(rIter.hasNext());
        String testNext = null;
        try {
            rIter.next();
        }
        catch (Exception e) {

            testNext = "caught";

        }
        assertNotNull(testNext);

    }


    /**
     * tests the next method for a reverse iterator
     */
    public void testRNext() {

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test5");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test4");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test3");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test2");
        assertTrue(rIter.hasNext());
        assertEquals(rIter.next(), "test1");
        assertFalse(rIter.hasNext());

    }


    /**
     * tests remove method for reverse iterator
     */
    public void testRRemove() {

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        String test = null;
        try {
            rIter.remove();
        }
        catch (Exception e) {

            test = "caught";

        }
        assertNotNull(test);
        rIter.next();
        rIter.remove();
        String test1 = null;
        try {
            rIter.remove();
        }
        catch (Exception e) {

            test1 = "caught";

        }
        assertNotNull(test1);
        assertTrue(rIter.hasNext());
        rIter.next();
        assertTrue(rIter.hasNext());
        rIter.hasNext();
        assertTrue(rIter.hasNext());
        rIter.next();

    }


    /**
     * tests the sort method
     */
    public void testSort() {

        assertEquals(0, list.size());
        list.add("z");
        assertEquals(1, list.size());
        list.add("b");
        assertEquals(2, list.size());
        assertEquals("b", list.get(1));
        list.add("a");
        list.add("j");
        list.add("k");

        list = list.sort();
        assertEquals(list.toString(), "a\nb\nj\nk\nz");

        LinkedList<Integer> temp = new LinkedList<Integer>();
        temp.add(5);
        temp.add(5);
        temp.add(3);
        temp.add(7);
        temp.add(1);
        temp = temp.sort();
        assertEquals(temp.toString(), "1\n3\n5\n5\n7");

        LinkedList<Integer> temp2 = new LinkedList<Integer>();
        temp2.add(2);
        temp2.sort();
        assertEquals(temp2.toString(), "2");

        LinkedList<Integer> temp3 = new LinkedList<Integer>();
        temp3.sort();
        temp3.add(1);
        temp3.add(3);
        temp3.add(5);
        temp3.add(5);
        temp3.add(7);
        temp3.sort();
        assertEquals(temp.toString(), "1\n3\n5\n5\n7");
    }

}
