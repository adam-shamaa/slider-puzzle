import java.util.Iterator;

public class Stack < Item > implements Iterable < Item > {
    private Node head;

    private class Node {
        Node next;
        Item item;

        public Node(Item item, Node next) {
            this.next = next;
            this.item = item;
        }
    }

    public void push(Item item) {
        head = new Node(item, head);
    }

    public Item pop() {
        if (head == null) throw new IllegalArgumentException("Empty stack");
        Item item = head.item;
        head = head.next;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Iterator < Item > iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator < Item > {
        Node current = head;

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