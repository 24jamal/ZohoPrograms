import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortOddEvenPosition {

    public static void Sorted(int[] arr) {
        int n = arr.length;

        int oddsize = (n + 1) / 2;
        int evensize = n / 2;

        Integer[] oddarray = new Integer[oddsize];
        Integer[] evenarray = new Integer[evensize];

        int oddindex = 0, evenindex = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                oddarray[oddindex] = arr[i];
                oddindex++;
            } else {
                evenarray[evenindex] = arr[i];
                evenindex++;
            }

        }

        Arrays.sort(oddarray, Collections.reverseOrder());

        Arrays.sort(evenarray);

        oddindex = 0;
        evenindex = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = oddarray[oddindex++];
            }

            else {
                arr[i] = evenarray[evenindex++];
            }
        }

        System.out.println("The Conditioned Sorted Merged array :\n" + Arrays.toString(arr));

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6 };

        Sorted(arr);
    }

}
