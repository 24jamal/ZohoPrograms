public class MatrixChecker {

    public static boolean isSimilarMatrix(int n, int m, int[][] matrix, int x) {
        int[][] originalmat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                originalmat[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                leftrotate(matrix[i], x);
            }

            else {
                rightrotate(matrix[i], x);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(originalmat[i][j]);
            }

            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalmat[i][j] != matrix[i][j]) {
                    return false;
                }

            }

        }

        return true;

    }

    public static void leftrotate(int[] row, int x) {
        int len = row.length;
        int[] temp = new int[len];
        int rotx = x % len;

        for (int i = 0; i < len; i++) {
            temp[i] = row[(i + x) % len];
        }

        for (int i = 0; i < len; i++) {
            row[i] = temp[i];
        }

    }

    public static void rightrotate(int[] row, int x) {
        int len = row.length;
        int[] temp = new int[len];
        int rotx = x % len;

        for (int i = 0; i < len; i++) {
            temp[i] = row[(i - x + len) % len];
        }

        for (int i = 0; i < len; i++) {
            row[i] = temp[i];
        }

    }

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, { 3, 1, 2 }, { 7, 8, 9 } };

        int n = 3; // row size;
        int m = 3;// column size
        int x = 3; // rotation size;
        boolean issimilar = isSimilarMatrix(n, m, matrix, x);

        if (!issimilar) {
            System.out.println("Not Similar matrix");
        }

        else {
            System.out.println("Similar Matrix");
        }
    }

}
