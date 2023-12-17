package heap;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHeap<E extends Comparable<E>> {

    public abstract int size();

    public abstract void add(E element);

    public abstract E peek();
}
