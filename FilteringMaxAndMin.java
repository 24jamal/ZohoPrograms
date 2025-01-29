import java.sql.Array;
import java.util.Arrays;

public class FilteringMaxAndMin {

    public static int[] ConditionedSortedArray(int[] arr) {
        int length = arr.length;
        int index = 0;
        int low = 0;
        int high = length - 1;
        int[] result = new int[length];
        while (low <= high) {
            if (low <= high) {
                result[index++] = arr[high--];
            }

            if (low <= high) {
                result[index++] = arr[low++];
            }
        }

        System.arraycopy(result, 0, arr, 0, arr.length);

        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        int[] array = ConditionedSortedArray(arr);

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
