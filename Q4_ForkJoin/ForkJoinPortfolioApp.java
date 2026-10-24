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
    }
}