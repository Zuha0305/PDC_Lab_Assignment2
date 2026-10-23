package Q2_PacketSymmetry;

public class PacketSymmetryAuditor 
{

    public static boolean isSymmetric(int[] packet) {
        TransactionStack stack = new TransactionStack(packet.length);
        RequestQueue queue = new RequestQueue(packet.length);

        for (int i = 0; i < packet.length; i++) {
            stack.push(packet[i]);
            queue.enqueue(packet[i]);
        }

        while (!queue.isEmpty()) {
            if (queue.dequeue() != stack.pop()) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) 
    {
        int[] packet1 = {1, 2, 3, 2, 1};
        int[] packet2 = {1, 2, 3, 4};
        int[] packet3 = {5, 5};

        System.out.println("Packet 1: " + isSymmetric(packet1));
        System.out.println("Packet 2: " + isSymmetric(packet2));
        System.out.println("Packet 3: " + isSymmetric(packet3));
    }
}
