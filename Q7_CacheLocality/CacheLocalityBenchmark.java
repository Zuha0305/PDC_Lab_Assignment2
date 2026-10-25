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
    private static double columnMajorTraversal() 
    {
        double sum = 0;
    
        for (int j = 0; j < SIZE; j++) 
        {
            for (int i = 0; i < SIZE; i++) 
            {
                sum += matrix[i][j];
            }
        }
    
        return sum;
    }
    private static long measureRowMajor() 
    {
        long startTime = System.nanoTime();
    
        rowMajorTraversal();
    
        long endTime = System.nanoTime();
    
        return endTime - startTime;
    }
    private static long measureColumnMajor() 
    {
        long startTime = System.nanoTime();
    
        columnMajorTraversal();
    
        long endTime = System.nanoTime();
    
        return endTime - startTime;
    }
    private static void runBenchmark() 
    {
        long rowMajorTotal = 0;
        long columnMajorTotal = 0;
    
        for (int i = 0; i < ITERATIONS; i++) 
        {
            rowMajorTotal += measureRowMajor();
            columnMajorTotal += measureColumnMajor();
        }
    
        double rowMajorAverage = rowMajorTotal / (double) ITERATIONS;
    
        double columnMajorAverage = columnMajorTotal / (double) ITERATIONS;
    
        System.out.printf("Row-major average: %.3f ms%n", rowMajorAverage / 1_000_000.0);
    
        System.out.printf("Column-major average: %.3f ms%n", columnMajorAverage / 1_000_000.0);
    
        displaySpeedup(rowMajorAverage, columnMajorAverage);
    }
    private static void displaySpeedup(double rowMajorAverage, double columnMajorAverage) 
    {

        if (rowMajorAverage < columnMajorAverage) 
        {
            System.out.printf("Row-major speedup: %.2fx%n", columnMajorAverage / rowMajorAverage);
        } 
        else if (columnMajorAverage < rowMajorAverage) 
        {
            System.out.printf("Column-major speedup: %.2fx%n", rowMajorAverage / columnMajorAverage);
        } 
        else 
        {
            System.out.println("Both traversal methods have equal timing.");
        }
    }
    public static void main(String[] args) 
    {
        initializeMatrix();
    
        System.out.println("Cache Locality Benchmark");
        System.out.println("Matrix size: " + SIZE + " x " + SIZE);
        System.out.println("Iterations: " + ITERATIONS);
        System.out.println();
    
        runBenchmark();
    
        System.out.println();
        System.out.println("Benchmark completed successfully.");
    }
}