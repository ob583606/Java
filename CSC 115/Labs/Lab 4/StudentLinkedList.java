public class StudentLinkedList implements StudentList {

	StudentNode head;
	int count;

	public StudentLinkedList() {
		head = null;
		count = 0;
	}

	public void add(Student s) {
		StudentNode newnode = new StudentNode(s);
		if (head == null) {
			head = newnode;
		} else {
			StudentNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newnode;
		}
		count++;


	}

	public int size() {
		return count;
	}

	public void removeFront() {
		if (head == null) {
			return;
		}
		StudentNode begone = head;
		head = head.next;
		begone.next = null;
		count--;
	}

	public boolean contains(Student s) {
		StudentNode cur = head;
		while (cur != null) {
			if (cur.getData().getSID().equals(s.getSID())) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		// DO NOT CHANGE THIS METHOD - it is correct
		// Changing it will result in your code getting
		// a score of 0 from the autograder for this lab
		
		String s = "";
		StudentNode tmp = head;

		while(tmp != null) {
			s  += tmp.getData() + "\n";
			tmp = tmp.next;
		}

		return s;
	}
}
