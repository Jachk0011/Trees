
public class BinaryTree {

	Node root = null;
	
	public BinaryTree() {}
	
	
	public void preOrderPrint(Node n) 
	{
		if(n != null)
		{
			System.out.println(n.toString());
			preOrderPrint(n.left);
			preOrderPrint(n.right);
		}
	}
	
	public void postOrderPrint(Node n) 
	{
		if(n != null)
		{			
			postOrderPrint(n.left);
			postOrderPrint(n.right);
			System.out.println(n.toString());
		}
	}
	
	public void inOrderPrint(Node n) 
	{
		if(n != null)
		{			
			inOrderPrint(n.left);
			System.out.println(n.toString());
			inOrderPrint(n.right);			
		}
	}
	
	public int offSpring(Node n)//for calculate # descendant for each node, as this is a binary tree the maximum is 2
	{
		if(n.left != null)
		{
			if(n.right != null)
				return 2;
			else 
				return 1;
		}	
		else
		{
			if(n.right != null)
				return 1;
			else
				return 0;
		}
			
		
		/*return (n.left != null) ? 
				(n.right != null ? 2 : 1) : 
					(n.right != null ? 1 : 0);*/ 
	}
	
	public void insert(int value) 
	{
		Node node = new Node(value);
		if(this.root == null)
			this.root = node;
		else
		{
			Node tmp = this.root;
			Node father = null;
			boolean left = false;
			
			while(tmp != null)
			{
				father = tmp;
				if(value < tmp.value) //we assume doesn't exist repeat values
				{
					tmp = tmp.left;
					left = true; // we need to know which was the movement
				}
				else
				{
					tmp = tmp.right;
					left = false;
				}
			}
			
			tmp = node; //here is empty to add the new node
			
			if(left)
				father.left = tmp; //link a father with the new one node
			else
				father.right = tmp;//link a father with the new one node		
		}
	}
	
	
	
	public void delete(int value)
	{
		Node tmp = this.root;
		Node father = this.root;
		boolean left = false;
		
		while(tmp != null)
		{			
			if(tmp.value == value)
				break;
			else
			{
				
				father = tmp;
				if(value < tmp.value)
				{
					tmp = tmp.left;
					left = true;
				}
				else
				{
					tmp = tmp.right;
					left = false;
				}					
			}
		}
		
		if(tmp != null)
		{
			int counter = this.offSpring(tmp);
			
			if(counter == 0)
				if(left)
					father.left = null;
				else
					father.right = null;
			else
			{
				if(counter == 1)
				{
					if(tmp.left != null)
					{
						if(left)
							father.left = tmp.left;
						else
							father.right = tmp.left;
					}
					else
					{
						if(left)
							father.left = tmp.right;
						else
							father.right = tmp.right;
					}
						
				}
				else // the Node has 2 children, counter >1
				{
					
					Node less = tmp.right;
					Node lessFather = less;
					while(less.left != null)
					{
						lessFather = less;
						less = less.left;
					}
					
					if(lessFather.equals(less))//correction of the code
					{
						less.left = tmp.left;							
					}
					else
					{
						if(less.right != null)
							lessFather.left = less.right;
						
						less.right = tmp.right;
						less.left = tmp.right;	
					}
							
					
					if(left)
						father.left = less;
					else
						father.right = less;
					
						
					/* trying by my own
					Node newFather = tmp.right; //choosing the path of maximum values
					Node fatherPrime = newFather; // we need it for save right children of new father candidate
					while(newFather.left != null)
					{
						fatherPrime = newFather;
						newFather = newFather.left;
					}
						
					if(this.offSpring(newFather) == 1) // never mind if it's zero, and suppose that 2 is impossible otherwise it's not the less of the maximum
						fatherPrime.left = newFather.right; // saving right son of newFather
						
					newFather.left = tmp.left; //taking the old left links to new father
					newFather.right = tmp.right; //taking the old right links to new father
					
					if(left)
						father.left = newFather;
					else
						father.right = newFather;*/
					
				}
			}
		}	
		
		
		
	
	}
	
	public Node search(int value)
	{
		Node tmp = this.root;
		
		while(tmp != null)
		{
			if(tmp.value == value)
				return tmp;
			else
				if(value < tmp.value)
					tmp = tmp.left;
				else
					tmp = tmp.right;
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(52);		
		bt.insert(18);
		bt.insert(74);
		bt.insert(60);
		bt.insert(87);		
		bt.insert(83);
		bt.insert(100);
		bt.insert(85);
		
		
		//System.out.println("PRE ORDER: ");
		//bt.preOrderPrint(bt.root);
		//System.out.println("POST ORDER: ");
		//bt.postOrderPrint(bt.root);
		//System.out.println("IN ORDER: ");
		bt.postOrderPrint(bt.root);
		
		
		bt.delete(74);
		bt.delete(87);
		
		System.out.println();
		bt.postOrderPrint(bt.root);

	}

}
