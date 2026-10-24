package Q3_Telemetry;

public class TelemetryThread
{
    void run()
    {
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(getName() + " - System CPU and memory health update: " + i);
        }
    }    
}
