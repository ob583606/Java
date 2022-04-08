import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;
	

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		resetGetLoops();
		resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		List<Entry<K, V>> hashin = table.get(index);
		Iterator<Entry<K, V>> iter = hashin.iterator();

		while (iter.hasNext()) {
			if (iter.next().getKey().equals(key)) {
				return true;
			}
		}
		return false; // so it compiles
	}

	public V get (K key) throws KeyNotFoundException {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		List <Entry<K,V>> hashin = table.get(index);
		Iterator<Entry<K, V>> iter = hashin.iterator();
		while (iter.hasNext()) {
			Entry<K,V> boobs = iter.next();
			if (boobs.getKey().equals(key)) {
				return boobs.getValue();
			}
		}

		throw new KeyNotFoundException();
	}

	public List<Entry<K,V> >	entryList() {
		List <Entry<K,V>> resultList = new LinkedList<Entry<K,V>>();
		Iterator<List <Entry<K, V>>> tit = table.iterator();
		while (tit.hasNext()) {
			Iterator<Entry<K, V>> lit = tit.next().iterator();
			while (lit.hasNext()) {
				resultList.add(lit.next());
			}
		}

		return resultList;
	}
	
	//ASHGF DFHB AHD IAUFH BVQHGWRG UISHCSD 

	public void put (K key, V value){
		int index = Math.abs(key.hashCode())%tableSize;
		Iterator<Entry<K, V>> iter = table.get(index).iterator();
		while (iter.hasNext()) {
			Entry<K, V> temp = iter.next();
			if (temp.getKey().equals(key)) {
				temp.setValue(value);
				return;
			}
		}
		Entry<K, V> gonads = new Entry(key, value);
		table.get(index).add(gonads);
		count++;
	}

	public int size() {
		return count;
	}

    public void clear() {
		for(int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}