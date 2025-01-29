import java.util.Scanner;

public class GridSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the grid dimensions
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        // Create a grid to represent the box
        char[][] grid = new char[rows][cols];

        // Fill the grid with '-' initially
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '-';
            }
        }

        // Input the number of atoms
        System.out.print("Enter number of atoms: ");
        int numAtoms = sc.nextInt();

        // Input the positions of the atoms
        for (int i = 0; i < numAtoms; i++) {
            int atomRow = sc.nextInt() - 1; // Adjusting to zero-based index
            int atomCol = sc.nextInt() - 1; // Adjusting to zero-based index
            grid[atomRow][atomCol] = 'X'; // Mark the atom positions as 'X'
        }

        // Input the number of rays
        System.out.print("Enter number of rays: ");
        int numRays = sc.nextInt();

        // Input the rays and simulate them
        sc.nextLine(); // Consume the newline
        for (int i = 0; i < numRays; i++) {
            String ray = sc.nextLine();
            simulateRay(grid, ray);
        }

        // Print the final grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to simulate a ray in the grid
    private static void simulateRay(char[][] grid, String ray) {
        if (ray.charAt(0) == 'R') {
            // Horizontal ray (R)
            int row = Integer.parseInt(ray.substring(1)) - 1;
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 'X') {
                    grid[row][col] = 'H'; // Hit when encountering an atom
                    return;
                }
            }
            // No atom found, mark as reflected ('R')
            grid[row][grid[row].length - 1] = 'R';
        } else if (ray.charAt(0) == 'C') {
            // Vertical ray (C)
            int col = Integer.parseInt(ray.substring(1)) - 1;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 'X') {
                    grid[row][col] = 'H'; // Hit when encountering an atom
                    return;
                }
            }
            // No atom found, mark as reflected ('R')
            grid[grid.length - 1][col] = 'R';
        }
    }
}
