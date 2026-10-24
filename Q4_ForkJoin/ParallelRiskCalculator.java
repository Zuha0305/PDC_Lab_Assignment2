package Q4_ForkJoin;

import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator
{
    private double[] assets;
    private int start;
    private int end;

    private static final int THRESHOLD = 1000;
    
    public ParallelRiskCalculator(double[] assets, int start, int end)
    {
        this.assets = assets;
        this.start = start;
        this.end = end;
    }
}
