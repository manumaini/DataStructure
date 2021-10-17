
public class BST {
	
	class Node {
		
		public int key;
		public Node left;
		public Node right;
		
		
		Node(int key){
			this.key = key;
		}
		
		Node(){
			
		}
	}
	
	void SearchBst(int key , Node head) {
		
		if(head != null) {
			if(head.key == key) {
				System.out.println("key found in the tree");
				return;
			}else if(key < head.key) {
				SearchBst(key,head.left);
			}else if(key > head.key) {
				SearchBst(key,head.right);
			}	
		}else {
			System.out.println("key not found in the tree");
		}
		
		
		return;
	}
	
	int getSuccessor(Node head) {
		
		Node node = head;
		while(node.left != null) {
			node = node.left;
		}
		return node.key;
	}
	
	void DeleteNode(int key , Node head) {
		
		if(head != null) {
			if(head.key == key) {
				
				if(head.right == null && head.left == null) {
					head.key = 0;
					head = null;
				}else if(head.right == null || head.left == null) {
					int n =0;
					if(head.left == null) {
						n = head.right.key;
						DeleteNode(n,head);
						head.key = n;
						//DeleteNode(head.right.key,head);
					}else {
						n = head.left.key;
						System.out.println("checking log "+ n+"  " +head.key);
						DeleteNode(n,head);
						head.key = n;
						
					}
					
				}else if(head.left != null && head.right != null) {
					System.out.println("logging "+ head.key);
					int rValue = getSuccessor(head.right);
					
					head.key = rValue;
					
					DeleteNode(rValue,head.right);
				}
			}else if (key < head.key) {
				DeleteNode(key,head.left);
			}else if(key > head.key) {
				DeleteNode(key,head.right);
			}	
		}else {
			System.out.print("no such key found");
			
		}
		
		return;
		
	}
	
	void InOrderTraversal(Node head) {
		
		if(head == null ) {
			return;
		}
		
		InOrderTraversal(head.left);
		System.out.println(head.key);
		InOrderTraversal(head.right);
		
	}
	
	Node InsertNode(int key , Node head) {
		
		
		if(head != null) {
			if(key < head.key) {
				head.left = InsertNode(key,head.left);
			}
			if(key > head.key) {
				head.right = InsertNode(key,head.right);
			}
		}else {
			return new Node(key);
		}
		
		return head;
	}
	
	
	Node arraytoBst(int[] array) {
		Node head = new Node(array[0]);
		
		for(int i = 1 ; i< array.length ; i++) {
			InsertNode(array[i],head);
		}
		
		return head;
	}
	
	
	Node createBST() {
		return null ;
	}
	
	
	public static void main(String args[]) {
		int[] array = {14,5,7,8,3,16,1,48,52,12,17};
		BST obj = new BST();
		Node head = obj.arraytoBst(array);
		obj.InOrderTraversal(head);
		obj.SearchBst(99, head);
		
		obj.DeleteNode(16, head);
		obj.InOrderTraversal(head);
		
		
	}
	

}
