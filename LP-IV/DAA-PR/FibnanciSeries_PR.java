public class FibnanciSeries_PR {
    // Time Complexity: O(2^n)   // exponential recursion tree
    // Space Complexity: O(n)     // recursion stack depth
    public static int fibNormal(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibNormal(n - 1) + fibNormal(n - 2);
    }

    // Time Complexity: O(n * 2^n)   // calls fibNormal for every value from 0 to n
    // Space Complexity: O(n)        // recursive calls stack
    public static void printFibonacciSeries(int n) {
        System.out.print("Fibonacci Series : ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibNormal(i));
            if (i < n) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 6;

        printFibonacciSeries(n);
    }
}
