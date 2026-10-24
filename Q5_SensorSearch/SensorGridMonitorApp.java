package Q5_SensorSearch;

public class SensorGridMonitorApp 
{
    public static void main(String[] args) 
    {
        int[] sensorGrid = new int[50000];

        for (int i = 0; i < sensorGrid.length; i++) 
        {
            sensorGrid[i] = (i * 37) % 10000;
        }
    }
}