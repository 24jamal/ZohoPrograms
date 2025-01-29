class ExpandAndPrint {

    public static void Pattern(String input) {

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            char currentchar = input.charAt(i);
            i++;

            StringBuilder numberBuilder = new StringBuilder();
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                numberBuilder.append(input.charAt(i));
                i++;
            }

            int numbervar = Integer.parseInt(numberBuilder.toString());

            for (int j = 0; j < numbervar; j++) {
                result.append(currentchar);

            }

        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        String pattern = "a5b3";
        Pattern(pattern);

    }
}