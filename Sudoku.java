public class Sudoku {

    public static boolean isSudokuBoard(int[][] board) {
        if (isRowsLegible(board) && isColumnsLegible(board) && isGridsLegible(board)) {
            return true;

        }

        return false;

    }

    public static boolean isRowsLegible(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] numbers = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num < 1 || num > 9 || numbers[num - 1]) {
                    System.out.println("Row wise Invalid due to index : " + i + " - " + j);
                    return false;
                }
                numbers[num - 1] = true;
            }

        }
        return true;
    }

    public static boolean isColumnsLegible(int[][] board) {
        for (int j = 0; j < 9; j++) {
            boolean[] numbers = new boolean[9];
            for (int i = 0; i < 9; i++) {
                int num = board[i][j];
                if (num < 1 || num > 9 || numbers[num - 1]) {
                    System.out.println("Column wise Invalid due to index : " + i + " - " + j);

                    return false;
                }

            }
        }
        return true;
    }

    public static boolean isGridsLegible(int[][] board) {
        for (int rows = 0; rows < 9; rows += 3) {
            for (int cols = 0; cols < 9; cols += 3) {
                if (!isGridLegible(board, rows, cols)) {

                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isGridLegible(int[][] board, int Startingrows, int Startingcols) {
        for (int i = 0; i < Startingrows; i++) {
            boolean[] numbers = new boolean[9];
            for (int j = 0; j < Startingcols + 3; j++) {
                int num = board[i][j];
                if (num < 1 || num > 9 || numbers[num - 1]) {
                    System.out.println("Subgrid wise Invalid due to index : " + i + " - " + j);

                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[][] board = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
                { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
                { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
                { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
                { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
                { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
                { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
                { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
                { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        };

        if (isSudokuBoard(board)) {
            System.out.println("This is Valid Sudoku Board");
        }

        else {
            System.out.println("This is Invalid Sudoku board");
        }

    }
}
