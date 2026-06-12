import java.util.*;

public class NQueens {

    static int num;
    static List<List<String>> list = new ArrayList<>();
    static int[][] sol;

    static boolean findsolution(int row) {
        if (row == num) {
            printsolution();
            return true;
        }

        for (int col = 0; col < num; col++) {
            if (isValid(row, col)) {
                sol[row][col] = 1;

                findsolution(row + 1);

                sol[row][col] = 0;
            }
        }
        return false;
    }

    static void printsolution() {
        List<String> k = new ArrayList<>();

        for (int[] arr : sol) {
            StringBuilder sb = new StringBuilder();

            for (int i : arr) {
                if (i == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }

            k.add(sb.toString());
        }

        list.add(k);
    }

    static boolean isValid(int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (sol[i][col] == 1)
                return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (sol[i][j] == 1)
                return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < num; i--, j++) {
            if (sol[i][j] == 1)
                return false;
        }

        return true;
    }

    public static List<List<String>> solveNQueens(int n) {
        num = n;
        sol = new int[n][n];
        list.clear();

        findsolution(0);

        return list;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        List<List<String>> ans = solveNQueens(n);

        System.out.println("\nTotal Solutions: " + ans.size());

        for (List<String> solution : ans) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

        sc.close();
    }
}