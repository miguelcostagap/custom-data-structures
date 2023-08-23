package Frameworks.Types;

import Frameworks.Collection;

public interface List extends Collection {

    public abstract Object getData(int index);  // → Should return an object of the list when given an int index.

    public abstract int indexOf(Object data);  // → Should return the index of a given object

    public abstract List listBetween(int from, int to);  // → Should return a new list given the indexes: int fromIndex, int toIndex

}
