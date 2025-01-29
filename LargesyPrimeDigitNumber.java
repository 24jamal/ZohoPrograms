public class LargesyPrimeDigitNumber {

    public static boolean largestprimedigit(int num) {
        String numString = String.valueOf(num);

        char[] numArray = { '2', '3', '5', '7' };

        for (char no : numString.toCharArray()) {
            boolean isPrime = false;
            for (char numlet : numArray) {
                if (no == numlet) {
                    isPrime = true;
                    break;
                }

            }

            if (!isPrime) {
                return false;
            }

        }

        return true;
    }

    public static int LargestPrimeinGivenNo(int num) {
        for (int i = num; i > 0; i--) {
            if (largestprimedigit(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int num = 100;

        int largeprime = LargestPrimeinGivenNo(num);

        if (largeprime > 0) {
            System.out.println("Largest Prime is :" + largeprime);
        }

        else {
            System.out.println("Largest Prime is :" + largeprime);
        }

    }
}
