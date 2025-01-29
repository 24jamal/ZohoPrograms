public class InvalidParenthesisRemover {

    public static String InvalidParatRemover(String s) {
        StringBuilder firstpass = new StringBuilder();

        int openparacount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openparacount++;
                firstpass.append(c);

            }

            else if (c == ')') {
                if (openparacount > 0) {
                    openparacount -= 1;
                    firstpass.append(c);
                }
            }

            else {
                firstpass.append(c);
            }

        }

        int closedparacount = 0;

        StringBuilder result = new StringBuilder();
        for (int i = firstpass.length() - 1; i >= 0; i--) {
            char c = firstpass.charAt(i);

            if (c == ')') {
                closedparacount += 1;
                result.append(c);
            }

            else if (c == '(') {
                if (closedparacount > 0) {
                    closedparacount--;
                    result.append(c);
                }
            }

            else {
                result.append(c);
            }
        }

        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String result1 = InvalidParatRemover("(((((()))))))))))))))))");
        System.out.println(result1);

    }
}
