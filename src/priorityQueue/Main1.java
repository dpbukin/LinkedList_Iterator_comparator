package priorityQueue;

public class Main1 {
    public static void main(String[] args) {
        priorityQueue<Integer> queue = new priorityQueue<Integer>();
        queue.add(30);
        queue.add(20);
        queue.add(40);
        queue.add(10);
        queue.add(25);
        queue.add(35);

        System.out.println("Original Queue:");
        queue.printHeapTree();

        // Удаляем элемент со значением 20
        int elementToRemove = 20;
        boolean removed = queue.remove(elementToRemove);

        if (removed) {
            System.out.println("\nElement " + elementToRemove + " removed successfully.");
        } else {
            System.out.println("\nElement " + elementToRemove + " not found in the queue.");
        }

        System.out.println("\nQueue after removal:");
        queue.printHeapTree();
    }
}
