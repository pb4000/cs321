package com.project1;

import com.resources.IUDoubleLinkedList;
import com.resources.LinkedList;
import com.resources.Node;

/**
 * Thing to ask Yeh:
 * - files to turn in
 *      - naming scheme if so?
 * - how to interact with encyclopedia.txt
 *      - what does Test.java do
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
     * @param maxSize
     */
    public Cache(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        list = new LinkedList<T>();
    }

    /**
     * Overwrites the currently selected node
     * @param object
     */
    public T write(T object) {
        temp = list.getCurrent().getObject();
        list.remove();
        list.add(object);
        return temp;
    }

    /**
     * Removes the currently selected node
     * @return
     */
    public T remove() {
        return list.remove();
    }

    /**
     * Adds an object after the currently selected node
     * @param object
     */
    public void add(T object) {
        list.add(object);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
