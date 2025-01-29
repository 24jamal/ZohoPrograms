import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrandChildrenCount {

    public static void main(String[] args) {
        String relationships[][] = {
                { "luke", "shaw" },
                { "wayne", "rooney" },
                { "rooney", "ronaldo" },
                { "shaw", "rooney" }
        };

        Map<String, List<String>> familytree = new HashMap<>();

        for (String[] relation : relationships) {

            String child = relation[0];
            String father = relation[1];

            familytree.computeIfAbsent(father, k -> new ArrayList<>()).add(child);

        }

        String person = "ronaldo";

        int GrandChildCount = GrandchildrenFunc(familytree, person);

        System.out.println("GrandChildrenCount" + GrandChildCount);

    }

    public static int GrandchildrenFunc(Map<String, List<String>> familytree, String person) {
        int counter = 0;

        List<String> children = familytree.get(person);

        if (children != null) {
            for (String child : children) {
                {
                    if (child != null) {
                        List<String> childrenofchild = familytree.get(child);
                        counter += childrenofchild.size();
                    }
                }
            }
        }

        return counter;
    }

}
