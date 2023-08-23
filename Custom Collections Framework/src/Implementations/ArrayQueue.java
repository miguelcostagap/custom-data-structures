package Implementations;

import Frameworks.Types.Queue;

public class ArrayQueue implements Queue {

    private int currentSize;
    private Object[] queue;
    private Object[] queueTemporary; // only used to copy elements so we can resize method
    private int queueSizeLimit;

    public ArrayQueue(int queueSize){

        queue = new Object[queueSize];
        queueTemporary = new Object[queueSize];
        queueSizeLimit = queueSize;

        // setting all values of the queue to null
        for(int i = 0; i < queueSize; i++){
            queue[i] = null;
            queueTemporary[i] = null;
        }
    }

    @Override
    public int getSize() {
        System.out.println(currentSize);
        return currentSize;
    }

    @Override
    public boolean add(Object data) {

        // ---> This method will give the queue a new priority item! <---

        // if it is full
        if(currentSize == queueSizeLimit){
            System.out.println("Sorry, the queue is at full capacity!\nYou will have to resize the queue!");
            return false;
        }

        // if there isn't anything yet...
        if(currentSize == 0){
            currentSize++;
            queue[0] = data;
            System.out.println("Your data is now our top priority!");
            return true;
        }

        // pass data to the next position
        for(int i = currentSize; i > 0; i--){
            queue[i] = queue[i-1];
        }

        // set new priority
        queue[0] = data;
        currentSize++;
        System.out.println("Your data is now our top priority!");
        return true;
    }

    @Override
    public boolean remove(Object data) {

        // ---> This method will remove ALL positions that match data <---

        // if there isn't anything yet...
        if(currentSize == 0){
            System.out.println("Your queue is empty!");
            return false;
        }

        boolean flag = false; // changes if it finds data in queue
        int sizeDiff = currentSize; // so we show how many elements we have removed

        for(int i = currentSize -1; i >= 0; i--){
            if(queue[i] == data){
                currentSize--;
                for(int j = i; j < currentSize; j++){
                    queue[j] = queue[j + 1];
                }
                flag = true;
                queue[currentSize] = null;
            }
        }

        System.out.println(flag ? ("We have successfully removed " + (sizeDiff-currentSize) + " elements matching that data!") : "That data is not in queue!");
        return flag;
    }

    @Override
    public boolean contains(Object data) {

        // if there isn't anything yet...if the array is long we save the time to search it
        if(currentSize == 0){
            System.out.println("Your queue is empty!");
            return false;
        }

        for(int i = 0; i <= currentSize; i++){
            if(queue[i].equals(data)){
                System.out.println("Yes, that data is queue!");
                return true;
            }
        }
        System.out.println("No, that data is not in queue!");
        return false;
    }

    @Override
    public boolean isEmpty() {
        System.out.println((currentSize == 0) ? "Yes, the queue ie empty!" : "No, the queue is not empty!");
        return currentSize == 0;
    }

    @Override
    public void clear() {

        currentSize = 0;

        for(int i = 0; i <= currentSize; i++){
            queue[i] = null;
        }
    }

    @Override
    public boolean offer(Object toAdd) {

        // This method will give a new item at the end of the queue!

        // if it is full
        if(currentSize == queueSizeLimit){
            System.out.println("Sorry, the queue is at full capacity!\nYou will have to resize the queue!");
            return false;
        }

        queue[currentSize] = toAdd;
        currentSize++;
        System.out.println("Your data has been added to the queue!");
        return true;
    }

    @Override
    public Object peek() {
        System.out.println((currentSize == 0) ? "The queue is empty!" : queue[0].toString());
        return queue[0];
    }

    @Override
    public Object poll() {

        // if there isn't anything yet...if the array is long we save the time to search it
        if(currentSize == 0){
            System.out.println("Your queue is empty!");
            return null;
        }

        // save the Object we want to poll in variable
        Object poll = queue[0];

        // pass data to the next position
        for(int i = 0; i < currentSize - 1; i++){
            queue[i] = queue[i+1];
        }
        currentSize--;
        System.out.println("The queue has been updated and the data " + poll.toString() + " has been removed!");
        return poll;
    }

    public void resizeQueue(int newSize){

        if(currentSize > newSize){
            System.out.println("You still have data to remove from queue!\nYou can use poll to remove data from the queue!");
        }else{

            for(int i = 0; i <= queueSizeLimit - 1; i++){
                queueTemporary[i] = queue[i];
            }

            queue = new Object[newSize];
            for(int i = 0; i <= queueSizeLimit - 1; i++){
                queue[i] = queueTemporary[i];
            }
            queueSizeLimit = newSize;
            System.out.println("You have successfully resizes your queue!");
        }
    }
}
