public class FibIteration implements FindFib {

    @Override
    public int calculate_fib(int number) {
        if (number == 1 ||number== 2){
            return 1;
        }
        int fib = 0 ;
        int fib1 = 1;
        int fib2 = 1;

        for(int i = 3; i <= number; i++){
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }
}
