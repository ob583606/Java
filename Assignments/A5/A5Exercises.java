public class A5Exercises {

	// PART 1

	/*
	 * Purpose: get a count of the number of elements in the array
	 *          with a value that is a multiple of x
	 * Parameters: int[] arr
	 * Returns: int - the number multiples of x
	 * Pre-condition: x > 0
	 * Post-condition - the array contents are unchanged
	 */
	public static int countMultiples(int[] arr, int x) {
		return cmRecursive(arr, x, 0);
	}

	public static int cmRecursive(int[] arr, int x, int pos) {
		if (pos > (arr.length-1)) {
			return 0;
		}
		if (arr[pos]%x == 0) {
			return cmRecursive(arr, x, pos+1) + 1;
		}
		return cmRecursive(arr, x, pos+1);
	}
		
	/*
	 * Purpose: double all values in the given array
	 * Parameters: int[] array - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] array) {
		daRecursive(array, 0);
	}

	public static void daRecursive (int[]array, int pos) {
		if (pos > (array.length-1)) {
			return;
		}
		array[pos] *= 2;
		daRecursive(array, pos+1);
	}
	
	/*
	 * Purpose: get the minimum value found in the array
	 * Parameters: int[] array - the array to search
	 * Returns: int - minimum value found in the array
	 *                or -1 if the array is empty
	 * Post-condition - the array contents are unchanged
	 */
	public static int getMinimum(int[] array) {
		if (array.length == 0) {
			return -1;
		}
		return gmRecursive(array, 1, array[0]);
	}
	
	public static int gmRecursive(int[]array, int pos, int min) {
		if (pos < (array.length)) {
			if (array[pos] < min) {
				min = array[pos];
			}
			return gmRecursive(array, pos+1, min);
		}
		return min;
	}
	
	



	// PART II

	/*
	 * Purpose: get the total number of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of books
	 * Post-condition: s is not modified
	 */
	public static int totalBooks(Stack<Book> s) {
		A5Stack<Book> f = new A5Stack<Book>();
		int count = tbRecursive(s, f);
		putBooksBack(s, f);
		return count;
	}

	public static int tbRecursive(Stack<Book> s, Stack<Book>f) {
		if (s.top()==null) {
			return 0;
		}
		f.push(s.pop());
		return tbRecursive(s, f) + 1;
	}

	public static void putBooksBack(Stack<Book> s, Stack<Book>f) {
		if (f.top()== null) {
			return;
		}
		s.push(f.pop());
		putBooksBack(s, f);
	}
	/*
	 * Purpose: get the total number of pages of all 
	 *          books in the stack
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of pages
	 * Post-condition: s is not modified
	 */
	public static int totalPages(Stack<Book> s) {
		A5Stack<Book> f = new A5Stack<Book>();
		int count = tpRecursive(s, f);
		putBooksBack(s, f);
		return count;
	}

	public static int tpRecursive(Stack<Book> s, Stack<Book> f) {
		if (s.top()==null) {
			return 0;
		}
		f.push(s.pop());
		return f.top().getPages() + tpRecursive(s, f);
	}
	
	/*
	 * Purpose: get the average number of pages of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: double - the average number of pages
	 *                   0.0 if there are no books in s
	 * Post-condition: s is not modified
	 */
	public static double averagePages(Stack<Book> s) {
		// You don't need to change this, if you have
		// completed the previous two exercises
		// correctly, it should pass all the tests
		if (s.isEmpty()) {
			return 0.0;
		} else {
			double sum = totalPages(s);
			int count = totalBooks(s);
			return sum/count;
		}
	}

	/*
	 * Purpose: determine whether toFind is contained in s
	 * Parameters: Stack<Book> s - the stack of books
	 *             Book toFind - the book to search for
	 * Returns: boolean - true if s contains toFind, false otherwise
	 * Post-condition: s is not modified
	 */
	public static boolean containsBook(Stack<Book> s, Book toFind) {
		if (s.top()==null) {
			return false;
		}
		A5Stack<Book> f = new A5Stack<Book>();
		Boolean stat = cbRecursive(s, toFind, f);
		putBooksBack(s, f);
		return stat;
	}

	public static boolean cbRecursive(Stack<Book> s, Book toFind, Stack<Book> f) {
		if (s.top() == null) {
			return false;
		}
		f.push(s.pop());
		if (f.top().equals(toFind)) {
			return true;
		}
		return cbRecursive(s, toFind, f);
	}
	/*
	 * Purpose: determine the books in s are stacked correctly
	 *          (ie. there is never a book stacked on top of 
	 *               another book with fewer pages)
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: boolean - true if books in s are stacked correctly
	 * Post-condition: s is not modified
	 */
	public static boolean stackedCorrectly(Stack<Book> s) {
		if (s.top()==null) {
			return true;
		}
		A5Stack<Book> f = new A5Stack<Book>();
		f.push(s.pop());
		boolean stat = scRecursive(s, f, f.top().getPages());
		putBooksBack(s, f);
		return stat;
	}

	public static boolean scRecursive(Stack<Book> s, Stack<Book> f, int size) {
		if (s.top() == null) {
			return true;
		}
		f.push(s.pop());
		if (f.top().getPages() < size) {
			return false;
		}
		return scRecursive(s, f, f.top().getPages());
	}
}