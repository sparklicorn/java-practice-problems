package sparklicorn.datastructures;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	
	private class Node {
		T data;
		Node next;
		
		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public LinkedList() {
		//TODO
	}
	
	/**
	 * Adds the given element to the end of this list.
	 * @param element The element to add.
	 * @return True if the element was successfully added; otherwise false.
	 */
	public boolean add(T element) {
		//TODO
		
		return false;
	}
	
	/**
	 * Removes the element at the beginning of this list.
	 * @return The element at the beginning of this list.
	 * @throws NoSuchElementException if the list is empty.
	 */
	public T remove() {
		//TODO
		
		return null;
	}
	
	/**
	 * Checks whether this list is empty.
	 * @return True if this list is empty; otherwise false.
	 */
	public boolean isEmpty() {
		//TODO
		
		return false;
	}
	
	/**
	 * Gets the size of this list.
	 * @return The number of elements contained in this list.
	 */
	public int size() {
		//TODO
		
		return 0;
	}
	
	/**
	 * Clears all elements from this list.
	 */
	public void clear() {
		//TODO
	}
	
	/**
	 * Retrieves the element in this list at the given position.
	 * @param index The position within the list. Indices start at 0.
	 * @return The element in the list at the given position.
	 * @throws IndexOutOfBoundsException if the index is greater than
	 * or equal to the size of the list.
	 * @throws NoSuchElementException if the list is empty.
	 */
	public T get(int index) {
		//TODO
		
		return null;
	}
	
	/**
	 * Searches for and removes the first occurrence of the specified element
	 * from this list.
	 * @param element The element to remove.
	 * @return True if the element was successfully removed; otherwise false.
	 */
	public boolean remove(T element) {
		//TODO
		
		return false;
	}
	
	/**
	 * Checks whether the specified element exists in this list.
	 * @param element The element to search for.
	 * @return True if the list contains the given element; otherwise false.
	 */
	public boolean contains(T element) {
		//TODO
		
		return false;
	}
}
