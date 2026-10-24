package Q3_Telemetry;

public class LogProcessorTask implements Runnable
{
    public void run()
    {
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(Thread.currentThread().getName()
                    + " - Log metrics iteration: " + i);

        }
    }
}
