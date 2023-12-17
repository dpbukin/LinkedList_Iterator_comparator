package heap;



public class MaxHeap<E extends Comparable<E>> extends AbstractHeap<E> {
    private Object[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MaxHeap() {
        this.heap = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        ensureCapacity();
        heap[size] = element;
        size++;
        heapifyUp();
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return (E) heap[0];
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && compare(heap[index], getParent(index)) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    private boolean hasParent(int i) {
        return i > 0;
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private Object getParent(int i) {
        return heap[parentIndex(i)];
    }

    private int compare(Object a, Object b) {
        return ((Comparable<E>) a).compareTo((E) b);
    }

    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            Object[] newHeap = new Object[2 * heap.length];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }


    public void printHeapTree() {
        printHeapTree(0, 0);
    }

    private void printHeapTree(int index, int level) {
        if (index < size) {
            printHeapTree(rightChildIndex(index), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            System.out.println(heap[index]);

            printHeapTree(leftChildIndex(index), level + 1);
        }
    }

    public void printArray() {
        System.out.print("Куча в виде массива: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


}