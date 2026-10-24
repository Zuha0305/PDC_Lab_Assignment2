package Q4_ForkJoin;

import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator extends RecursiveTask<Double>
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
    @Override
    protected Double compute()
    {
        if (end - start <= THRESHOLD)
        {
            double sum = 0;

            for (int i = start; i < end; i++)
            {
                sum += assets[i];
            }

            return sum;
        }

        int middle = (start + end) / 2;

        ParallelRiskCalculator left =
                new ParallelRiskCalculator(assets, start, middle);

        ParallelRiskCalculator right =
                new ParallelRiskCalculator(assets, middle, end);

        left.fork();

        double rightResult = right.compute();
        double leftResult = left.join();

        return leftResult + rightResult;
    }
    
}
