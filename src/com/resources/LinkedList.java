package com.resources;

/**
 * A simple singly-linked list
 *
 * @param <T>
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    private Node<T> tail;

    public LinkedList() {
        head = current = tail = null;
    }

    public boolean hasNext() {  // true if next node exists
        return current.getNext() != null;
    }

    public Node<T> next() { // if has next, sets current node to next and returns that one
        if (hasNext()) {
            current = current.getNext();
            return current;
        } else {
            return null;
        }
    }

    public Node<T> restart() {  // current node is set to the top and returns that node
        current = head;
        return current;
    }

    public Node<T> getCurrent() {   // returns the current node
        return current;
    }
}
