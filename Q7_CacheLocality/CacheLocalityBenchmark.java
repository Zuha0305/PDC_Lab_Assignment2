package Q7_CacheLocality;

public class CacheLocalityBenchmark 
{

    private static final int SIZE = 2000;
    private static final int ITERATIONS = 10;

    private static double[][] matrix = new double[SIZE][SIZE];
    private static void initializeMatrix() 
    {
        for (int i = 0; i < SIZE; i++) 
        {
            for (int j = 0; j < SIZE; j++) 
            {
                matrix[i][j] = i + j;
            }
        }
    }
    private static double rowMajorTraversal() 
    {
        double sum = 0;
    
        for (int i = 0; i < SIZE; i++) 
        {
            for (int j = 0; j < SIZE; j++) 
            {
                sum += matrix[i][j];
            }
        }
    
        return sum;
    }

    public static void main(String[] args) 
    {

        System.out.println("Cache Locality Benchmark");
        System.out.println("Matrix size: " + SIZE + " x " + SIZE);
        System.out.println("Iterations: " + ITERATIONS);
    }
}