public class isSubstring {

    public static int isSubstringFun(String input1, String input2) {
        return input1.indexOf(input2);

    }

    public static void main(String[] args) {
        String input1 = "abcd123";
        String input2 = "1223";

        int number = isSubstringFun(input1, input2);

        if (number >= 0) {
            System.out.println("It is a sub string");
        }

        else {
            System.out.println("It is not a sub string");
        }
    }
}
