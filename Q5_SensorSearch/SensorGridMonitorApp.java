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
        int middle = sensorGrid.length / 2;

        ParallelMinSearch minWorker1 = new ParallelMinSearch("Min-Worker-1", sensorGrid, 0, middle);
        
        ParallelMinSearch minWorker2 = new ParallelMinSearch("Min-Worker-2", sensorGrid, middle, sensorGrid.length);
        
        ParallelMaxSearch maxWorker1 = new ParallelMaxSearch("Max-Worker-1", sensorGrid, 0, middle);
        
        ParallelMaxSearch maxWorker2 = new ParallelMaxSearch("Max-Worker-2", sensorGrid, middle, sensorGrid.length);
    }
}