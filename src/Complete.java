
public class Complete {
	
	
	public String inPrePost(String preOrder, String inOrder)
	{
		BinaryTree recovery = new BinaryTree();
		recovery = this.recovery_subtree(inOrder, preOrder);
		recovery.postOrderPrint(recovery.root);
		
		return null;
	}
	
	public BinaryTree recovery_subtree(String sub_inOrder, String preOrder)
	{
		//System.out.println(sub_inOrder);
		if(sub_inOrder.length() == 0)
			return new BinaryTree();
		else
		{
			BinaryTree tmp = new BinaryTree();
			if((sub_inOrder.length() == 1))
				tmp.root = new Node(sub_inOrder);				
			else
			{
				int[] indexes = new int[sub_inOrder.length()];
				for(int i=0; i < sub_inOrder.length(); i++)
					indexes[i] = preOrder.indexOf(sub_inOrder.substring(i, i+1));
				
				int index = -1, less = Integer.MAX_VALUE;
				for(int i=0; i < indexes.length; i++)
				{
					if(indexes[i] < less) 
					{
						index = i; // letter who will be root
						less = indexes[i];
					}
				}
				
				tmp.root = new Node(sub_inOrder.substring(index, index+1));
				tmp.root.left = recovery_subtree(sub_inOrder.substring(0, index), preOrder).root;
				tmp.root.right = recovery_subtree(sub_inOrder.substring(index +1), preOrder).root;
			}
			
			return tmp;
		}	
	}
	
	public static void main(String[] args) {
		Complete com = new Complete();
		com.inPrePost("DBACEGF", "ABCDEFG");

	}

}
