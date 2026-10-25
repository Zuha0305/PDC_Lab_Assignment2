# PDC Lab – Assignment 2

**Course:** Parallel and Distributed Computing Lab (CS-426L)
**University:** Air University, Kharian Campus – Department of Computer Science
**Student:** Zuha (247122) | **Semester:** 5th | **Section:** BSCYS-F24-B
**Instructor:** Mr. Qaiser Ali

A collection of seven Java programs covering object-oriented design, custom data structures, multithreading, the Fork/Join framework, concurrent collections and CPU cache locality. Each question lives in its own package (folder) with each class in a separate `.java` file.

---

## Contents

| # | Package | Topic | Key concepts |
|---|---------|-------|--------------|
| 1 | `Q1_TradingEvents` | Trading events | Inheritance, constructor chaining (`super`), `@Override`, runtime polymorphism |
| 2 | `Q2_PacketSymmetry` | Packet symmetry auditor | Array-based stack (LIFO), circular-array queue (FIFO), palindrome check |
| 3 | `Q3_Telemetry` | Telemetry engine | `Thread` vs `Runnable`, `Thread.sleep()`, `setName()`, `getState()` |
| 4 | `Q4_ForkJoin` | Portfolio risk analysis | `RecursiveTask`, `RecursiveAction`, `fork()` / `join()`, `invokeAll()`, `ForkJoinPool` |
| 5 | `Q5_SensorSearch` | Sensor grid search | Abstract class extending `Thread`, parallel min/max workers, `join()` |
| 6 | `Q6_InventoryBenchmark` | Inventory benchmark | `Collections.synchronizedMap` vs `ConcurrentHashMap`, `ExecutorService` |
| 7 | `Q7_CacheLocality` | Cache locality benchmark | Row-major vs column-major traversal, `System.nanoTime()` profiling |

---

## Project structure

```
PDC_Lab_Assignment2/
├── Q1_TradingEvents/
│   ├── TradeEvent.java
│   ├── FIXOrderEvent.java
│   ├── ReutersQuoteEvent.java
│   └── TradingEngineApp.java
├── Q2_PacketSymmetry/
│   ├── TransactionStack.java
│   ├── RequestQueue.java
│   └── PacketSymmetryAuditor.java
├── Q3_Telemetry/
│   ├── LogProcessorTask.java
│   ├── TelemetryThread.java
│   └── AsyncWebEngineApp.java
├── Q4_ForkJoin/
│   ├── ParallelRiskCalculator.java
│   ├── PortfolioThresholdTask.java
│   └── ForkJoinPortfolioApp.java
├── Q5_SensorSearch/
│   ├── SensorSearchEngine.java
│   ├── ParallelMinSearch.java
│   ├── ParallelMaxSearch.java
│   └── SensorGridMonitorApp.java
├── Q6_InventoryBenchmark/
│   └── InventoryCatalogManager.java
├── Q7_CacheLocality/
│   └── CacheLocalityBenchmark.java
└── README.md
```

---

## Requirements

- **JDK 19 or newer** (JDK 21 recommended). Q4 uses `ForkJoinPool.close()` and Q6 uses `ExecutorService` features that need a recent JDK.
- A terminal (PowerShell, Command Prompt, bash) or VS Code with the Extension Pack for Java.

Check your version:

```bash
java -version
javac -version
```

---

## How to compile and run

> **Important:** run every command from the **repository root** (the folder that contains `Q1_TradingEvents`, `Q2_PacketSymmetry`, etc.). Because each class is declared inside a package, it must be launched with its fully qualified name. Running `javac` or `java` from inside a package folder causes `NoClassDefFoundError` / `cannot find symbol` errors.

