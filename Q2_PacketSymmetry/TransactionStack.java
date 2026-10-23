package Q2_PacketSymmetry;

public class TransactionStack 
{
    private int[] stack;
    private int top;
    public TransactionStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }

        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int value = stack[top];
        top--;

        return value;
    }
}