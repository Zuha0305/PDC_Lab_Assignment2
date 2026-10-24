package Q4_ForkJoin;

import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator extends RecursiveTask<Double>
{
    private double[] assets;
    private int start;
    private int end;

    private static final int THRESHOLD = 1000;
}
