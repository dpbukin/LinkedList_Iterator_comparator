package twoLinkedList.laba_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(new Minion("Dave", 2, 2, "yellow"));
        list.addFirst(new Minion("Han", 2, 5, "yellow"));
        list.addFirst(new Minion("Van", 1, 45, "blue"));
        list.addFirst(new Minion("Rik", 4, 3, "blue"));
        list.addLast(new Minion("Lin", 2, 3, "yellow"));
        list.addLast(new Minion("Tom", 3, 4, "green"));
        list.addFirst(new Minion("Jerry", 1, 1, "brown"));
        list.addLast(new Minion("Bob", 2, 3, "red"));
        list.addFirst(new Minion("Alice", 4, 2, "purple"));
        list.addLast(new Minion("Eve", 1, 5, "pink"));

        // Вывод размера списка
        System.out.println("Размер списка: " + list.size());

        System.out.println("Вывод списка с помощью итератора");
        Iterator<Minion> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Удаление последнего и первого элементов
        list.removeLast();
        list.removeFirst();

        // Вывод списка после удалений
        System.out.println("\nПросмотр списка после удалений:");
        list.print();

        // Добавление индексу
        list.addByIndex(new Minion("Kih", 1, 21, "red"), 0);
        list.addByIndex(new Minion("Kil", 2, 12, "red"), 3);
        list.addByIndex(new Minion("Pom", 4, 2, "red"), 5);

        // Вывод списка после добавлений по индексу
        System.out.println("\nПросмотр списка после добавлений по индексу:");
        list.print();

        // Удаление по индексу
        list.removeByIndex(0);

        // Вывод списка после удаления по индексу
        System.out.println("\nПросмотр списка после удаления по индексу:");
        list.print();

        // Редактирование по индексу и вывод
        list.editByIndex(2, new Minion("Hun", 2, 2, "yellow"));
        System.out.println("\nПросмотр списка после редактирования по индексу:");
        list.print();

        Minion.AgeComparator ageComparator = new Minion.AgeComparator();
        Minion.EyesComparator eyesComparator = new Minion.EyesComparator();
        Minion.NameComparator nameComparator = new  Minion.NameComparator();
        Minion.MixComparator mixComparator = new Minion.MixComparator();
        Minion.ColorComparator colorComparator = new Minion.ColorComparator();

        list.sortByComparator(ageComparator);
        System.out.println("\nОтсортированный список миньонов по возрасту:");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.sortByComparator(nameComparator);
        System.out.println("\nОтсортированный список миньонов по имени:");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.sortByComparator(eyesComparator);
        System.out.println("\nОтсортированный список миньонов по количеству глаз:");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.sortByComparator(mixComparator);
        System.out.println("\nОтсортированный список миньонов замиксованный компоратор по глазам, имени, возрасту:");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.sortByComparator(colorComparator);
        System.out.println("\nОтсортированный список миньонов по цвету в обратном алфавитном");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
