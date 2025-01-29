public class NumberIncreaseReversePat {

    public static void printpattern(int n) {
        for (int i = n; i <= 0; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(j + " ");
            }
        }
    }

    public static void main(String[] args) {
        printpattern(5);
    }

}
