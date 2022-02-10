public class midtermexercise {
    public static void main(String[] args) {
        int[] topTen = {95, 92, 88, 82, 77, 70, 62, 60, 56, 54};

        int[] copy = new int[topTen.length];
        int newScore = 0;

        for (int i = 0; i < topTen.length; i++) {
            if (newScore < topTen[i]) {
                copy[i] = topTen[i];
            }
            if (newScore >= topTen[i]) {
                for (int r = 10-i; r > 0; r--) {
                    int oldscore = topTen[10-r];
                    topTen[10-r] = newScore;
                    newScore = oldscore;
                }

            }
        }

        for (int i = 0; i < topTen.length; i++) {
            System.out.println(topTen[i]);
        }
    }
}
