package exception;

public class ExampleException {
    public static void main(String args[]) {
        try {
            division(2, 0);
        } finally {
            System.out.print("\nfinally");
        }
        System.out.print("\nReturn from main");
    }

    static void division(int i, int j) {
        try {
            System.out.print("i/j: " + (i / j));
        } catch (ArithmeticException e) {
            System.out.print("Catch");
        }
        System.out.println("\nReturn from division");
    }
}
