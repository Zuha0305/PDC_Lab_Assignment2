package Q5_SensorSearch;

public abstract class SensorSearchEngine extends Thread {

    protected int[] sensorGrid;
    protected int start;
    protected int end;

    public SensorSearchEngine(String name, int[] sensorGrid,
                              int start, int end) {
        super(name);
        this.sensorGrid = sensorGrid;
        this.start = start;
        this.end = end;
    }

    public abstract void processGrid();

    @Override
    public void run() {
        processGrid();
    }
}
