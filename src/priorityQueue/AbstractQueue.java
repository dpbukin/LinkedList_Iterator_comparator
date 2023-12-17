package priorityQueue;

public abstract class AbstractQueue<E extends Comparable<E>> {

    public abstract int size();

    public abstract void add(E element);

    public abstract E peek();

    public abstract E poll();
}
