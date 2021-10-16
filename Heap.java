import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Heap {
	
	public void heapyfy(ArrayList<Integer> array, int i) {
		
		int size = array.size();
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		
		if(left < size && array.get(left) > array.get(largest)) {
			largest = left;
		}
		
		if(right< size && array.get(right) > array.get(largest)) {
			largest = right;
		}
		
		
		if(largest != i ) {
			int temp = array.get(i);
			array.set(i,array.get(largest));
			array.set(largest, temp);
			
			heapyfy(array,largest);
		}
		
	}
	
	public void insertNode(ArrayList<Integer> array , int newNum) {
		
		if(array.size() == 0) {
			array.add(newNum);
		}else {
			array.add(newNum);
			for(int i = (array.size()/2) -1 ; i>=0 ; i--) {
				heapyfy(array,i);
			}
		}
		
	}
	
	public void deleteNode(ArrayList<Integer> array , int num) {
		
		int i=0;
		int size = array.size();
		for(i = 0 ; i < size ; i ++) {
			if(array.get(i) == num ) {
				break;
			}
		}
		
		int temp = array.get(i);
		array.set(i, array.get(size-1));
		array.set(size-1, temp);
		
		array.remove(size-1);
		
		for(int j= size/2-1 ; j >= 0 ; j--) {
			heapyfy(array,i);
		}
		
	}
	
	public void printArray(ArrayList<Integer> array) {
		
		for(int n : array) {
			System.out.print(n+" ");
		}
	}
	
	
	public static void main(String args[]) {
		
		ArrayList<Integer> array = new ArrayList<Integer>();
	    
		Heap h = new Heap();
		Queue<Integer> q = new LinkedList<Integer>();
		
		h.insertNode(array, 3);
	    h.insertNode(array, 4);
	    h.insertNode(array, 9);
	    h.insertNode(array, 5);
	    h.insertNode(array, 2);
	    
	    h.printArray(array);
	    
	    h.deleteNode(array,9);
	    
	    h.printArray(array);
	    
	    
	    
	}
	

}
