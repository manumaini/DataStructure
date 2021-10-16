
public class Stack {

	int[] arr ;
	int capacity;
	int top;
	
	Stack(int size){
		
		arr= new int[size];
		capacity = size;
		top = -1;
		
	}
	
	public void push(int data) {
		
		if(isFull()) {
			System.out.print("stack overflow");
			return;
		}
		
		arr[++top] = data;
		
	}
	
	public int pop() {
		
		if(isEmpty()) {
			System.out.print("stack underflow");
			return -1;
		}
		
		int data = arr[top--];
		return data;
		
		
	}
	
	public void printStack() {
		
		for(int i = 0 ; i <= top ; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}
	
	
	public boolean isFull() {
		return top == capacity-1;
	}
	
	public boolean isEmpty() {
		return top == -1 ;
	}
	
	
	
	public static void main(String args[]) {
			
		Stack stack = new Stack(5);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.printStack();
		
		int data = stack.pop();
		
		if(data == 3) {
			System.out.print("\nwoohoo we have done it\n");
		}
		
		stack.printStack();
		
	}
}
