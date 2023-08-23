package Frameworks.Types;

import Frameworks.Collection;

public interface Queue extends Collection {

    public abstract boolean offer(Object toAdd);    // offer → Should return a boolean representing if the operation was successful, it should add an object to the Queue

    public abstract Object peek();    // peek → Should return the object at the head of the queue without removing it

    public abstract Object poll();    // poll → Should return the object of the head of the queue, removing it

}
