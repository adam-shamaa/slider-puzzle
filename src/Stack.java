import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private class Node{
        Node next;
        Item item;

        public Node(Item item, Node next) {
            this.next = next;
            this.item = item;
        }
    }
    
    private Node first;

    public void push(Item item) {
        first = new Node(item, first);
    }

    public Item pop() {
        if (first == null) {
            throw new IllegalArgumentException("Empty stack");
        }
        Item item = first.item;
        first = first.next;
        return item;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
