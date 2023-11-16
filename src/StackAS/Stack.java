package StackAS;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    //Stack - LIFO т.е. последний пришел, первый вышел. Тоже самое, что и односвязанный список.
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    //Добавление элемента в стек
    public void push(T item) {
        ensureCapacity();
        array[size++] = item;
    }
    //удаление элемента из стека
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        T item = (T) array[--size];
        array[size] = null; // Помощь сборщику мусора
        return item;
    }
    //чтение элемента из стека
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return (T) array[size - 1];
    }

    //Проверка на пустоту списка
    public boolean isEmpty() {
        return size == 0;
    }

    //Расширение начального размера стека
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            //Создаем новый стек копируя элементы
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }

    //Класс итератор для итерации по элементам коллекции
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = size - 1;

            //Переопределяем метод "следующего элемента"
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            //Вытаскивание элементов из стека
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Больше нет элементов в стеке");
                }
                return (T) array[index--];
            }
        };
    }
}

