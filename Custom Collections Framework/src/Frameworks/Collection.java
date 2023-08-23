package Frameworks;

public interface Collection {

    public abstract int getSize();  // → Should return an int representing the size of the collection

    public abstract boolean add(Object data);  // → Should return a boolean representing if the add was successful (add element to end of list)

    public abstract boolean remove(Object data);  // → Should return a boolean representing if the remove was successful , and remove the specific element

    public abstract boolean contains(Object data);  // → Should return a boolean representing if the collection contains that object

    public abstract boolean isEmpty();  // → Should return a boolean representing if the collection is empty or not

    public abstract void clear();  // → Should clear the collection

}
