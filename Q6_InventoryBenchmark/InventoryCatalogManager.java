package Q6_InventoryBenchmark;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryCatalogManager 
{

    private static final int TOTAL_OPERATIONS = 50000;
    private static final int THREAD_COUNT = 10;

    private static Map<String, Integer> createSynchronizedMap() 
    {
        return Collections.synchronizedMap(new HashMap<>());
    }

    private static Map<String, Integer> createConcurrentMap() 
    {
        return new ConcurrentHashMap<>();
    }

    private static void runBenchmark(String mapName, Map<String, Integer> inventory) 
    {
        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(THREAD_COUNT);
        long startTime = System.nanoTime();
    }
    for (int thread = 0; thread < THREAD_COUNT; thread++) 
    {
        final int workerId = thread;
    
        executor.execute(() -> {
            for (int i = 0; i < TOTAL_OPERATIONS / THREAD_COUNT; i++) 
            {
                String item = "Item-" + (i % 1000);
                int quantity = workerId * (TOTAL_OPERATIONS / THREAD_COUNT) + i;
    
                inventory.put(item, quantity);
            }
        });
    }
    executor.shutdown();

    try 
    {
        if (!executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES)) 
        {
            executor.shutdownNow();
            System.out.println("Benchmark timed out.");
            return;
        }
    } 
    catch (InterruptedException e) 
    {
        executor.shutdownNow();
        Thread.currentThread().interrupt();
        System.out.println("Benchmark interrupted.");
        return;
    }
    long elapsedNanos = System.nanoTime() - startTime;

    double elapsedSeconds = elapsedNanos / 1_000_000_000.0;
    
    double throughput = TOTAL_OPERATIONS / elapsedSeconds;
    
    System.out.println(mapName + " execution time: " + (elapsedNanos / 1_000_000.0) + " ms");
    
    System.out.printf("%s throughput: %.2f updates/second%n", mapName, throughput);
    
    System.out.println("Inventory items: " + inventory.size());
    System.out.println();
    public static void main(String[] args) 
    {

        Map<String, Integer> synchronizedInventory = createSynchronizedMap();
    
        runBenchmark("SynchronizedMap", synchronizedInventory);
        Map<String, Integer> concurrentInventory =createConcurrentMap();
    
        runBenchmark("ConcurrentHashMap", concurrentInventory);
        System.out.println("Both inventory benchmarks completed.");
    }
}
