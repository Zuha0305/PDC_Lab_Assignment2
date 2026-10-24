package Q5_SensorSearch;

public class ParallelMinSearch extends SensorSearchEngine {
    private int minimum;

    public ParallelMinSearch(String name, int[] sensorGrid,
                             int start, int end) {
        super(name, sensorGrid, start, end);
        minimum = Integer.MAX_VALUE;
    }
}