import java.util.NoSuchElementException;

public class LinkedLists {
    private static class Node{
        public Node next;
        private final int value;

        public  Node(int value){
            this.value = value;
        }


    }
    private Node first;
    private Node last;

    public void addLast(int item){
        Node node = new Node(item);

        if(isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }
    public void  addFirst(int item){
        Node node = new Node(item);
        if(isEmpty()) {
            first = last = node;
        }
        else{
            node.next = first;
            first = node;
        }

    }

    public  int indexOf(int item){
        int index = 0;
        var current = first;
        while (current != null){
            if(current.value == item) return index;
            current= current.next;
            index++;
        }
        return -1;
    }

    public  boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void  removeFirst(){

        if(isEmpty()) throw new NoSuchElementException();

        if(first == last){
            first = last= null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
    }
    public void insertAt(int item, int index) {
        var node = new Node(item);

        if (index == 0) {
            addFirst(item);
            return;
        }

        var current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == null) throw new NoSuchElementException();
        }

        node.next = current.next;
        current.next = node;

        if (current == last) {
            last = node;
        }
    }

    public void  removeLast(){
        // [10 -> 20 -> 30]
        // last/Previous -> 20

        if(isEmpty()) throw new NoSuchElementException();

        if(first == last){
            first = last= null;
            return;
        }
        /*
        var previous = getPrevious(last)
        last = previous;
        last.next = null;
         */

        last = getPrevious(last);
        assert last != null;
        last.next = null;

    }
    public void removeAt(int index) {
        if (isEmpty()) throw new NoSuchElementException();

        if (index == 0) {
            removeFirst();
            return;
        }

        var current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == null) throw new NoSuchElementException();
        }

        if (current.next == last) {
            removeLast();
            return;
        }

        current.next = current.next.next;
    }


    private Node getPrevious(Node node){

        var current = first;
        while (current != null){
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }
    private boolean isEmpty(){
        return  first == null;
    }
    public static void main(String[] args) {

        var list = new LinkedLists();
        list.addLast(10);
        list.addLast(30);
        list.addLast(50);
        list.addLast(20);
        list.removeFirst();
        list.removeLast();
        System.out.println(list.indexOf(100));
        System.out.println(list.contains(30));
    }

}