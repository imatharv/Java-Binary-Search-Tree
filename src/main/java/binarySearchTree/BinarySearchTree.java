package binarySearchTree;

public class BinarySearchTree {
	Node root = null;
	
	public void add(int key) {
		root = addRecurrsivly(root, key);
	}
	
	public  Node addRecurrsivly(Node root, int key) {		   
		if(root == null) {        
			root = new Node(key);
			return root;
		}
		if(key < root.key)
			root.left = addRecurrsivly(root.left, key);
		else if(key > root.key)
			root.right =addRecurrsivly(root.right, key);
		
		return root;
	}	 
	 
	public  void inorder() {	 
		inorderAt(root);
	}
	 
	public void inorderAt(Node root)  {
		if(root != null) {
			inorderAt(root.left);
			System.out.print(root.key + " ");
			inorderAt(root.right);
		}
	}

	public int size() {
		return sizeOfNode(root);
	}
	 
	public int sizeOfNode(Node root) {
		if(root == null)
			return 0;
		else
			return(sizeOfNode(root.left) + 1 + sizeOfNode(root.right));
	}
	 
	static boolean checkIfExist(Node node, int key)
	{
		if(node == null)
			return false;
		if(node.key == key)
			return true;
	     
		// Look for it in the left subtree
		boolean res1 = checkIfExist(node.left, key);
		   
		// node found, no need to look further
		if(res1) return true;
		
		// If the node is not found in left subtree, then look for it in the right subtree
		boolean res2 = checkIfExist(node.right, key);
		 
		return res2;
	}
 
	public void search(int key) {     
		if(checkIfExist(root, key))
			System.out.println(key +" is Present");
		else
			System.out.println(key + " is not Present"); 
	}
	
	public static void main(String[] args) {
		BinarySearchTree object = new BinarySearchTree();
		
		object.add(56);
		object.add(30);
		object.add(70);
		object.add(56);
		object.add(30);
		object.add(22);
		object.add(11);
		object.add(3);
		object.add(16);
		object.add(40);
		object.add(70);
		object.add(60);
		object.add(65);
		object.add(63);
		object.add(67);
		object.add(95);
		
		object.inorder();
		
		System.out.println();
		System.out.println("The size of binary tree is :: "+ object.size());
		 
		object.search(63);
	}
}

