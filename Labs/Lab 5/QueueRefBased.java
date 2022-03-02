public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
	}

	public int size() {
		QueueNode cur = front;
		int count = 0;
		while (cur != null) {
			cur = cur.next;
			count ++;
		}
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void enqueue (int value) {
		QueueNode n = new QueueNode(value);
		if (size() == 0) {
			front = n;
			back = n;
		}
		else {
			back.next = n;
			back = n;
		}
	}

	public int dequeue() {
		int data = -1;
		if (size() != 0) {
			data = front.data;
			front = front.next;
		}
		return data;
	}

	public int peek()  {
		return back.data;
	}

	public void makeEmpty() {
		front = null;
		back = null;
	}
}