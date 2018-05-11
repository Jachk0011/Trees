
public class Node {
	int value;
	Node right, left; //pointers, only two because it's for a binary tree
	
	public Node () {} //constructor
	
	public Node(int value) //constructor
	{
		this.value = value;
	}
	
	public String toString()
	{
		return "Value: " + this.value;
	}
	
	public Node clone()
	{
		return new Node(this.value);
	}
}
