package twoLinkedList.laba_1;

import java.util.*;

public class LinkedList implements Iterable<Minion>{
    Node head = null;
    Node tail = null;


    @Override
    public Iterator<Minion> iterator() {
        return new LinkedListIterator();
    }


    public void sortByComparator(Comparator<Minion> comparator) {
        List<Minion> minionList = new ArrayList<>();
        for (Minion minion : this) {
            minionList.add(minion);
        }

        Collections.sort(minionList, comparator);

        Node current = head;
        for (Minion minion : minionList) {
            current.minion = minion;
            current = current.next;
        }
    }


    private class LinkedListIterator implements Iterator<Minion> {
        private Node current = head;
        private Node lastReturned = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Minion next() {
            Minion minion = current.minion;
            current = current.next;
            return minion;
        }
    }

    public Minion getByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }

        Iterator<Minion> iterator = iterator();
        int currentIndex = 0;

        while (iterator.hasNext() && currentIndex != index) {
            iterator.next();
            currentIndex++;
        }

        return iterator.next();
    }


    //Проверка пустой ли список
    private boolean isEmpty() {
        return head == null;
    }

    //Длинна списка
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    //Вставить в начало списка
    public void addFirst(Minion minion) {
        // Если список пустой, до добавляем запись и указываем null для головы и хвоста
        if (isEmpty()) {
            var node = new Node(minion, null, null);
            head = node;
            tail = node;
        } else {
            //Создавая узел, мы сразу записываем в поле next текущее значение this.head— текущую голову.
            var node = new Node(minion, null, head);
            //Ссылка на новую запись для головы
            head.previous = node;
            head = node;
        }
    }

    //Вставка записи в конец списка
    public void addLast(Minion minion) {
        if (tail == null) {
            var node = new Node(minion, null, null);
            tail = node;
            head = node;
        } else {
            var node = new Node(minion, tail, null);
            tail.next = node;
            tail = node;
        }
    }

    //Удаление первой записи
    public Minion removeFirst() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Список пуст");
        }

        //Если список не пустой, записываем в result для возврата
        var result = head.minion;

        //Еслт в списке всего одина запись, то нам достаточно обнулить ее
        if (head == tail) {
            head = null;
            tail = null;

            //Удаление певрой записи и обновление головы
        } else {
            head = head.next;
            head.previous = null;
        }

        return result;
    }

    //Удаление посленей записи
    public Minion removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Список пуст");
        }

        var result = head.minion;

        if (head == tail) {
            head = null;
            tail = null;

        } else {
            tail = tail.previous;
            tail.next = null;
        }

        return result;
    }

    //Вставка записи в список по индексу
    public void addByIndex(Minion minion, int index) {
        Node node = head;
        int currentIndex = 0;

        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным");
        }
        //Если введеный индекс равен "0", то вызывам функцию добавления для начала
        if (index == 0) {
            addFirst(minion);

        } else {
            //Проходим по индексам списка
            while (node != null && currentIndex != index) {
                node = node.next;
                currentIndex++;
            }
            //Если не находтся индекс для добавления между,
            // то добавление срабатывает метод для доб. в конец списка
            if (node == null) {
                addLast(minion);

                //Если предыдущие условия не сработали, до добавляем запись между записями и обновляем голову и хвост
            } else {
                Node node1 = new Node(minion);

                node.previous.next = node1;
                node1.previous = node.previous;
                node.previous = node1;
                node1.next = node;
            }
        }
    }


    public void removeByIndex(int index) {
        //Если элемента по индексу нет, то выкинится ошибка
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }

        if (index == 0) {
            removeFirst();

        } else {
            Node node = head;
            int currentIndex = 0;

            while (node != null && currentIndex != index) {
                node = node.next;
                currentIndex++;
            }


            if (node == null) {
                throw new IndexOutOfBoundsException("Индекс за пределами списка");
            }

            if (node.next != null) {
                node.next.previous = node.previous;
            }

            if (node.previous != null) {
                node.previous.next = node.next;
            }
        }
    }
    public void editByIndex(int index, Minion minion) {
        // Проверка на допустимый диапазон введеного индекса
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Некорректный индекс.");
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex != index) {
            current = current.next;
            currentIndex++;
        }

        if (current != null) {
            current.minion = minion;
        }
    }

    //Поиск элемента в списке
    public int indexOf(Minion minion) {
        Iterator<Minion> iterator = iterator();
        int index = 0;

        while (iterator.hasNext()) {
            if (iterator.next().equals(minion)) {
                return index;
            }
            index++;
        }

        return -1; // Элемент не найден
    }

    //Проверка на наличие элемента
    public boolean contains(Minion minion) {
        return indexOf(minion) != -1;
    }

    public void print () {
        Node node = head;
        while (node != null) {
            System.out.println(node.minion);
            node = node.next;
        }
    }
}
