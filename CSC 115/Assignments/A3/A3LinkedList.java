// Name:
// Student number: v00

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}

	public void addFront(String s) {
		A3Node n = new A3Node(s);
		if (head == null) {
			head = n;
			tail = n;
			n.setNext(null);
			n.setPrev(null);
		} else {
			head.setPrev(n);
			n.setNext(head);
			head = n;
			n.setPrev(null);
		}
		length++;
	}

	public void addBack(String s) {
		A3Node n = new A3Node(s);
		if (tail == null) {
			head = n;
			tail = n;
			n.setNext(null);
			n.setPrev(null);
		} else {
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
			n.setNext(null);

		}
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		if (head == null) {
			return;
		} else if (head.next == null) {
			head = null;
			tail = null;
			length--;
		} else {
			A3Node t = head;
			head = head.next;
			head.setPrev(null);
			t.setNext(null);
			length--;
		}
	}
	
	public void removeBack() {
		if (tail == null) {
			return;
		} else if (tail.prev == null) {
			head = null;
			tail = null;
			length--;
		} else {
			A3Node t = tail;
			tail = tail.prev;
			tail.setNext(null);
			t.setPrev(null);
			length--;
		}
	}
	
	
	public void rotate(int n) {
		if (length == 0) {
			return;
		}
		if (n%length == 0) {
			return;
		} else {
			for (int i = 0; i < n; i++) {
				tail.setNext(head);
				head.setPrev(tail);
				A3Node t = tail;
				tail = tail.prev;
				head = head.prev;
				tail.setNext(null);
				t.setPrev(null);
			}
		}
	}
	
	public void interleave(A3LinkedList other) {
		if (length == 1) {
			return;
		}
		A3Node cur = new A3Node("");
		A3Node inter = new A3Node("");
		for (int n = 0; n < (length-1); n++) {
			cur.setNext(head);
			cur.setPrev(other.head);
			
			for (int i = 0; i < n; i++) {
				cur.setNext(cur.getNext().getNext());
				cur.setPrev(cur.getPrev().getNext());
				
			}
			inter.setNext(cur.getNext().getNext());
			inter.setPrev(cur.getPrev().getNext());
			cur.getNext().setNext(cur.getPrev().getNext());
			cur.getPrev().setNext((inter.getNext()));
			cur.getPrev().getNext().setPrev(cur.getPrev());
			inter.getPrev().setPrev(cur.getNext());
			tail = inter.getPrev();
			other.tail = inter.getNext();
		}
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	