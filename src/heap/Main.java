package heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(40);
        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(35);
        maxHeap.add(50);

        // Выводим кучу в виде дерева
        System.out.println("Куча в виде дерева:");
        maxHeap.printHeapTree();

        // Проверка работы методов кучи
        System.out.println("Размер кучи: " + maxHeap.size());
        System.out.println("Максимальный элемент: " + maxHeap.peek());

        // Выводим массив для проверки свойства кучи
        maxHeap.printArray();
    }
}
