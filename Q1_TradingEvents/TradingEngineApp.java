package Q1_TradingEvents;

public class TradingEngineApp {
    public static void main(String[] args) {
        TradeEvent event1 = new FIXOrderEvent(
                "FIX-Gateway", System.currentTimeMillis(),
                1000.0, "ORD101");

        TradeEvent event2 = new ReutersQuoteEvent(
                "Reuters", System.currentTimeMillis(),
                150.0, 149.5, 150.5);

        event1.dispatch();
        System.out.println();

        event2.dispatch();
    }
}