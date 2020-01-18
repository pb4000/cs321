package com.resources;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("hiding")
public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T> {
	private DLLNode<T> first; // first node
	private DLLNode<T> last; // last node
	private DLLNode<T> current; // current node
	private int size;

	/**
	 * Constructor instantiating elements to null
	 */
	public IUDoubleLinkedList() {
		first = last = current = null;
		size = 0;
	}

	/**
	 * Adds given element to front of list
	 */
	@Override
	public void addToFront(T element) {
		switch (size) {
		case 0:
			last = first = new DLLNode<T>(element);
			size++;
			return;
		default:
			first.setPrevious(new DLLNode<T>(element));
			first.getPrevious().setNext(first);
			first = first.getPrevious();
			size++;
			return;
		}
	}

	/**
	 * Adds given element to rear
	 */
	@Override
	public void addToRear(T element) {
		switch (size) {
		case 0:
			last = first = new DLLNode<T>(element);
			size++;
			return;
		default:
			last.setNext(new DLLNode<T>(element));
			last.getNext().setPrevious(last);
			last = last.getNext();
			size++;
			return;
		}
	}

	/**
	 * Adds given element to end of list
	 */
	@Override
	public void add(T element) {
		addToRear(element);
	}

	/**
	 * Adds given element after specified target node
	 */
	@Override
	public void addAfter(T element, T target) {
		if (indexOf(target) == -1) {
			throw new NoSuchElementException("Target element does not exist");
		}
		add(indexOf(target) + 1, element);
	}

	/**
	 * Adds given element at specified index
	 */
	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			addToFront(element);
		} else if (index == size) {
			addToRear(element);
		} else {
			current = getNode(index);
			current.getPrevious().setNext(new DLLNode<T>(element));
			current.getPrevious().getNext().setPrevious(current.getPrevious());
			current.getPrevious().getNext().setNext(current);
			current.setPrevious(current.getPrevious().getNext());
			size++;
		}
	}

	/**
	 * Removes first element in list
	 */
	@Override
	public T removeFirst() {
		switch (size) {
		case 0:
			throw new NoSuchElementException("List has no elements");
		case 1:
			T temp0 = first.getElement();
			first = last = null;
			size--;
			return temp0;
		default:
			T temp = first.getElement();
			first = first.getNext();
			first.setPrevious(null);
			size--;
			return temp;
		}
	}

	/**
	 * Removes last element in list
	 */
	@Override
	public T removeLast() {
		switch (size) {
		case 0:
			throw new NoSuchElementException("List has no elements");
		case 1:
			T temp0 = last.getElement();
			first = last = null;
			size--;
			return temp0;
		default:
			T temp = last.getElement();
			last = last.getPrevious();
			last.setNext(null);
			size--;
			return temp;
		}
	}

	/**
	 * Removes specified element
	 */
	@Override
	public T remove(T element) {
		DLLNode<T> node = getNode(element);
		if (node == null) {
			throw new NoSuchElementException("Element does not exist");
		}
		if (node == first) {
			return removeFirst();
		} else if (node == last) {
			return removeLast();
		} else {
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
			size--;
			return node.getElement();
		}
	}

	/**
	 * Removes element at given index
	 */
	@Override
	public T remove(int index) {
		DLLNode<T> node = getNode(index);
		if (node == null) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
			size--;
			return node.getElement();
		}
	}

	/**
	 * Sets element at specified index
	 */
	@Override
	public void set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		if (index == 0) {
			if (size == 0) {
				first = last = new DLLNode<T>(element);
				size++;
			} else {
				first.setElement(element);
			}
		} else {
			DLLNode<T> node = getNode(index);
			if (node == null) {
				throw new IndexOutOfBoundsException("Index is out of bounds");
			}
			node.setElement(element);
		}
	}

	/**
	 * Returns element at specified index
	 */
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		return getNode(index).getElement();
	}

	/**
	 * Returns index of specified element
	 */
	@Override
	public int indexOf(T element) {
		current = first;
		for (int i = 0; i < size; i++) {
			if (current.getElement() == element) {
				return i;
			} else {
				current = current.getNext();
			}
		}
		return -1;
	}

	/**
	 * Returns first element in list
	 */
	@Override
	public T first() {
		if (size == 0) {
			throw new NoSuchElementException("Element does not exist");
		}
		return first.getElement();
	}

	/**
	 * Returns last element in list
	 */
	@Override
	public T last() {
		if (size == 0) {
			throw new NoSuchElementException("Element does not exist");
		}
		return last.getElement();
	}

	/**
	 * Returns true if specified target is in list
	 */
	@Override
	public boolean contains(T target) {
		if (size > 0) {
			current = first;
			while (current != null) {
				if (current.getElement() == target) {
					return true;
				}
				current = current.getNext();
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Returns true if empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns size of list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Gets node containing specified element Returns null if element does not exist
	 * 
	 * @param element
	 * @return
	 */
	private DLLNode<T> getNode(T element) {
		current = first;
		for (int i = 0; i < size && size != 0; i++) {
			if (current.getElement() == element) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}

	/**
	 * Returns node at specified index Check for valid index before calling method
	 * Throw appropriate exceptions in parent method
	 * 
	 * @param index
	 * @return
	 */
	private DLLNode<T> getNode(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		current = first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	/**
	 * Returns ListIterator objects
	 */
	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>();
	}

	/**
	 * Throws exception
	 */
	@Override
	public java.util.ListIterator<T> listIterator() {
		return new ListIterator<T>();
	}

	/**
	 * Throws exception
	 */
	@Override
	public java.util.ListIterator<T> listIterator(int startingIndex) {
		//throw new UnsupportedOperationException();
		if (startingIndex < 0 || startingIndex >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		
		return new ListIterator<T>(startingIndex);
	}

	private class ListIterator<Character> implements Iterator<Character>, java.util.ListIterator<Character> {
		private DLLNode<Character> next; // next node
		private boolean canRemove; // can remove
		private boolean fwd, back, pivot, returned; // keep track of prev and next

		/**
		 * Constructor
		 */
		@SuppressWarnings("unchecked")
		private ListIterator() {
			next = new DLLNode<Character>();
			next.setNext((DLLNode<Character>) first);
			if (next.getNext() != null) {
				next.getNext().setPrevious(next);
			}
			canRemove = back = pivot = returned = false;
			fwd = true;
		}
		
		/**
		 * Constructor with starting index
		 */
		@SuppressWarnings("unchecked")
		private ListIterator(int index) {
			next = new DLLNode<Character>();
			next.setNext((DLLNode<Character>) first);
			for (int i = -1; i < index; i++) {
				next = next.getNext();
			}
			canRemove = back = pivot = returned = false;
			fwd = true;
		}

		/**
		 * True if iterator has next node
		 */
		@Override
		public boolean hasNext() {
			if (pivot) {
				return true;
			} else {
				if (next.getNext() != null) {
					return true;
				}
				canRemove = false;
				return false;
			}

		}

		/**
		 * Iterates to next node
		 */
		@Override
		public Character next() {
			if (hasNext()) {
				if (pivot) {
					canRemove = fwd = returned = true;
					back = pivot = false;
					return next.getElement();
				} else {
					canRemove = fwd = returned = true;
					back = false;
					next = next.getNext();
					return next.getElement(); // maybe change to return new element?
				}
			}
			throw new NoSuchElementException("No next element");
		}

		/**
		 * Removes current node
		 */
		public void remove() {
			if (canRemove) {
				canRemove = fwd = back = pivot = returned = false;
				next = next.getPrevious();
				next.setNext(next.getNext().getNext());
				if (next.getNext() != null)
					next.getNext().setPrevious(next);
			} else {
				throw new IllegalStateException();
			}
			fwd = true;
		}

		/**
		 * Adds a node after next
		 */
		@Override
		public void add(Character input) {
			if (back) {
				next = next.getPrevious();
				next.getNext().setPrevious(new DLLNode<Character>(input, next.getNext(), next));
				next.setNext(next.getNext().getPrevious());
			} else {
				if (next.getNext() == null) {
					next.setNext(new DLLNode<Character>(input, next));
				} else {
					next.setNext(new DLLNode<Character>(input, next.getNext(), next));
					next.getNext().getNext().setPrevious(next.getNext());
				}
			}
			next = next.getNext();
			fwd = true;
			back = pivot = canRemove = returned = false;
		}

		/**
		 * True if next has previous node
		 */
		@Override
		public boolean hasPrevious() {
			if (fwd) {
				if (next.getElement() != null) {
					return true;
				}
				return false;
			} else {
				if (next.getPrevious().getElement() != null) {
					return true;
				}
				return false;
			}
		}

		/**
		 * Returns index of next node
		 */
		@Override
		public int nextIndex() {
			if (next.getElement() == null) {
				return 0;
			}
			DLLNode<Character> temp = next;
			while (temp.getElement() != null) {
				temp = temp.getPrevious();
			}
			for (int i = -1; temp != null; i++) {
				if (temp == next) {
					if (pivot) {
						return i;
					}
					return ++i;
				}
				temp = temp.getNext();
			}
			return -1;
		}

		/**
		 * Returns to previous node in list
		 */
		@Override
		public Character previous() {
			if (next.getElement() == null) {
				throw new NoSuchElementException("Element does not exist");
			}
			if (fwd) {
				fwd = false;
				back = canRemove = pivot = returned = true;
				return next.getElement();
			} else {
				if (next.getPrevious().getElement() != null) {
					fwd = pivot = false;
					back = canRemove = returned = true;
					next = next.getPrevious();
					return next.getElement();
				} else {
					throw new NoSuchElementException("No such element");
				}
			}
		}

		/**
		 * Returns value of previous index
		 */
		@Override
		public int previousIndex() {
			return nextIndex() - 1;
		}

		/**
		 * Sets current node to a new value
		 */
		@Override
		public void set(Character c) {
			if (next.getElement() == null || !returned) {
				throw new IllegalStateException("Illegal state");
			}
			next.setElement(c);
		}
	}

}
