public class helloworld {

    public static void printGreeting() {
        System.out.println("Fuck this syntax");
    }

    public static int mystery(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return mystery(n-1) + mystery(n-2);
        }
    }

    public static void main(String[] args) {
        printGreeting();
        System.out.println("Hello World!");
        int x = mystery(6);
        System.out.println(x);
    }
}