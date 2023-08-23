import Implementations.LinkedList;

public class ListTest {
    public static void main(String[] args) {

        // ---> List Tests <---

        LinkedList list = new LinkedList();

        list.clear(); // should output that list is already empty

        list.isEmpty(); // should output true

        list.add(12); // should output true
        list.add(12); // should output true
        list.add(15); // should output true
        list.add(18); // should output true
        list.add(19); // should output true
        list.add(19); // should output true


        list.contains(13); // should output false
        list.contains(12); // should output true
        list.contains(18); // should output true

        list.isEmpty(); // should output false

        list.getSize(); // should output 6

        list.remove(19); // should output true   ??? it runs the method one more time after removing everything, showing an unnecessary message
        list.getSize(); // should output 4

        list.getData(3); // should output 18
        list.getData(0); // should output 12
        list.getData(1); // should output 12

        list.indexOf(18); // should output 3
        list.indexOf(188); // should output that doesn t exist


        list.clear(); // should clear list
        list.getSize(); // should be 0 now

    }
}