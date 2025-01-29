public class ExpressionValidator {

    public static boolean isValidExpression(String expression) {
        if (!isValidParanthesis(expression)) {
            return false;
        }

        if (!isValidPosition(expression)) {
            return false;
        }

        return true;

    }

    public static boolean isValidParanthesis(String expression) {
        int balancedparacount = 0;

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);
            if (c == '(') {
                balancedparacount++;
            }

            else if (c == ')') {
                balancedparacount--;

                if (balancedparacount < 0) {
                    return false;
                }
            }

        }

        return balancedparacount == 0;
    }

    public static boolean isValidPosition(String expression) {
        String operators = "+-*/";
        char prev = ' ';
        for (int i = 0; i < expression.length(); i++) {

            char current = expression.charAt(i);
            if (i == 0 && operators.indexOf(current) != -1) {
                return false;
            }

            if (i == expression.length() - 1 && operators.indexOf(current) != -1) {
                return false;
            }

            if (operators.indexOf(current) != -1 && operators.indexOf(prev) != -1) {
                return false;
            }
            prev = current;

        }

        return true;
    }

    public static void main(String[] args) {

        String expression1 = "(a+b)";
        String expression2 = "((a+3)";

        System.out.println(isValidExpression(expression1));

    }
}
