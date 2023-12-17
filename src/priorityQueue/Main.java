package priorityQueue;

public class Main {
    public static void main(String[] args) {
        priorityQueue<Integer> queue1 = new priorityQueue<Integer>();
        queue1.add(30);
        queue1.add(20);
        queue1.add(40);
        queue1.add(50);

        priorityQueue<Integer> queue2 = new priorityQueue<Integer>();
        queue2.add(10);
        queue2.add(25);
        queue2.add(35);

        // Выводим первую очередь
        System.out.println("Queue 1:");
        queue1.printHeapTree();

        // Выводим максимальный элемент первой очереди
        System.out.println("\nMax element in Queue 1: " + queue1.peek());

        // Выводим вторую очередь
        System.out.println("\nQueue 2:");
        queue2.printHeapTree();

        // Выводим максимальный элемент второй очереди
        System.out.println("\nMax element in Queue 2: " + queue2.peek());

        // Объединяем очереди
        queue1.merge(queue2);

        // Выводим объединенную очередь
        System.out.println("\nMerged Queue:");
        queue1.printHeapTree();

        // Выводим максимальный элемент объединенной очереди
        System.out.println("\nMax element in Merged Queue: " + queue1.peek());

        // Выводим массив для проверки свойства кучи
        queue1.printArray();
    }
}
