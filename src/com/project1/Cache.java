package com.project1;

import com.resources.IUDoubleLinkedList;

public class Cache<T> {
    private IUDoubleLinkedList list;    // linked list to be used as cache
    private int maxSize;   // maximum size of the cache
    private int size;   // current size of cache

    /**
     * Constructor
     * @param maxSize
     */
    public Cache(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
    }

    public void write(T object) {

    }

    public T remove() {
        return null;
    }

    public void add(T object) {

    }
}
