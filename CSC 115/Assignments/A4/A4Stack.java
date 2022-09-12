public class A4Stack<T> implements Stack<T> {
	private A4Node<T> head;

	public A4Stack() {
		head = null;
	}
	
	/*
	 * Purpose: insert an item onto the top of the stack
	 * Parameters: T value - the value to insert 
	 * Returns: void - Nothing
	 */
	public void push(T value) {
		A4Node<T> newNode = new A4Node<T>(value);
		
		if (head == null) {
			head = newNode;
			newNode.setNext(null);
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	/*
	 * Purpose: removes and returns the top item from the stack
	 * Parameters: None
	 * Returns: T - the data value of the element removed
	 *              or null if the stack is empty
	 */
	public T pop() {
		if (head == null) {
			return null;
		} else {
			A4Node<T> temp = head;
			head = head.next;
			return temp.getData();
		}
	};
	
	/*
	 * Purpose: determines whether the stack is empty
	 * Parameters: None
	 * Returns: boolean - true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	};
	
	/*
	 * Purpose: get the top item on the stack
	 * Parameters: None
	 * Returns: T - the data value of the top element
	 *              or null if the stack is empty
	 */
	public T top() {
		if (head == null) {
			return null;
		} else {
			return head.getData();
		}
	};
	
	/*
	 * Purpose: removes all elements from the stack
	 * Parameters: None
	 * Returns: void - nothing
	 */
	public void popAll() {
		head = null;
	}
}