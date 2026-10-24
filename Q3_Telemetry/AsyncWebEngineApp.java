package Q3_Telemetry;

public class AsyncWebEngineApp
{
    public static void main(String[] args)
    {
        System.out.println("Default thread name: "
                + Thread.currentThread().getName());

        TelemetryThread telemetryThread = new TelemetryThread();
        telemetryThread.setName("Telemetry-Worker");

        Thread logThread = new Thread(new LogProcessorTask());
        logThread.setName("Log-Worker");

        telemetryThread.start();
        logThread.start();

        System.out.println(telemetryThread.getName()
                + " state: " + telemetryThread.getState());

        System.out.println(logThread.getName()
                + " state: " + logThread.getState());
    }
}