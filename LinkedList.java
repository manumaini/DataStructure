
public class LinkedList {
	
	public static Node head;
	
	static class Node{
		
		public int data;
		public Node next;
		
		public Node(int data ) {
			this.data = data;
			
		}
		
		
	}
	
	public static void addAtStart(Node node) {
		
		node.next = head;
		head = node;
		
		Node p = head;
		
		while(p != null) {
			
			System.out.print(p.data+" ");
			p = p.next;
		}
	}
	
	public static void addAtEnd(Node node) {
		
		Node p = head;
		
		while(p.next != null) {
			p = p.next;
		}
		
		p.next = node;
		
		p = head;
		
		while(p != null) {
			System.out.print(p.data+" ");
			p = p.next;
		}
		
		
	}

	public static void addAfter(int key , Node node) {
		
		if(head.data == key) {
			
			node.next = head.next;
			head.next = node;
			return;
		}
		
		Node p = head;
		
		while(p != null && p.data != key) {
			
			p = p.next;
			
		}
		
		node.next = p.next;
		p.next = node;
		
		
		p = head;
		while(p != null) {
			System.out.print(p.data+" ");
			p = p.next;
		}
		
		
		return;
		
	}
	
	
	public static void main(String args[]) {
		
		
		
		
		head = new Node(1);
		
		Node second = new Node(2);
		Node third = new Node(3);
		
		head.next = second;
		
		second.next = third;
		
		Node p = head;
		
		while(p != null) {
			
			System.out.print(p.data+" ");
			p = p.next;
		}
		
		
		
		// to add at the beginning 
		System.out.print("\n");
		Node snode = new Node(0);
		addAtStart(snode);
		
		
		
		//to add at the end
		System.out.print("\n");
		Node enode =  new Node(4);
		addAtEnd(enode);
		
		
		//to add in the middle
		System.out.print("\n");
		Node mnode =  new Node(9);
		addAfter(3,mnode);
		
		
		
	}
	
	
}
