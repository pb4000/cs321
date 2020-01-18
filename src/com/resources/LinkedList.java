package com.resources;

/**
 * A simple singly-linked list
 *
 * @param <T>
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    private Node<T> previous;
    private Node<T> tail;

    public LinkedList() {
        head = current = tail = previous = null;
    }

    public boolean hasNext() {  // true if next node exists
        return current.getNext() != null;
    }

    public Node<T> next() { // if has next, sets current node to next and returns that one
        if (hasNext()) {
            previous = current;
            current = current.getNext();
            return current;
        } else {
            return null;
        }
    }

    public Node<T> restart() {  // current node is set to the top and returns that node
        previous = null;
        current = head;
        return current;
    }

    public Node<T> getCurrent() {   // returns the current node
        return current;
    }

    public void add(T object) { // adds a node after the current node and sets the added node as current
        current.setNext(new Node<T>(object, current.getNext()));
        previous = current;
        current = current.getNext();
    }

    public T remove() { // removes the currently selected node and returns its value
        previous.setNext(current.getNext());
        Node<T> temp = current;
        current = previous;
        return temp.getObject();
    }
}
