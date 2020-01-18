package com.resources;

/**
 * A simple Node class for a singly-linked list
 * @param <T>
 */
public class Node<T> {
    private T object;
    private Node<T> next;

    public Node(T object, Node next) {
        this.object = object;
        this.next = next;
    }

    public Node(T object) {
        this.object = object;
        next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
