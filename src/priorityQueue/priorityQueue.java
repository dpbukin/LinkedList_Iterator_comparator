package priorityQueue;

import java.util.PriorityQueue;

public class priorityQueue<E extends Comparable<E>> extends AbstractQueue<E> {

    private Object[] elements; // Массив для хранения элементов кучи
    private int size;          // Текущий размер кучи
    private static final int DEFAULT_CAPACITY = 10; // Начальная емкость массива

    public priorityQueue() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Метод, возвращающий текущий размер кучи
    @Override
    public int size() {
        return size;
    }

    // Метод для добавления элемента в кучу
    @Override
    public void add(E element) {
        ensureCapacity();
        elements[size] = element;
        size++;
        heapifyUp();
    }

    // Метод для возврата максимального элемента без удаления
    @Override
    public E peek() {
        if (size() == 0) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        return (E) elements[0];
    }

    // Метод для извлечения и удаления максимального элемента
    @Override
    public E poll() {
        if (size() == 0) {
            throw new IllegalStateException("PriorityQueue is empty");
        }

        E removedElement = (E) elements[0];
        int lastIndex = size() - 1;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        size--;

        heapifyDown();

        return removedElement;
    }


    // Метод для восстановления свойств кучи при добавлении элемента
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && compare(elements[index], getParent(index)) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    // Метод для восстановления свойств кучи при добавлении элемента
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && compare(elements[rightChildIndex(index)], elements[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex(index);
            }

            if (compare(elements[index], elements[largerChildIndex]) > 0) {
                break;
            } else {
                swap(index, largerChildIndex);
            }

            index = largerChildIndex;
        }
    }




    // Проверяет, имеет ли элемент родителя в куче
    private boolean hasParent(int i) {
        return i > 0;
    }

    // Возвращает индекс родителя для элемента
    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    // Проверяет, имеет ли элемент левого потомка в куче
    private boolean hasLeftChild(int i) {
        return leftChildIndex(i) < size;
    }

    // Возвращает индекс левого потомка для элемента
    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    // Проверяет, имеет ли элемент правого потомка в куче
    private boolean hasRightChild(int i) {
        return rightChildIndex(i) < size;
    }

    // Возвращает индекс правого потомка для элемента
    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    // Возвращает родителя для элемента
    private E getParent(int i) {
        return (E) elements[parentIndex(i)];
    }

    // Сравнивает два элемента для управления порядком в куче
    private int compare(Object a, Object b) {
        return ((Comparable<E>) a).compareTo((E) b);
    }

    // Меняет местами два элемента в куче
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    // Обеспечивает достаточную емкость массива для кучи
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
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

            System.out.println(elements[index]);

            printHeapTree(leftChildIndex(index), level + 1);
        }
    }

    public void printArray() {
        System.out.print("Heap array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

// 5 задание
    public void merge(priorityQueue<E> otherQueue) {
        // Создаем новый массив, достаточно большой, чтобы вместить обе очереди
        Object[] newElements = new Object[size + otherQueue.size];

        // Копируем элементы из текущей очереди в новый массив
        System.arraycopy(elements, 0, newElements, 0, size);

        // Копируем элементы из другой очереди в новый массив
        System.arraycopy(otherQueue.elements, 0, newElements, size, otherQueue.size);

        // Присваиваем новый массив в качестве элементов текущей очереди
        elements = newElements;

        // Обновляем размер текущей очереди
        size = size + otherQueue.size;

        // Выполняем heapifyDown для каждого элемента, начиная с последнего
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown0(i);
        }
    }

    //Для задания 5
    private void heapifyDown0(int index) {
        int currentIndex = index;
        while (hasLeftChild(currentIndex)) {
            int largerChildIndex = leftChildIndex(currentIndex);
            if (hasRightChild(currentIndex) && compare(elements[rightChildIndex(currentIndex)], elements[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex(currentIndex);
            }

            if (compare(elements[currentIndex], elements[largerChildIndex]) > 0) {
                break;
            } else {
                swap(currentIndex, largerChildIndex);
            }

            currentIndex = largerChildIndex;
        }
    }



    //задание 15
    public boolean remove(E element) {
        int index = -1;

        // Находим индекс элемента в куче
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                index = i;
                break;
            }
        }

        // Если элемент не найден, возвращаем false
        if (index == -1) {
            return false;
        }

        // Если удаляем не последний элемент
        if (index != size - 1) {
            elements[index] = elements[size - 1];
            elements[size - 1] = null;

            // Выполняем heapifyDown, чтобы восстановить свойства кучи
            heapifyDown1(index);
        } else {
            // Если удаляем последний элемент, просто удаляем его
            elements[index] = null;
        }

        size--;

        return true;
    }

// для задания 15
    private void heapifyDown1(int index) {
        int currentIndex = index;
        while (hasLeftChild(currentIndex)) {
            int largerChildIndex = leftChildIndex(currentIndex);
            if (hasRightChild(currentIndex) && compare(elements[rightChildIndex(currentIndex)], elements[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex(currentIndex);
            }

            if (compare(elements[currentIndex], elements[largerChildIndex]) > 0) {
                break;
            } else {
                swap(currentIndex, largerChildIndex);
            }

            currentIndex = largerChildIndex;
        }
    }

}