package assignment3;
import java.util.LinkedList;

public class StackListBased<E> {
	
	private LinkedList<E> items;
    
	/**
     * Creates an empty stack.
     */	
	StackListBased(){
        items = new LinkedList<>();
    }
	
    /**
     * Creates an empty stack.
     */
    public void createStack() {
        items = new LinkedList<E>();
    }
    
    /**
     * Removes all items from the stack.
     */
    public void popAll() {
        items.clear();
    }
    
    /**
     * Determines whether a stack is empty.
     * 
     * @return true if empty
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Adds newItem to the top of the stack.
     * 
     * @param newItem is a new item
     */
    public void push(E newItem) {
        items.push(newItem);
    }
    /**
     * Removes element at the top of the stack.
     * 
     * @return element removed from the top of the stack
     */
    public E pop() {
        return items.pop(); 
    }
    /**
     * Retrieves element at the top of the stack 
     * 
     * @return element from the top of the stack
     */
    public E peek() {
        return items.peek();
    }
	
}