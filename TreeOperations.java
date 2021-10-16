import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TreeOperations {
	
	class Node{
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	
	class QNode{
		Node node;
		int hd;
		
		QNode(Node node , int hd ){
			this.node = node;
			this.hd = hd;
		}
	}
	
	
	//topView of tree
	void topView(Node root) {
		
		Queue<QNode> q = new LinkedList<>();
		Map<Integer,Node> map = new TreeMap<>();
		
		q.add(new QNode(root,0));
		
		while(!q.isEmpty()) {
			
			QNode temp = q.poll();
			
			if(!map.containsKey(temp.hd)) {
				map.put(temp.hd, temp.node);
			}
			
			if(temp.node.left != null) q.add(new QNode(temp.node.left,temp.hd-1));
			if(temp.node.right != null) q.add(new QNode(temp.node.right,temp.hd+1));
			
		}
		
		for(Entry<Integer,Node> entry : map.entrySet()) {
			
			System.out.print(entry.getValue().data+" ");
		}
		
		
	}
	
	//left View
	void leftView(Node root) {
		
		Queue<QNode> q = new LinkedList<>();
		Map<Integer,Node> map = new TreeMap<>();
		
		q.add(new QNode(root,0));
		
		while(!q.isEmpty()) {
			
			QNode temp = q.poll();
			
			if(!map.containsKey(temp.hd)) {
				
				map.put(temp.hd, temp.node);
			}
			
			if(temp.node.left != null) q.add(new QNode(temp.node.left,temp.hd+1));
			if(temp.node.right != null) q.add(new QNode(temp.node.right,temp.hd+1));
			
		
		}
		
		for(Entry<Integer,Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().data+" ");
		}
	}
	
	
	//right View
	void rightView(Node root) {
		
		Queue<QNode> q = new LinkedList<>();
		Map<Integer,Node> map = new TreeMap<>();
		
		q.add(new QNode(root,0));
		
		while(!q.isEmpty()) {
			
			QNode temp = q.poll();
			
			if(!map.containsKey(temp.hd)) {
				
				map.put(temp.hd, temp.node);
			}
			
			if(temp.node.right != null) q.add(new QNode(temp.node.right,temp.hd+1));
			if(temp.node.left != null) q.add(new QNode(temp.node.left,temp.hd+1));
			
			
		
		}
		
		for(Entry<Integer,Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().data+" ");
		}
	}
	
	
	//bottom view 
	void bottomView(Node root) {
		
		Queue<QNode> q = new LinkedList<>();
		Map<Integer,Node> map = new TreeMap<>();
		
		q.add(new QNode(root,0));
		
		while(!q.isEmpty()) {
			
			QNode temp = q.poll(); 
			map.put(temp.hd, temp.node);
			
			if(temp.node.left != null) q.add(new QNode(temp.node.left,temp.hd -1));
			if(temp.node.right != null) q.add(new QNode(temp.node.right,temp.hd +1));
			
		}
		
		for(Entry<Integer,Node> entry : map.entrySet()) {
			
			System.out.print(entry.getValue().data +" ");
		}
		
	}
	
	
	// tree to double linked list
	Node head = null;
	Node pre = null;
	void treeToDll(Node root) {
		
		if(root == null) return;
		
		treeToDll(root.left);
		
		if(pre == null) {
			head = root;
		}else {
			root.left = pre;
			pre.right = root;
		}
		pre = root;
		
		treeToDll(root.right);
				
		
	}
	
	//iterative BFT
	void breadthFirstTraversal(Node head) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(head);
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			print(node.data);
			
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
			
		}
		
	}
	
	//recursive BFT
	void breadthFirstTraversalR(Node head) {
			
	}
	
	
	
	//Height of the Tree
	void heightOfTree(Node head) {
		int height= 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(head);
		
		while(!q.isEmpty()) {
			height++;
			int size = q.size();
			while(size > 0) {
				Node node = q.remove();
				
				if(node.left != null) {
					q.add(node.left);
				}
				
				if(node.right != null) {
					q.add(node.right);
				}
				
				--size;
			}
			
		}
		
		print(height);
	}
	
	
	
	//height of the tree recursive 
	int heightOfTreeR(Node head) {
		
		if(head == null) {
			return 0;
		}else {
			
			int l = heightOfTreeR(head.left);
			int r = heightOfTreeR(head.right);
			
			return Math.max(l, r)+1;
		}
		
	}
	
	public void print(int n) {
		System.out.print(n+" ");
	}
	
	public void print(String n) {
		System.out.println(n+" ");
	}
	
	
	
	
	Node createTree() {
		Node head = new Node(8);
		head.left = new Node(3);
		head.right = new Node(10);
		
		//left SubTree
		head.left.left = new Node(1);
		head.left.right = new Node(6);
		head.left.right.left = new Node(4);
		head.left.right.right = new Node(7);
		
		
		//right subtree 
		head.right.right = new Node(14);
		head.right.right.left = new Node(13);
		
		
		return head;
	}
	
	
	
	public static void main(String args[]) {
		
		TreeOperations obj = new TreeOperations();
		Node root = obj.createTree();
		
		// Breadth first Traversal
		obj.breadthFirstTraversal(root); 
		obj.print("\n"); 
		
		// height of the Tree
		int height = obj.heightOfTreeR(root); 
		obj.print(height);
		obj.print("\n"); 
		 
		
		//tree Views 
		obj.topView(root);
		obj.print("\n");
		obj.leftView(root );
		obj.print("\n");
		obj.rightView(root);
		obj.print("\n");
		obj.bottomView(root);
		obj.print("\n");

		
		// tree to dll
		obj.treeToDll(root);
		Node p = obj.head;
		while(p != null) {
			System.out.print(p.data+" ");
			p = p.right;
		}
		
		
		
	
	}

}
