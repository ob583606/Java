public class A4Tester {

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
		
		testStack.push(3);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==3, "top works after initial push");

		testStack.push(4);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==4, "top works after initial push");

		testStack.pop();
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==3, "top works after initial push");
				
		testStack.pop();
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==2, "top works after initial push");
		
		testStack.pop();
		displayResults(testStack.isEmpty(), "stack should be empty");

		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		displayResults(!testStack.isEmpty(), "stack should have 5 elements");
		result = testStack.pop();
		displayResults(result==5, "top works after pushes");
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result==4, "top works after pop");
		testStack.popAll();
		displayResults(testStack.isEmpty(), "stack should be empty");

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
		
		System.out.println();
	}

	public static void testStackedCorrectly() {
		System.out.println("Testing stackedCorrectly");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		Plate p6 = new Plate(-3);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		A4Stack<Plate> s3 = new A4Stack<Plate>();

		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		s2.push(p1);
		s2.push(p4);

		s3.push(p2);
		s3.push(p4);
		s3.push(p1);
		s3.push(p5);
		s3.push(p3);
		
		s3.push(p1);
		s3.push(p4);
		
		boolean result = true;
		
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly");
		
		result = A4Exercises.stackedCorrectly(s2);
		displayResults(!result, "s2 stacked incorrectly");

		result = A4Exercises.stackedCorrectly(s3);
		displayResults(!result, "s3 stacked incorrectly");

		s3.popAll();
		s3.push(p6);
		s3.push(p6);
		s3.push(p6);

		result = A4Exercises.stackedCorrectly(s3);
		displayResults(result, "s3 stacked correctly");
		
		
		System.out.println();
	}

	public static void testInsertPlate() {
		System.out.println("Testing insertPlate");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		Plate p6 = new Plate(-3);
		
		Plate insert = new Plate(6);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		A4Stack<Plate> s3 = new A4Stack<Plate>();
		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into stack");

		s2.push(p6);
		s2.push(p6);
		s2.push(p6);
		A4Exercises.insertPlate(s2, insert);
		displayResults(A4Exercises.stackedCorrectly(s2), "insert into negative stack");

		A4Exercises.insertPlate(s3, insert);
		displayResults(A4Exercises.stackedCorrectly(s3), "insert into empty stack");
		
		//TODO: add more tests here
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