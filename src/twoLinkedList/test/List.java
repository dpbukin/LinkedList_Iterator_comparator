package twoLinkedList.test;

public class List {
    private Node head;
    private Node tail;

    public List(){
        head = null;
        tail = null;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public void addFirst(int data){
        Node temp = new Node(data);

        if (isEmpty()){
            tail = temp;
        }
        else {
            head.prev = temp;
        }

        temp.next = head;
        head = temp;
    }

    public void addLast(int data){
        Node temp = new Node(data);

        if (isEmpty()){
            head = temp;
        }
        else {
            tail.next = temp;
        }

        temp.prev = tail;
        tail = temp;
    }

    public void addByIndex(int data, int index){
        Node cur = head;
        int c = 0;

        while (cur != null && c != index){
            cur = cur.next;
            c++;
        }

        Node temp  = new Node(data);

        cur.prev.next = temp;
        temp.prev = cur.prev;
        cur.prev = temp;
        temp.next = cur;
    }


    public void removeFirst(){
        if(head.next ==null){
            tail = null;
        }

        else {
            head.next.prev = null;
        }

        head = head.next;
    }

    public void removeLast(){
        if(head.next ==null){
            head = null;
        }

        else {
            tail.prev.next = null;
        }

        tail = tail.prev;
    }

    public void removeAt(int key){
        Node cur = head;

        while (cur.data != key){
            cur = cur.next;

            if (cur == null){
                return;
            }

            if (cur == head) {
                removeFirst();
            }
            else{
                cur.prev.next = cur.next;
            }

            if (cur == tail){
                removeLast();
            }
            else {
                cur.next.prev = cur.prev;
            }

        }
    }

    public void print(){
        Node temp = head;

        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}
