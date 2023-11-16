package twoLinkedList.test;

public class Main {
    public static void main(String[] args) {

        List list = new List();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addByIndex(5, 2);

        list.print();

        System.out.println();

//        list.removeFirst();
//        list.print();
//
//        System.out.println();
//
//        list.removeLast();
//        list.print();

        list.removeAt(1);

        list.print();



    }
}
