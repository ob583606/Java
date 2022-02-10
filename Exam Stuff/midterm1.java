public class midterm1 {

    public static int[] add(int[] initial, int newval) {
        int[] copy = new int[initial.length+1];
        for (int i = 0; i < initial.length; i++) {
            copy[i] = initial[i];
        }
        copy[initial.length] = newval;
        initial = copy;

        return initial;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        int[] first = {1, 2, 3, 4};
        System.out.println(first);
        System.out.println(add(first, 5));
        
        add(first, 6);
        System.out.println(first);
        print(first);

        int[] second = add(first, 5);
        System.out.println(second);
        print(second);
        add(second, 19);
        print(second);
        print(add(second, 21));
    }
}
