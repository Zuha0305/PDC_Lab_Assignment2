package Q7_CacheLocality;

public class CacheLocalityBenchmark {

    private static final int SIZE = 2000;
    private static final int ITERATIONS = 10;

    private static double[][] matrix = new double[SIZE][SIZE];

    public static void main(String[] args) {

        System.out.println("Cache Locality Benchmark");
        System.out.println("Matrix size: " + SIZE + " x " + SIZE);
        System.out.println("Iterations: " + ITERATIONS);
    }
}