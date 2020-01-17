package com.resources;

public class DLLNode<T> {
	private DLLNode<T> previous;	// previous node
	private DLLNode<T> next;	// next node
	private T element;	// element store
	
	/**
	 * Constructor with all variables instantiated
	 * @param element
	 * @param next
	 * @param previous
	 */
	public DLLNode(T element, DLLNode<T> next, DLLNode<T> previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}
	
	/**
	 * Constructor with only element instantiated
	 * @param element
	 */
	public DLLNode(T element) {
		this.element = element;
		next = previous = null;
	}
	
	/**
	 * Constructor with only element instantiated
	 * @param element
	 */
	public DLLNode(T element, DLLNode<T> previous) {
		this.element = element;
		this.previous = previous;
		next = null;
	}
	
	/**
	 * Constructor with nothing instantiated
	 */
	public DLLNode() {
		element = null;
		next = previous = null;
	}
	
	/**
	 * Returns next node
	 * @return
	 */
	public DLLNode<T> getNext() {
		return next;
	}
	
	/**
	 * Returns previous node
	 * @return
	 */
	public DLLNode<T> getPrevious() {
		return previous;
	}
	
	/**
	 * Sets next node
	 * @param next
	 */
	public void setNext(DLLNode<T> next) {
		this.next = next;
	}
	
	/**
	 * Sets previous node
	 * @param previous
	 */
	public void setPrevious(DLLNode<T> previous) {
		this.previous = previous;
	}
	
	/**
	 * Sets element
	 * @param element
	 */
	public void setElement(T element) {
		this.element = element;
	}
	
	/**
	 * Returns element
	 * @return
	 */
	public T getElement() {
		return element;
	}

}
