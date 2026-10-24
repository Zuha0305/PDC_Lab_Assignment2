package Q5_SensorSearch;

public class ParallelMaxSearch extends SensorSearchEngine {
    private int maximum;

    public ParallelMaxSearch(String name, int[] sensorGrid,
                             int start, int end) {
        super(name, sensorGrid, start, end);
        maximum = Integer.MIN_VALUE;
    }
}