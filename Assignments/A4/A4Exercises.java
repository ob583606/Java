public class A4Exercises {
	
	/*
	 * Purpose: determine if the stack of plates has been
	 *          stacked correctly (ie. there is never a plate
	 *          on top of a smaller plate)
	 * Parameters: Stack<Plate> s - a stack of plates
	 * Returns: boolean - true if the plates are stacked correctly
	 *                    false otherwise
	 * Post-condition: the contents of s are not modified
	 */
	public static boolean stackedCorrectly(A4Stack<Plate> s) {
		A4Stack<Plate> temp1 = new A4Stack<Plate>();
		A4Stack<Plate> temp2 = new A4Stack<Plate>();

		while (s.top() != null) {
			temp1.push(s.top());
			temp2.push(s.pop());
		}
		while (temp2.top() != null) {
			s.push(temp2.pop());
		}
		while (temp1.top() != null) {
			int t = temp1.pop().getDiameter();
			if (temp1.top() == null) {
				return true;
			} 
			if (t < temp1.top().getDiameter()) {
				return false;
			}
		}
		temp1.popAll();
		temp2.popAll();
		return true;
	}
	
	/*
	 * Purpose: insert p into the correct location in the
	 *          stack such that there are no smaller plates 
	 *          below p and no larger plates above p
	 * Parameters: Stack<Plate> s - a stack of plates
	 *             Plate p - the plate to insert into s
	 * Returns: void - nothing
	 * Pre-condition: plates in s have been stacked correctly
	 */
	public static void insertPlate(A4Stack<Plate> s, Plate p) {
		A4Stack<Plate> temp = new A4Stack<Plate>();
		
		while (s.top() != null) {
			if (s.top().getDiameter() <= p.getDiameter()) {
				temp.push(s.pop());
			} else {
				s.push(p);
				while (temp.top() != null) {
					s.push(temp.pop());
				}
				return;
			}
		}
		s.push(p);

	}
}