On Windows PowerShell use `\`, on Linux/macOS use `/` in the paths below.

### Q1 – Trading Events
```bash
javac Q1_TradingEvents/*.java
java Q1_TradingEvents.TradingEngineApp
```

### Q2 – Packet Symmetry
```bash
javac Q2_PacketSymmetry/*.java
java Q2_PacketSymmetry.PacketSymmetryAuditor
```

### Q3 – Telemetry
```bash
javac Q3_Telemetry/*.java
java Q3_Telemetry.AsyncWebEngineApp
```

### Q4 – Fork/Join
```bash
javac Q4_ForkJoin/*.java
java Q4_ForkJoin.ForkJoinPortfolioApp
```

### Q5 – Sensor Search
```bash
javac Q5_SensorSearch/*.java
java Q5_SensorSearch.SensorGridMonitorApp
```

### Q6 – Inventory Benchmark
```bash
javac Q6_InventoryBenchmark/*.java
java Q6_InventoryBenchmark.InventoryCatalogManager
```

### Q7 – Cache Locality
```bash
javac Q7_CacheLocality/*.java
java Q7_CacheLocality.CacheLocalityBenchmark
```

---

## Program summaries and sample output

### Q1 – Trading Events
`TradeEvent` is the superclass with protected fields (`senderId`, `timestamp`, `basePrice`) and a generic `dispatch()` method. `FIXOrderEvent` and `ReutersQuoteEvent` extend it, call `super(...)` in their constructors and override `dispatch()`. The FIX order adds a 0.15% transaction fee; the Reuters quote calculates the bid-ask spread. Both objects are stored in `TradeEvent` references, so the overridden method is chosen at runtime.

```
FIX Purchase Order
Order ID: ORD101
Sender: FIX-Gateway
Price: 1000.0
Transaction Fee: 1.5
Total Cost: 1001.5

Reuters Market Quote
Sender: Reuters
Bid Price: 149.5
Ask Price: 150.5
Bid-Ask Spread: 1.0
```

### Q2 – Packet Symmetry
`TransactionStack` is an `int[]` stack (`top = -1`) and `RequestQueue` is a circular-array queue. `isSymmetric()` pushes and enqueues every element, then compares `dequeue()` (original order) with `pop()` (reverse order); any mismatch means the packet is not symmetric.

```
Packet 1: true
Packet 2: false
Packet 3: true
```

### Q3 – Telemetry
`LogProcessorTask` implements `Runnable` (sleeps 1000 ms) and `TelemetryThread` extends `Thread` (sleeps 800 ms). Each runs five iterations. `main` renames the threads, starts both and prints their states; the output of the two workers interleaves, showing concurrent execution. Exact interleaving and thread states vary between runs.

### Q4 – Fork/Join
`ParallelRiskCalculator` (`RecursiveTask<Double>`) sums an array of 10,000 asset values by recursively splitting it until a range is 1000 elements or fewer. `PortfolioThresholdTask` (`RecursiveAction`) increases assets above the risk cap (1500) by 5%. Serial and parallel results match; for a data set this small the Fork/Join overhead makes the parallel version slower.

```
Portfolio size: 10000
Serial risk score: 1.2245E7
Parallel risk score: 1.2245E7
Serial time: 0.1014 ms
Parallel time: 1.6495 ms
Stress test completed.
Updated first asset value: 500.0
```

### Q5 – Sensor Search
`SensorSearchEngine` is an abstract `Thread` subclass; `ParallelMinSearch` and `ParallelMaxSearch` override `processGrid()`. Four workers each search half of a 50,000-element grid, the main thread calls `join()` on all of them and merges the partial results.

```
Total sensor readings: 50000
Minimum sensor value: 0
Maximum sensor value: 9999
```

### Q6 – Inventory Benchmark
Ten threads in a fixed thread pool perform 50,000 `put()` operations on 1000 shared keys, first on a `Collections.synchronizedMap(new HashMap<>())` and then on a `ConcurrentHashMap`. `ConcurrentHashMap` is faster because it avoids one global lock.

```
SynchronizedMap execution time: 51.6907 ms
SynchronizedMap throughput: 967291.99 updates/second
Inventory items: 1000

ConcurrentHashMap execution time: 15.8575 ms
ConcurrentHashMap throughput: 3153082.14 updates/second
Inventory items: 1000
```

### Q7 – Cache Locality
Sums a 2000 × 2000 `double` matrix row by row and column by column (10 iterations each) and reports the average time and speedup. Row-major access reads contiguous memory and uses each cache line fully, so it is much faster.

```
Row-major average: 5.576 ms
Column-major average: 50.187 ms
Row-major speedup: 9.00x
```

> Timings depend on your hardware, JVM warm-up and system load, so your numbers will differ. The relative results (Fork/Join overhead on small data, `ConcurrentHashMap` ahead of `SynchronizedMap`, row-major ahead of column-major) are what matter.

---

## Concepts demonstrated

- Classes in separate `.java` files and packages
- Constructor initialisation and constructor chaining
- Method overriding and runtime polymorphism
- Manual array-based stack and circular queue
- `Thread` subclassing and `Runnable` implementations
- Thread lifecycle (`getState()`), `sleep()`, `join()` and interrupt handling
- Fork/Join: `RecursiveTask`, `RecursiveAction`, `ForkJoinPool`
- Thread pools with `ExecutorService`
- Thread-safe collections and benchmarking
- CPU cache locality profiling

---

## Author

**Zuha** – Student ID 247122
Air University, Kharian Campus
GitHub: [@Zuha0305](https://github.com/Zuha0305)