package Q4_ForkJoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp
{
    public static void main(String[] args)
    {
        int size = 10000;
        double[] assets = new double[size];

        for (int i = 0; i < size; i++)
        {
            assets[i] = 500 + (i % 1500);
        }
        double serialSum = 0;

        long serialStart = System.nanoTime();
        
        for (int i = 0; i < size; i++)
        {
            serialSum += assets[i];
        }
        
        long serialEnd = System.nanoTime();
        
        ForkJoinPool pool = new ForkJoinPool();
        
        long parallelStart = System.nanoTime();
        
        double parallelSum = pool.invoke(
                new ParallelRiskCalculator(assets, 0, size));
        
        long parallelEnd = System.nanoTime();
        
        double riskCap = 1500;
        
        pool.invoke(new PortfolioThresholdTask(
                assets, 0, size, riskCap));
    }
}