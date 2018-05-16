
public class Node {
	int value;
	String letter;
	Node right, left; //pointers, only two because it's for a binary tree
	
	public Node () {} //constructor
	
	public Node(int value) //constructor
	{
		this.value = value;
	}
	
	public Node(String value) //constructor
	{
		this.letter = value;
	}
	
	public String toString()
	{
		return this.letter + " ";
	}
	
	public Node clone()
	{
		return new Node(this.value);
	}
}
