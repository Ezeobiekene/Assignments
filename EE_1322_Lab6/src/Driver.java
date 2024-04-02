import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number you want to find the Fibonacci Series for:");
        int fibNumber = scanner.nextInt();

        FibIteration iteration = new FibIteration();
        FibFormula formula = new FibFormula();

        int iterationAnswer = iteration.calculate_fib(fibNumber);
        int formulaAnswer = formula.calculate_fib(fibNumber);

        System.out.println("Fib of "+fibNumber+" by iteration is: " + iterationAnswer);
        System.out.println("Fib of "+fibNumber+" by formula is: " + formulaAnswer);
    }
}
