import Implementations.ArrayQueue;

public class QueueTest {

    public static void main(String[] args) {

        // ---> Queue Tests <---

        ArrayQueue queue = new ArrayQueue(3);

        queue.getSize(); // should output 0

        queue.add(2); // should output true msg
        queue.add(3); // should output true msg
        queue.add(6); // should output true msg
        queue.add(7); // should output false msg

        queue.getSize(); // should output 3

        queue.remove(6); // should output true msg
        queue.remove(6); // should output false msg

        queue.getSize(); // should output 2

        queue.add(45); // should output true msg

        queue.peek(); // should output 45

        queue.remove(45); // should output true msg

        queue.offer(45); // should output true msg

        queue.peek(); // should output 3

        queue.poll(); // should remove 3

        queue.peek(); // should output 2

        queue.getSize(); // should output 2

        queue.resizeQueue(4); // should output true msg

        queue.offer(78); // should output true msg
        queue.offer(88); // should output true msg

        queue.getSize(); // should output 4

        queue.clear();

        queue.peek(); // should output empty

    }

}
