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
    private T temp;

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
        if (head != null) {
            previous = current;
            current = current.getNext();
            previous.setNext(new Node<T>(object));
            previous.getNext().setNext(current);
            current = previous.getNext();
        } else {
            head = tail = current = new Node<T>(object);
        }
    }

    public T remove() { // removes the currently selected node and returns its value
        if (head != null) {
            if (current != head) {
                previous.setNext(current.getNext());
                temp = current.getObject();
                current = previous;
            } else {
                head = current.getNext();
                temp = current.getObject();
                current = head;
            }
            return temp;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> yeet = head;
        while (yeet.hasNext()) {
            str += yeet.getObject().toString();
            yeet = yeet.getNext();
        }
        str += yeet.getObject().toString();
        return str;
    }
}
