package Implementations;

import Frameworks.Types.Set;

public class TreeSet implements Set {
    private int currentSize;
    private Object[] treeSet;
    private Object[] setTemporary; // only used to copy elements so we can resize method
    private int setSizeLimit;

    public TreeSet(int setSize) {
        treeSet = new Object[setSize];
        setTemporary = new Object[setSize];
        setSizeLimit = setSize;

        // setting all values of the queue to null
        for(int i = 0; i < setSize; i++){
            treeSet[i] = null;
            setTemporary[i] = null;
        }
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean add(Object data) {

        // ---> This method will give the queue a new priority item! <---

        // if it is full
        if(currentSize == setSizeLimit){
            System.out.println("Sorry, the set is at full capacity!\nYou will have to resize the set!");
            return false;
        }

        // if there isn't anything yet...
        if(currentSize == 0){
            currentSize++;
            treeSet[0] = data;
            System.out.println("Your data is now our top priority!");
            return true;
        }

        // check if data exists
        for(int i = 0; i <= setSizeLimit - 1; i++){
            if(treeSet[i] == data) {
                System.out.println("That data already exists!");
                return false;
            }
        }
        // pass data to the next position
        for(int i = currentSize; i > 0; i--){
               treeSet[i] = treeSet[i - 1];
        }
        treeSet[0] = data;
        currentSize++;
        System.out.println("Your data is now our top priority!");
        return true;
    }

    @Override
    public boolean remove(Object data) {

        // ---> This method will remove ALL positions that match data <---

        // if there isn't anything yet...
        if(currentSize == 0){
            System.out.println("Your set is empty!");
            return false;
        }

        boolean flag = false; // changes if it finds data in the set
        int sizeDiff = currentSize; // so we show how many elements we have removed

        for(int i = currentSize -1; i >= 0; i--){
            if(treeSet[i] == data){
                currentSize--;
                for(int j = i; j < currentSize; j++){
                    treeSet[j] = treeSet[j + 1];
                }
                flag = true;
                treeSet[currentSize] = null;
            }
        }

        System.out.println(flag ? ("We have successfully removed " + (sizeDiff-currentSize) + " elements matching that data!") : "That data is not in the set!");
        return flag;
    }

    @Override
    public boolean contains(Object data) {

        // if there isn't anything yet...if the array is long we save the time to search it
        if(currentSize == 0){
            System.out.println("Your set is empty!");
            return false;
        }

        for(int i = 0; i <= currentSize; i++){
            if(treeSet[i].equals(data)){
                System.out.println("Yes, that data is in the set!");
                return true;
            }
        }
        System.out.println("No, that data is not in the set!");
        return false;    }

    @Override
    public boolean isEmpty() {
        System.out.println((currentSize == 0) ? "Yes, the set ie empty!" : "No, the set is not empty!");
        return currentSize == 0;
    }

    @Override
    public void clear() {
        currentSize = 0;

        for(int i = 0; i <= currentSize; i++){
            treeSet[i] = null;
        }
    }
    public void resizeSet(int newSize){

        if(currentSize > newSize){
            System.out.println("You still have data to remove from set!\nYou can use poll to remove data from the set!");
        }else{

            for(int i = 0; i <= setSizeLimit - 1; i++){
                setTemporary[i] = treeSet[i];
            }

            treeSet = new Object[newSize];
            for(int i = 0; i <= setSizeLimit - 1; i++){
                treeSet[i] = setTemporary[i];
            }
            setSizeLimit = newSize;
            System.out.println("You have successfully resized your set!");
        }
    }
}
