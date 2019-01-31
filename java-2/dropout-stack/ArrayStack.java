package jsjf;

import jsjf.Exception.*;
import java.util.Arrays;

/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 * 
 */
public class ArrayStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;

    private int top;  
    private T[] stack;
  
    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity.
     * @param initialCapacity the initial size of the array 
     */
    public ArrayStack(int initialCapacity)
    {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * @param element generic element to be pushed onto stack
     */
    // use for loop to identify first null element in the stack
    // set first null to the desired pushed element 
    // set the top to point at the actual top of the stack
    public void push(T element)
    {
        if (size() == stack.length) 
            expandCapacity();
        
        for (int i=0; i<stack.length; i++){
        	if(stack[i] == null){	
        	    stack[i] = element;
        	    top = i;
        		break;
        	}
        }
        
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);   
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty 
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        
        T result = stack[top];
        stack[top] = null; 

        return result;
    }
   
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack[top];
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if this stack is empty
     */
    public boolean isEmpty()
    {
        // initializes the variable empty to false
    	// if the stack has no elements
    	boolean empty = true;
    	for(int i=0; i < stack.length; i++){
    		if (stack[i] != null) {
    		empty = false;
    		break;
    		}
    	}
    	return empty;
    }
 
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
    	// for loop runs through the array
    	// if statement will count the current number of elements
    	int counter = 0;
    	for(int i=0; i < stack.length; i++){
    		if (stack[i] != null){
    			counter++;
    		}
    	}	
    	return counter;
    }

    /**
     * Returns a string representation of this stack. 
     * @return a string representation of the stack
     */
    public String toString()
    {
        // simply converts the current array to a string and returns
    	String array = Arrays.toString(stack);
    	return array;
    }
}

   