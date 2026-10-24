package Q3_Telemetry;

public class AsyncWebEngineApp
{
    public static void main(String[] args)
    {
        System.out.println("Default thread name: "
                + Thread.currentThread().getName());
                
        TelemetryThread telemetryThread = new TelemetryThread();
        telemetryThread.setName("Telemetry-Worker");
    }
}