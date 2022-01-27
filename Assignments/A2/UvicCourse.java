public class UvicCourse {
	private String name;
	private Student[] classList;
	
	public UvicCourse(String name, Student[] classList) {
		this.name = name;
		this.classList = classList;
	}
	
	/*
	 * Purpose: get this course's name
	 * Parameters: none
	 * Returns: String - this course's name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Purpose: get this course's classlist
	 * Parameters: none
	 * Returns: Student[] - the array of students in this class
	 */
	public Student[] getClassList() {
		return classList;
	}
	
	
	/* 
	 * Purpose: calculate the average grade of all students in this course
	 * Parameters: none
	 * Returns: double - the average grade of all students,
	 *                   or 0.0 if there are no enrolled students
	 */
	public double averageGrade() {	
		if (classList.length == 0) {
			return 0.0;
		}
		double average = 0.0;

		for (int i = 0; i < classList.length; i++) {
			average += classList[i].getGrade();
		}
		
		average /= classList.length;
		
		return average; // so it compiles	
	}


	/*
	 * Purpose: gets the grade of the student with given sid
	 * Parameters: String sid - the sid of the student to search for
	 * Returns: int - the grade of the students with given sid, 
	 *                or -1 if no student with given sid is in 
	 *                enrolled in this class
	 */
	public int getGrade(String sid) {
		int grade = -1;
		int position = 0;
		System.out.println(classList[0].getSid());
		for (int i = 0; i < classList.length; i++) {
			if (classList[i].getSid() == sid) {
				position = i;
			}
		}

		grade = classList[position].getGrade();

		return grade; // so it compiles
	}

	
	/*
	 * Purpose: determines if s is in this course's class list
	 * Parameters: Student s - the student
	 * Returns: boolean - true if this course's class list contains s
	 */
	public boolean hasStudent(Student s) {
		for (int i = 0; i < classList.length; i++) {
			if (classList[i].getSid() == s.getSid()) {
				return true;
			}
		}	
		return false;
	}
	
	
	/*
	 * Purpose: updates the grade of the student with given studentSid to
	 *          newGrade if the student is found in this course's class list
	 * Parameters: String studentSid - the sid of the student to update
	 *             int newGrade - the new grade for the student
	 * Returns: void - nothing
	 */
	public void updateGrade(String studentSid, int newGrade) {
		int position = -1;

		for (int i = 0; i < classList.length; i++) {
			if (classList[i].getSid() == studentSid) {
				position = i;
			}
		}
		
		if (position != -1) {
			classList[position].setGrade(newGrade);
		}
	}
	

	
	/*
	 * Purpose: add the given student to this course's classlist
	 * Parameters: Strudent newStudent - student to add to class list
	 * Returns: void - nothing
	 * Precondition: newStudent is not already a student in classList
	 */
	public void addStudent(Student newStudent) {
		Student[] updatedList = new Student[classList.length+1];
		updatedList[classList.length] = newStudent;	
		classList = updatedList;
	}

}