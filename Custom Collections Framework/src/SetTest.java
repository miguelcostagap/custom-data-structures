import Implementations.ArrayQueue;
import Implementations.TreeSet;

public class SetTest {
    public static void main(String[] args) {

        // ---> Set Tests <---

        TreeSet set = new TreeSet(3);

        set.getSize(); // should output 0

        set.add(2); // should output true msg
        set.add(2); // should output false msg
        set.add(6); // should output true msg
        set.add(6); // should output false msg
    }
}
