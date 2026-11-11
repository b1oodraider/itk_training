package itk.learn;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    static void main() {
        int n = 10; // Вычисление факториала для числа 10

        long result;
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            FactorialTask factorialTask = new FactorialTask(n);
            result = forkJoinPool.invoke(factorialTask);
        }

        System.out.println("Факториал " + n + "! = " + result);
    }
}

class FactorialTask extends RecursiveTask<Long> {
    private int start = 1;
    private int end;
    private static final int LIMIT = 2;

    public FactorialTask(int end) {
        if (end < 0) {
            throw new IllegalArgumentException();
        }
        this.end = end;
    }

    public FactorialTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= LIMIT) {
            long result = 1;

            for (int i = start; i <= end; i++) {
                result *= i;
            }

            return result;
        }

        int middle = (start + end) / 2;

        FactorialTask left = new FactorialTask(start, middle);
        FactorialTask right = new FactorialTask(middle + 1, end);

        left.fork();

        long rightResult = right.compute();
        long leftResult = left.join();


        return leftResult * rightResult;
    }
}
