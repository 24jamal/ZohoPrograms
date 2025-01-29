import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberAndWeight {

    public static int Checkweight(int num) {

        if (isPerfectSquare(num)) {
            return 5;
        }

        if (num % 4 == 0 && num % 6 == 0) {
            return 4;
        }

        if (num % 2 == 0) {
            return 3;
        }

        return 0;

    }

    public static boolean isPerfectSquare(int num) {
        int squarerootnum = (int) Math.sqrt(num);
        return (squarerootnum * squarerootnum) == num;
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 45);

        Map<Integer, Integer> numberWeights = new HashMap<>();

        for (int num : numbers) {
            int Weight = Checkweight(num);

            numberWeights.put(num, Weight);

        }

        List<Map.Entry<Integer, Integer>> mylist = new ArrayList<>(numberWeights.entrySet());

        mylist.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> entry : mylist) {
            System.out.println("<" + entry.getKey() + "," + entry.getValue() + ">");
        }

    }
}
