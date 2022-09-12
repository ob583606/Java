public class JacomA5Exercises {

	// PART 1

	/*
	 * Purpose: get a count of the number of elements in the array
	 * Parameters: int[] arr
	 * Returns: int - the number of elements
	 * Post-condition - the array contents are unchanged
	 */
	public static int countMultiples(int[] arr, int x) {
		return countMultiplesRecursive(arr, x, arr.length - 1);
	}

	public static int countMultiplesRecursive(int[] arr, int multiple, int index) {
		if (index < 0) {
			return 0;
		}
		else if (arr[index] % multiple == 0) {
			return 1 + countMultiplesRecursive(arr, multiple, index - 1);
		}
		else {
			return countMultiplesRecursive(arr, multiple, index - 1);
		}
	}
		
	/*
	 * Purpose: double all values in the given array
	 * Parameters: int[] array - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] array) {
		doubleAllRecursive(array, array.length - 1);
	}

	public static void doubleAllRecursive(int[] array, int index) {
		if (index < 0) {
			return;
		}
		else {
			array[index] *= 2;
			doubleAllRecursive(array, index - 1);
		}
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
		else {
			return getMinimumRecursive(array, array[0], array.length - 1);
		}
	}

	public static int getMinimumRecursive(int[] array, int min, int index) {
		if (index < 0) {
			return min;
		}
		else if (array[index] < min) {
			return getMinimumRecursive(array, array[index], index - 1);
		}
		else {
			return getMinimumRecursive(array, min, index - 1);
		}
	}


	// PART II

	/*
	 * Purpose: get the total number of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of books
	 * Post-condition: s is not modified
	 */
	public static int totalBooks(Stack<Book> s) {
		A5Stack<Book> temp = new A5Stack<Book>();
		int count = countTotalBooks(s, temp);
		stackBooks(s, temp);
		return count;
	}

	public static int countTotalBooks(Stack<Book> s, Stack<Book> temp) {
		if (s.isEmpty()) {
			return 0;
		}
		else {
			temp.push(s.pop());
			return 1 + countTotalBooks(s, temp);
		}
	}

	public static void stackBooks(Stack<Book> s, Stack<Book> temp) {
		if (temp.isEmpty()) {
			return;
		}
		else {
			s.push(temp.pop());
			stackBooks(s, temp);
		}
	}

	/*
	 * Purpose: get the total number of pages of all 
	 *          books in the stack
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of pages
	 * Post-condition: s is not modified
	 */
	public static int totalPages(Stack<Book> s) {
		A5Stack<Book> temp = new A5Stack<Book>();
		int count = countPages(s, temp);
		stackBooks(s, temp);
		return count;
	}

	public static int countPages(Stack<Book> s, Stack<Book> temp) {
		if (s.isEmpty()) {
			return 0;
		}
		else {
			int pages = s.top().getPages();
			temp.push(s.pop());
			return pages + countPages(s, temp);
		}
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
		A5Stack<Book> temp = new A5Stack<Book>();
		boolean result = findBook(s, temp, toFind);
		stackBooks(s, temp);
		return result;
	}

	public static boolean findBook(Stack<Book> s, Stack<Book> temp, Book toFind) {
		if (s.isEmpty()) {
			return false;
		}
		else if (s.top().equals(toFind)) {
			return true;
		}
		else {
			temp.push(s.pop());
			return findBook(s, temp, toFind);
		}
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
		if (s.isEmpty()) {
			return true;
		}
		else {
			A5Stack<Book> temp = new A5Stack<Book>();
			boolean result = checkStack(s, temp);
			stackBooks(s, temp);
			return result;
		}
	}

	public static boolean checkStack(Stack<Book> s, Stack<Book> temp) {
		if (temp.isEmpty()) {
			temp.push(s.pop());
			return checkStack(s, temp);
		}
		else if (s.isEmpty()) {
			return true;
		}
		else if (s.top().getPages() < temp.top().getPages()) {
			return false;
		}
		else {
			temp.push(s.pop());
			return checkStack(s, temp);
		}
	} 
}