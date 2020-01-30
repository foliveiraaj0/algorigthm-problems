package utils.data_structures;

public class Node {
	private int data;
	private Node next;

	public Node(int d) {
		data = d;
		next = null;
	}
	
	public static Node createNodes(int[] list) {
		Node head = null;
		Node current = null;
		for (int i = 0; i < list.length; i++) {
			if(head == null) {
				head = new Node(list[i]);
			}
			else if(current == null) {
				current = new Node(list[i]);
				head.next = current;
			}
 			else {
 				current.next = new Node(list[i]);
 				current = current.next;
 			}
		}
		return head;
	}
	
	// This function should delete node from linked list. The function
	// may assume that node exists in linked list and is not last node
	// node: reference to the node which is to be deleted
	public static void deleteNode(Node node) {
		if(node != null) {
			if(node.next != null) {
				node.data = node.next.data;
				node.next = node.next.next;
			}
		}
	}
	
	public static void print(Node head) {
		Node node = head;
		while(node != null) {
			System.out.print(String.format("%d ", node.data));
			node = node.next;
		}
		System.out.println();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
