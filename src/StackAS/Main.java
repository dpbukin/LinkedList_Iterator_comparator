package StackAS;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= 10; i++){
            stack.push(i);
        }

        System.out.println("Элементы стека с использованием итератора:");
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Извлечение элементов из стека
        System.out.println("\n Извлечение элементов из стека:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
