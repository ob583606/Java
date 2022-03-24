/*
 * represents a line-up to get into the venue of a music concert
 */

public class ConcertLine {

	private PriorityQueue attendees;

	/* 
 	 * constructor that initializes attendees to a default-sized priority queue
	 */
	public ConcertLine() {
		// TODO: implement this
	}

	/* 
	 * constructor that initializes attendees to a priority queue of given size
	 */
	public ConcertLine(int size) {
		// TODO: implement this
	}


	/* Purpose: add given Attendee to attendees line or prints
	 *          a notification message if attendees is full
	 * Parameters: Attendee a - the attendee who just arrived at
	 *             the concert and wants to enter the venue
	 * Returns: void - nothing
	 */
	public void addAttendee(Attendee a) {
		// TODO: implement this
	}


	/* Purpose: gets the number of attendees waiting to get in
	 * Parameters: none
	 * Returns: int - number of attendees waiting to get in
	 */
	public int numAttendeesWaiting() {
		// TODO: implement this
		
		return -1; // so it compiles
	}


	/* Purpose: removes and returns the next attendee from attendees
	 * Parameters: none
	 * Returns: Attendee - the next attendee, null if there are no more
	 *                     attendees waiting to get into the venue.
	 */
	public Attendee nextAttendee() {
		// TODO: implement this
		
		return null; // so it compiles
	}
}

