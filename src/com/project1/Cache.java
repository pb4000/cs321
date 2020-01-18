package com.project1;

import com.resources.LinkedList;

/**
 * Thing to ask Yeh:
 * - files to turn in
 *      - naming scheme if so?
 * - how to interact with encyclopedia.txt
 *      - what does Test.java do
 * @param <T>
 */
public class Cache<T> {
    private LinkedList list;    // linked list to be used as cache
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
    }

    /**
     * Overwrites the currently selected node
     * @param object
     */
    public T write(T object) {
        return temp;
    }

    /**
     * Removes the currently selected node
     * @return
     */
    public T remove() {
        return null;
    }

    /**
     * Adds an object after the currently selected node
     * @param object
     */
    public void add(T object) {

    }
}
