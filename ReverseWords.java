public class ReverseWords {

    public static String reversewordsfun(String input) {
        if (!input.contains(" ")) {
            return input;
        }

        int spaceindex = input.indexOf(" ");
        String firstword = input.substring(0, spaceindex);
        String remaining = input.substring(spaceindex + 1);

        return reversewordsfun(remaining) + " " + firstword;

    }

    public static void main(String[] args) {

        String name = "one two three";
        String reversed = reversewordsfun(name);

        System.out.println("Reversed Words is " + reversed);

    }
}