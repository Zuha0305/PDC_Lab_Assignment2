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
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    public int dequeue() 
    {
        if (isEmpty()) 
        {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;

        return value;
    }
}
