package com.project1;

import com.resources.IUDoubleLinkedList;
import com.resources.LinkedList;
import com.resources.Node;

/**
 * Thing to ask Yeh:
 * - files to turn in
 * - naming scheme if so?
 * - how to interact with encyclopedia.txt
 * - what does Test.java do
 *
 * @param <T>
 */
public class Cache<T> {

    /**
     * General Variables
     */
    private LinkedList<T> list;    // linked list to be used as cache
    private int maxSize;   // maximum size of the cache
    private int size;   // current size of cache
    private T temp;

    /**
     * Constructor
     *
     * @param maxSize
     */
    public Cache(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        list = new LinkedList<T>();
    }

    /**
     * Finds specified object
     *
     * @param object
     * @return
     */
    public T search(T object) {
        if (exists(object)) {
            System.out.println("Hit");
            update();
            return temp;
        } else {
            return null;
        }
    }

    /**
     * Adds given object to top of cache
     *
     * @param object
     */
    public void addToTop(T object) {
        Node<T> n = new Node<T>(temp, list.head);
        list.head = n;
        size++;
        if (size == 1) {
            list.tail = list.head;
        } else if (size == maxSize) {
            
        }
    }

    /**
     * Updates list, moving the currently selected
     * object to the top
     */
    private void update() {
        temp = list.current.getObject();
        list.previous.setNext(list.current.getNext());
        Node<T> n = new Node<T>(temp, list.head);
        list.head = n;
    }

    /**
     * Overwrites the currently selected node
     *
     * @param object
     */
    public T write(T object) {
        temp = list.current.getObject();
        list.remove();
        list.add(object);
        return temp;
    }

    /**
     * Removes the currently selected node
     *
     * @return
     */
    public T remove() {
        return list.remove();
    }

    /**
     * Adds an object after the currently selected node
     *
     * @param object
     */
    public void add(T object) {
        list.add(object);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    /**
     * Cycles through Cache to find a given object. Desired
     * object is still selected in list after operation
     *
     * @param object
     * @return
     */
    public boolean exists(T object) {
        list.restart();
        for (int i = 0; i < size; i++) {
            if (list.current.getObject() == object) {
                return true;
            } else {
                list.next();
            }
        }
        return false;
    }
}
