import java.util.Arrays;
import java.util.*;

public class TrainPlatform {

    public static int maxPlatformsNeeded(int[] arr, int[] dep) {

        int requiredPlatforms = 0;

        int MaxPlatforms = 0;
        int lenarr = arr.length;

        // for (int i = 0; i < lenarr; i++) {
        // if (arr[i] > dep[i]) {
        // platforms += 1;
        // }

        // if (dep[i] < arr[i]) {
        // platforms -= 1;
        // }
        // }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] < dep[j]) {
                requiredPlatforms += 1;
                System.out.println("Required PLats :" + requiredPlatforms);
                i++;
            }

            else {
                requiredPlatforms -= 1;
                System.out.println("Required PLats :" + requiredPlatforms);
                j++;
            }
            MaxPlatforms = Math.max(MaxPlatforms, requiredPlatforms);

        }

        return MaxPlatforms;
    }

    public static void main(String[] args) {

        // Input: arr[] = [900, 940, 950, 1100, 1500, 1800],
        // dep[] = [910, 1200, 1120, 1130, 1900, 2000]

        int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };

        int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };
        int platforms = maxPlatformsNeeded(arrival, departure);

        System.out.println("Maximum Platforms needed : " + platforms);
    }
}
