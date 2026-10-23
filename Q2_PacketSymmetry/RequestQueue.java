package Q2_PacketSymmetry;

public class RequestQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public RequestQueue(int capacity) 
    {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
}
