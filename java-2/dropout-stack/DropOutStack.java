package jsjf;

import java.util.Arrays;

import jsjf.Exception.EmptyCollectionException;

public class DropOutStack<T> extends ArrayStack<T> {
	
	//initialize two variable to keep track of first and last elements in the stack
	//initialize an array and a temporary array for the shifting of elements
	private int top, bottom;
	private T[] circularArray;
	private T[] arrayTemp;
	private static final int initial = 10;

    //intial drop-out-sack of size 10
	public DropOutStack() {
	        this(initial);
	 }

	 /**
     * Creates an empty stack using the specified capacity.
	 * @param initialCapacity the initial size of the array 
	 */
	 public DropOutStack(int initialCapacity) {
		    top = bottom = 0;
	        circularArray = (T[])(new Object[initialCapacity]);
	        arrayTemp = (T[]) (new Object[initialCapacity]);
     }

	 
	public void push(T element) {
		//if the stack is full, shifts all elements to the right 
		//stores new element being pushed into the first index of the array
		if (size() == circularArray.length){
			System.arraycopy(circularArray, 0, arrayTemp, 0, circularArray.length);
			for(int index=0; index < circularArray.length-1; index++){
				circularArray[index+1]= arrayTemp[index];
				circularArray[0]=element;
			}
			//sets top to the last element in the stack
			top = circularArray.length-1;
		//if the stack is not full, pushes elements in as normal, setting top to the last element	
		}else{
			for (int i=0; i<circularArray.length; i++){
	        	if(circularArray[i] == null){	
	        	    circularArray[i] = element;
	        	    top = i;
	        		break;
	        	}	
	        }
		 }
		 
	}	
	
	//this pop method removes the most recently added element in the stack
	//then shifts the array over to the right to clear room for next entry in the stack
	public T pop() {
		
		if (isEmpty())
	            throw new EmptyCollectionException("stack");

	        T result = circularArray[bottom];
	        circularArray[bottom] = null; 
	        for(int index=0; index < circularArray.length-1; index++){
				circularArray[index+1]= arrayTemp[index];
	        }

	        return result;
	}

	//returns the element in the last position of the stack
	public T peek() {
		
		if (isEmpty())
	            throw new EmptyCollectionException("stack");

	        return circularArray[circularArray.length-1];
	}
	
	// initializes the variable empty to false
	//if the array has no elements
	public boolean isEmpty() {
		
    	boolean empty = true;
    	for(int i=0; i < circularArray.length; i++){
    		if (circularArray[i] != null) {
    		empty = false;
    		break;
    		}
    	}
    	return empty;
    }
    
	//returns number of elements in the array
	public int size() {
		// for loop runs through the array
    	// if statement will count the current number of elements
		int counter = 0;
    	for(int i=0; i < circularArray.length; i++){
    		if (circularArray[i] != null){
    			counter++;
    		}
    	}	
    	return counter;
    }
	
	// simply converts the current array to a string and returns
	public String toString() {    
    	String array = Arrays.toString(circularArray);
    	return array;
    }

}

	
