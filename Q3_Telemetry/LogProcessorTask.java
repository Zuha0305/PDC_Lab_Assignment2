package Q3_Telemetry;

public class LogProcessorTask implements Runnable
{
    public void run()
    {
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(Thread.currentThread().getName()
                    + " - Log metrics iteration: " + i);
            
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
                Thread.currentThread().interrupt();
                return;
            }

        }
    }
}
