package RomanStack;

public class LinkedList {
	Node head;
	LinkedList(){
		head = null;
	}
	public void addFirst(String numeral, int element){
		Node newNode = new Node(numeral,element);
		newNode.next = head;
		head = newNode;
	}
	public void addLast(String numeral, int element){
		Node newNode = new Node(numeral,element);
		
	}
	public Node removeFirst(Node n){
		Node temp = head;
		head = head.next;
		return temp;
	}
	
}