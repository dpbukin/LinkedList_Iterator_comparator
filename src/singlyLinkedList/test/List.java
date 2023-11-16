package singlyLinkedList.test;

import java.lang.reflect.WildcardType;
import java.util.WeakHashMap;

public class List {

    private LinkList head;

    public List(LinkList head) {
        this.head = head;
    }

    public List(){
        head = null;
    }

    private boolean isEmpty(){
        return head == null;
    }

    //Добавление ссылками
    public void add(int data){
        LinkList temp = new LinkList(data);
        temp.next = head;
        head = temp;
    }

    //Удаление (простое)
    public void remove(){
        head = head.next;
    }


    //Удаление элемента по ключу
    public void removeAt(int key){
        LinkList cur = head;
        LinkList prev = head;

        while (cur.data != key){
            if(isEmpty()){
                System.out.println("List is empty");
                return;
            }
            else {
                prev = cur;
                cur = cur.next;
            }

            if (cur == head){
                head = head.next;
            }
            else {
                prev.next = cur.next;
            }
        }
    }

    //Поиск позиции элемента по ключу
    public int find(int key){
        LinkList temp = head;
        int c = 0; //Индекс позиции ключа

        while (temp != null){
            if (temp.data == key){
                return c;
            }

            temp = temp.next;
            c++;
        }
        return -1;
    }


    //Отображение листа в выводе
    public void print(){
        LinkList temp = head;

        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
