package sparklicorn.datastructures;

import java.util.NoSuchElementException;

public class Stack<T> {
	
	private static class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public Stack() {
		//TODO
	}
	
	/**
	 * Adds the given data to the top of the stack.
	 * @param element The data element to add.
	 */
	public void push(T element) {
		//TODO
	}
	
	/**
	 * Pops the topmost data element off of the stack.
	 * @return The data element at the top of the stack.
	 * @throws NoSuchElementException if the stack is empty.
	 */
	public T pop() {
		//TODO
		
		return null;
	}
	
	/**
	 * Gets the size of the stack.
	 * @return The number of elements contained in the stack.
	 */
	public int size() {
		//TODO
		
		return 0;
	}
	
	/**
	 * Checks whether the stack is empty.
	 * @return True if the stack contains no elements; otherwise false.
	 */
	public boolean isEmpty() {
		//TODO
		
		return false;
	}
	
	/**
	 * Retrieves the topmost data element on the stack, but does not remove it.
	 * @return The top of the stack.
	 * @throws NoSuchElementException if the stack is empty.
	 */
	public T peek() {
		//TODO
		
		return null;
	}
	
	/**
	 * Clears all elements from this stack.
	 */
	public void clear() {
		
	}
	
	/**
	 * Checks whether the specified element exists in the stack.
	 * @param element The element to search for.
	 * @return True if the stack contains the given element; otherwise false.
	 */
	public boolean contains(T element) {
		return false;
	}
}
