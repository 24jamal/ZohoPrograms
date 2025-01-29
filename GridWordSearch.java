public class GridWordSearch {

    public static void GridSearch(char[][] grid, String word) {

        int rows = grid.length;
        System.out.println("Rowsize " + rows);
        int columns = grid[0].length;
        System.out.println("Column size " + columns);
        int wordlength = word.length();

        // Horizontal Search in Grid:

        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j <= columns - wordlength; j++) {
                    int k;
                    for (k = 0; k < wordlength; k++) {
                        if (Character.toLowerCase(grid[i][j + k]) != Character.toLowerCase(word.charAt(k))) {
                            break;
                        }

                    }
                    if (k == wordlength) {

                        System.out.println("Starting Index : " + i + " - " + j);
                        System.out.println("Ending Index : " + i + " - " + (j + (wordlength - 1)));
                    }

                }

            }

        } catch (Exception e) {
            System.out.println(e);

        }

        // Vertical Logics:

        for (int i = 0; i <= rows - wordlength; i++) {
            for (int j = 0; j < columns; j++) {
                int k;
                for (k = 0; k < wordlength; k++) {
                    if (Character.toLowerCase(grid[i + k][j]) != Character.toLowerCase(word.charAt(k))) {
                        break;
                    }

                }
                if (k == wordlength) {

                    System.out.println("Starting Index : " + i + " - " + j);
                    System.out.println("Ending Index : " + (i + (wordlength - 1)) + " - " + j);
                }

            }

        }

    }

    public static void main(String[] args) {
        char grid[][] = {
                { 'W', 'e', 'l', 'c', 'o' },
                { 'm', 'e', 't', 'o', 'z' },
                { 'o', 'h', 'o', 'c', 'o' },
                { 'r', 'p', 'o', 'r', 'a' },
                { 't', 'i', 'o', 'n', ' ' }

        };

        String wordTosearch = "TOO";

        GridSearch(grid, wordTosearch);
    }
}
