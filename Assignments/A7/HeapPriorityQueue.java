/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		// TODO: implement this
		
		storage = new Comparable[DEFAULT_SIZE];
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		// TODO: implement this
		
		storage = new Comparable[size];
		currentSize = 0; 
	}

	public void swap(int ind1, int ind2) {
    	Comparable swish = storage[ind2];
		storage[ind2] = storage[ind1];
		storage[ind1] = swish;
    }

	public boolean isLeaf(int ind) {
		if (ind*2+1 >= currentSize) {
			return true;
		}
		return false;
	}

	public int minChild(int ind) {
		if (ind*2+2 >= currentSize || storage[ind*2+2].compareTo(storage[ind*2+1]) >= 0) {
			return ind*2+1;
		}
		return ind*2+2;
	}

	public void insert (Comparable element) throws HeapFullException {
		if (isFull()) {
			throw new HeapFullException();
		}
		storage[currentSize] = element;
		currentSize++;	
		bubbleUp(currentSize-1);
    }
	
	public void bubbleUp(int index) {
		if (index < 1) {
			return;
		}
		if (storage[index].compareTo(storage[index/2]) < 0) {
			swap(index, index/2);
			bubbleUp(index/2);
		}
	}

	public Comparable removeMin() throws HeapEmptyException {
		if (isEmpty()) {
			throw new HeapEmptyException();
		}
		if (currentSize == 1) {
			Comparable swish = storage[0];
			storage[0] = null;
			currentSize--;
			return swish;
		}
		Comparable swish = storage[0];
		swap(0, currentSize-1);
		currentSize--;
		bubbleDown(0);
		return swish;
	}
	
	private void bubbleDown(int index) {
		if (currentSize < 1 || isLeaf(index)) {
			return;
		}
		int mind = minChild(index);
		if (storage[mind].compareTo(storage[index]) < 0) {
			swap(index, mind);
			bubbleDown(mind);
		}
	}

	public boolean isEmpty(){
		if (currentSize == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if (currentSize == storage.length) {
			return true;
		}
		return false;
	}
	
	public int size () {
		return currentSize;
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=1; i<=currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
