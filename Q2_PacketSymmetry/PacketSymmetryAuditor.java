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
}
