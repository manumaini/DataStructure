
public class Queue {
	
	
	int[] arr;
	int front , rear;
	int SIZE; 
	
	Queue(int SIZE){
		
		this.SIZE = SIZE;
		arr= new int[SIZE];
		front = rear = -1;
	}
	
	
	//add element
	public void enqueue(int data) {
		
		if(isFull()) {
			System.out.print("queue is full");
			return;
		}else {
			
			if(front == -1) front = 0;
			rear = (rear +1) % SIZE;
			arr[rear] = data;
			
		}
		
	}
	
	public int dequeue() {
		
		int element;
		
		if(isEmpty()) {
			System.out.print("queue is empty");
			return -1;
			
		}else {
			
			element = arr[front];
			
			if(front == rear) {
				front = -1 ;
				rear = -1;
			}else {
				front = (front +1) % SIZE;
			}
			
			
			return element;
		}
		
	}
	
	public void printQueue() {
		
		for(int i = front ; i != rear ; i = (i+1) % SIZE ) {
			
			System.out.print(arr[i]+" ");
			
		}
		
	}
	
	
	
	public boolean isFull() {
		
		if(front == 0 && rear == SIZE-1) return true;
		if(front == rear + 1 ) return true;
		
		return false;
	}
	
	
	public boolean isEmpty() {
		
		if(front == -1) return true;
		
		return false;
	}
	
	
	
	public static void main(String args[]) {
		
		Queue q = new Queue(5);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		q.dequeue();
		q.enqueue(5);
		q.enqueue(5);
		q.enqueue(5);
		
		q.printQueue();
		
		
		
	}

}
