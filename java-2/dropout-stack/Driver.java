package jsjf;

public class Driver  {
	
	public static void main(String[] args) {
		
		// creates a stack of integers
		// demonstrates use of checkEmpty,push,pop, & toString methods
		ArrayStack<Integer> stack1 = new ArrayStack<Integer>(10);
		checkEmpty(stack1);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		System.out.println(stack1.toString());
		checkEmpty(stack1);
		System.out.println(stack1.peek());
		stack1.pop();
		System.out.println(stack1.toString());
		System.out.println();
		
		// creates a stack of strings
		// demonstrates use of checkEmpty,push,pop, & toString methods
		ArrayStack<String> stack2 = new ArrayStack<String>(10);
		checkEmpty(stack2);
		stack2.push("hello");
		stack2.push("there");
		System.out.println(stack2.toString());
		checkEmpty(stack2);
		System.out.println(stack2.peek());
		stack2.pop();
		System.out.println(stack2.toString());
		System.out.println();
		
		// creates a circularArray object of integers
		// demonstrates use of methods
		// demonstrates results of adding more elements than the capacity 
		DropOutStack<Integer> circular1 = new DropOutStack<Integer>(10);
		checkEmpty(circular1);
		circular1.push(1);
		circular1.push(2);
		circular1.push(3);
		circular1.push(4);
		circular1.push(5);
		circular1.push(6);
		circular1.push(7);
		circular1.push(8);
		circular1.push(9);
		circular1.push(10);
		System.out.println(circular1.toString());
		// these two elements will demonstrate effect of a circular array
		circular1.push(99);
		circular1.push(98);
		System.out.println(circular1.toString());
		//demonstrate pop & peek methods 
		circular1.pop();
		System.out.println(circular1.toString());
		circular1.push(60);
		System.out.println(circular1.toString());
		System.out.println(circular1.peek());
	}
	
	// uses isEmpty() from ArrayStack.java to print the status 
	public static <T> void checkEmpty( ArrayStack<T> stack){
		
		// sets check to the status returned from isEmpty()
		boolean check = stack.isEmpty();
		// uses this return value to  print status of the stack
		if(check == false){
			System.out.println("The stack is not empty");
		}else{
			System.out.println("The stack is empty");
		}
	    
	}

}