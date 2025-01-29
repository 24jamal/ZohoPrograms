import java.util.Scanner;

public class GridXO {

    public static void printpattern(int M, int N) {

        char[][] grid = new char[N][M];
        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer <= layers; layer++) {
            char fillchar = (layer % 2 == 0) ? 'X' : 'O';

            for (int col = layer; col < M - layer; col++) {
                grid[layer][col] = fillchar;
                grid[N - layer - 1][col] = fillchar;
            }

            for (int row = layer; row < N - layer; row++) {
                grid[row][layer] = fillchar;
                grid[row][M - layer - 1] = fillchar;
            }

        }

        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the row size : ");
        int M = sc.nextInt();

        System.out.println("Enter the column size");
        int N = sc.nextInt();

        printpattern(M, N);
    }

}
