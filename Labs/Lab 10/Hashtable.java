public class Hashtable{
    
private static final int TABLE_SZ = 7; // a prime number

	Student[] table;
	int count;  // number of Students in the table

	public Hashtable() {
		table = new Student[TABLE_SZ];
		count = 0;
	}



	/* MethodName: insertCollisions
	 * Purpose: insert (or update entry) s in this Hashtable with no collision handling strategy
	 * Parameters: Student - s
	 * Throws:  TableFullException - if inserting a new key into a full table
	 *          CollisionException - if inserting a new key into table at index that is full
	 * Returns: nothing
	 */
	public void insertCollisions(Student s) throws TableFullException, CollisionException {
		int ind = s.hashCode();
		if (count == 0) {
			table[ind % TABLE_SZ] = s;
			count++;
			return;
		}
		if (table[ind % TABLE_SZ] != null) {
			if (table[ind % TABLE_SZ].getSID().equals(s.getSID())){
				table[ind % TABLE_SZ] = s;
				return;
			} else {
				if (count >= TABLE_SZ) {
					throw new TableFullException();
				}
				throw new CollisionException();
			}
		} else {
			table[ind % TABLE_SZ] = s;
			count++;
			return;
		}
		
	}


	/* MethodName: getCollisions
	 * Purpose: find Student with sid in this Hashtable with no collision handling and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	public int getCollisions(String sid) throws KeyNotFoundException {
		for (int i = 0; i < TABLE_SZ; i++) {
			if ((table[i] != null) && (table[i].getSID().equals(sid))){
				return table[i].getGrade();
			}
		}
		throw new KeyNotFoundException();
	}


	/* MethodName: insertLinearProbing
	 * Purpose: insert (or update entry) s in this Hashtable with Linear Probing to handle collisions
	 * Parameters: Student - s
	 * Throws: TableFullException  - if inserting a new key into a full table
	 * Returns: nothing
	 */
	public void insertLinearProbing(Student s) throws TableFullException {
		int ind = s.hashCode();
		if (count == 0) {
			table[ind % TABLE_SZ] = s;
			count++;
			return;
		}
		if (table[ind % TABLE_SZ] != null) {
			if (table[ind % TABLE_SZ].getSID().equals(s.getSID())){
				table[ind % TABLE_SZ] = s;
				return;
			} else if (count >= TABLE_SZ) {
				throw new TableFullException();
			} else {
				for (int i = ind%TABLE_SZ; i < TABLE_SZ+ind%TABLE_SZ; i++) {
					if (table[i % TABLE_SZ] == null) {
						table[i % TABLE_SZ] = s;
						count++;
						return;
					}
				}
			}
		} else {
			table[ind % TABLE_SZ] = s;
			count++;
			return;
		}
		
	}




	/* getLinearProbing
	 * Purpose: find Student with sid in this Hashtable that uses Linear Probing and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	public int getLinearProbing(String sid) throws KeyNotFoundException {
		for (int i = 0; i < TABLE_SZ; i++) {
			if ((table[i] != null) && (table[i].getSID().equals(sid))){
				return table[i].getGrade();
			}
		}
		throw new KeyNotFoundException();
	}

	/*
	 * Purpose: returns the number of elements in this Hashtable
	 * Parameters: none
	 * Returns: int - the number of elements
	 */
	public int size() {
		return count;
	}

	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this Hashtable separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		String s = "";

		for(int i=0; i<TABLE_SZ; i++) {
			if (table[i] != null) {
				s  += table[i] + "\n";
			}
		}
		
		return s;
	}
    

}
