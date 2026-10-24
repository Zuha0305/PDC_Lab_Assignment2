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

        minWorker1.start();
        minWorker2.start();
        maxWorker1.start();
        maxWorker2.start();
        
        try 
        {
            minWorker1.join();
            minWorker2.join();
            maxWorker1.join();
            maxWorker2.join();
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
            System.out.println("Search interrupted.");
            return;
        }
        int minimum = Math.min(minWorker1.getMinimum(), minWorker2.getMinimum());

        int maximum = Math.max(maxWorker1.getMaximum(), maxWorker2.getMaximum());
        
        System.out.println("Total sensor readings: " + sensorGrid.length);
        System.out.println("Minimum sensor value: " + minimum);
        System.out.println("Maximum sensor value: " + maximum);
    }
}