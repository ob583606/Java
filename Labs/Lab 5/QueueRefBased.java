public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
	}

	public int size() {
		int count = 0;		
		
		while (front.next != null) {
			count++;
			front = front.next;
		}

		return count;			
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void enqueue (int value) {
		QueueNode nq = new QueueNode(value);

		if (front == null) {
			front = nq;
			back = nq;
		} else {
			nq.setNext(back.next);
			back = nq;
		}
	}

	public int dequeue() {
		if (front == null) {
			return 0;
		} else if (this.size() == 1) {
			QueueNode temp = new QueueNode(0);
			temp.setNext(front);
			front = null;
			return temp.getNext().getValue();
		} else {
			QueueNode temp = new QueueNode(0);
			temp.setNext(front);
			front = front.next.getNext();
			return temp.getValue();
		}
	}

	public int peek()  {
		return -1; // so it compiles
	}

	public void makeEmpty() {

	}
}
