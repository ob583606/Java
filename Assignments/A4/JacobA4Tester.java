
public class JacobA4Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main(String[] args) {
		testStackOperations();
		testStackIsGeneric();
		testStackedCorrectly();
		testInsertPlate();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testStackOperations() {
		System.out.println("Stack Operations Tests:");
		A4Stack<Integer> testStack = new A4Stack<Integer>();
		int result = 0;
		
		displayResults(testStack.isEmpty(), "stack initially empty");
				
		testStack.push(2);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==2, "top works after initial push");
		
		//TODO: add more tests here
				
		System.out.println();
	}
	
	public static void testStackIsGeneric() {
		System.out.println("Stack Generics Tests:");
		A4Stack<Integer> s1 = new A4Stack<Integer>();
		A4Stack<String> s2 = new A4Stack<String>();
		A4Stack<Double> s3 = new A4Stack<Double>();
		
		int result1;
		String result2;
		double result3;
		
		s1.push(3);
		s1.push(8);
		s2.push("CSC");
		s2.push("ENGR");
		s3.push(5.5);
		s3.push(9.1);
		
		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();
		
		displayResults(result1==8, "Integer Stack");
		displayResults(result2.equals("ENGR"), "String Stack");
		displayResults(result3==9.1, "Double Stack");		
		
		result1 = s1.top();
		result2 = s2.top();
		result3 = s3.top();
		
		displayResults(result1==3, "Integer Stack");
		displayResults(result2.equals("CSC"), "String Stack");
		displayResults(result3==5.5, "Double Stack");
		
		//TODO: add more tests here
		
		System.out.println();
	}

	public static void testStackedCorrectly() {
		System.out.println("Testing stackedCorrectly");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		A4Stack<Plate> s3 = new A4Stack<Plate>();
		A4Stack<Plate> s4 = new A4Stack<Plate>();
		A4Stack<Plate> s5 = new A4Stack<Plate>();
		A4Stack<Plate> s6 = new A4Stack<Plate>();
		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		s2.push(p1);
		s2.push(p4);

		s4.push(p1);

		s5.push(p2);
		s5.push(p1);

		s6.push(p1);
		s6.push(p2);
		
		boolean result = false;
		int top;

		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly");
		
		result = A4Exercises.stackedCorrectly(s2);
		displayResults(!result, "s2 stacked correctly");
		
		result = A4Exercises.stackedCorrectly(s3);
		displayResults(result, "s3 stacked correctly");

		result = A4Exercises.stackedCorrectly(s4);
		displayResults(result, "s4 stacked correctly");

		result = A4Exercises.stackedCorrectly(s5);
		displayResults(result, "s5 stacked correctly");

		result = A4Exercises.stackedCorrectly(s6);
		displayResults(!result, "s6 stacked correctly");

		top = s1.top().getDiameter();
		displayResults(top == p3.getDiameter() && !s1.isEmpty(), "s1 not modified");

		top = s2.top().getDiameter();
		displayResults(top == p4.getDiameter() && !s2.isEmpty(), "s2 not modified");

		displayResults(s3.isEmpty(), "s3 not modified");

		top = s4.top().getDiameter();
		displayResults(top == p1.getDiameter() && !s4.isEmpty(), "s4 not modified");

		top = s5.top().getDiameter();
		displayResults(top == p1.getDiameter() && !s5.isEmpty(), "s5 not modified");

		top = s6.top().getDiameter();
		displayResults(top == p2.getDiameter() && !s6.isEmpty(), "s6 not modified");

		System.out.println();
	}

	public static void testInsertPlate() {
		System.out.println("Testing insertPlate");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		
		Plate insert = new Plate(6);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into empty stack");
		
		A4Exercises.insertPlate(s2, p1);
		displayResults(A4Exercises.stackedCorrectly(s2), "insert into empty stack");

		A4Exercises.insertPlate(s2, p2);
		displayResults(A4Exercises.stackedCorrectly(s2), "insert into empty stack");

		A4Exercises.insertPlate(s2, p3);
		displayResults(A4Exercises.stackedCorrectly(s2), "insert into empty stack");

		A4Exercises.insertPlate(s2, p4);
		displayResults(A4Exercises.stackedCorrectly(s2), "insert into empty stack");

		A4Exercises.insertPlate(s2, p5);
		displayResults(A4Exercises.stackedCorrectly(s2), "insert into empty stack");
	}

	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}