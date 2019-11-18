package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This provides implementation for some of the LList methods.
 *
 * @author Alex Namkung (anamkung)
 * @version 11/15/19
 * @author Kai Kato (kaikato26)
 * @version 11/15/19
 * @author Sam Hita (samhita7)
 * @version 11/15/19
 * @param <E>
 *            The type of object the class will store
 */
public class LinkedList<E> {

    /**
     * This represents a node in a doubly linked list. This node stores data, a
     * pointer to the node before it in the list, and a pointer to the node
     * after it in the list
     *
     * @param <E>
     *            This is the type of object that this class will store
     * @author Alex Namkung (anamkung)
     * @version 11/15/19
     */
    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<E> n) {
            previous = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous() {
            return previous;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }
    }

    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> tail;


    /**
     * Create a new DLList object.
     */
    public LinkedList() {
        init();
    }


    /**
     * Sorts the linkedList
     * 
     * @return LinkedList<E>
     */
    public LinkedList<E> sort() {

        LinkedList<E> tempSort = new LinkedList<E>();
        if (this.size <= 1) {
            return this;
        }
        tempSort.add(this.get(0));
        for (int i = 1; i < this.size; i++) {

            E curr = this.get(i);
            boolean addCheck = false;
            for (int j = 0; j < tempSort.size; j++) {

                E innerCurr = tempSort.get(j);
                if ((curr.toString()).compareTo(innerCurr.toString()) < 0) {
                    tempSort.add(j, curr);
                    addCheck = true;
                    break;
                }

            }

            if (!addCheck) {
                tempSort.add(curr);
            }

        }
        return tempSort;
    }


    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init() {
        head = new LinkedList.Node<E>(null);
        tail = new LinkedList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        init();
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj) {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(E newEntry) {
        add(size(), newEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj) {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1; // if we do not find it
    }


    /**
     * Removes the element at the specified index from the list
     *
     * @param index
     *            where the object is located
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     * @return true if successful
     */
    public boolean remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }


    /**
     * Removes the first object in the list that .equals(obj)
     *
     * @param obj
     *            the object to remove
     * @return true if the object was found and removed
     */

    public boolean remove(E obj) {
        Node<E> current = head.next();
        while (!current.equals(tail)) {
            if (current.getData().equals(obj)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!isEmpty()) {
            Node<E> currNode = head.next();
            while (currNode != tail) {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail) {
                    builder.append("\n");
                }
                currNode = currNode.next();
            }
        }

        return builder.toString();
    }


    /**
     * method for list to call iterator
     * 
     * @return an iterator
     */
    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }


    /**
     * 
     * creates a reverse iterator
     * 
     * @return a reverse iterator
     */
    public Iterator<E> reverseIterator() {
        return new RDLListIterator<E>();
    }


    private class DLListIterator<A> implements Iterator<E> {

        private Node point;
        private E nextSafe;


        /**
         * Creates a new DLListIterator
         */
        public DLListIterator() {

            point = head;
            nextSafe = null;

        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {

            return point.next().getData() != null;

        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (point.next().getData() == null) {
                throw new NoSuchElementException();
            }
            point = point.next();
            nextSafe = (E)point.getData();
            return (E)point.getData();

        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (nextSafe == null) {
                throw new IllegalStateException("next was never called");
            }
            if (nextSafe != point.getData()) {

                throw new IllegalStateException(
                    "you can only call remove once per next");

            }

            Node temp = new Node(null);
            Node rem = new Node(null);
            temp = point.next();
            rem = point;
            point = point.previous();
            rem.setNext(null);
            rem.setPrevious(null);
            point.setNext(temp);
            temp.setPrevious(point);
            rem = null;

            temp = null;
            size--;

        }

    }


    private class RDLListIterator<A> implements Iterator<E> {

        private Node point;
        private E nextSafe;


        /**
         * Creates a new DLListIterator
         */
        public RDLListIterator() {

            point = tail;
            nextSafe = null;

        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {

            return point.previous().getData() != null;

        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (point.previous().getData() == null) {
                throw new NoSuchElementException();
            }
            point = point.previous();
            nextSafe = (E)point.getData();
            return (E)point.getData();

        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (nextSafe == null) {
                throw new IllegalStateException("next was never called");
            }
            if (nextSafe != point.getData()) {

                throw new IllegalStateException(
                    "you can only call remove once per next");

            }

            Node temp = new Node(null);
            Node rem = new Node(null);
            temp = point.previous();
            rem = point;
            point = point.next();
            rem.setNext(null);
            rem.setPrevious(null);
            point.setPrevious(temp);
            temp.setNext(point);
            rem = null;

            temp = null;
            size--;

        }

    }

}
