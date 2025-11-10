
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public boolean empty() { return head == null; }

    public void insert(T val) {
        Node<T> newNode = new Node<>(val);
        if (head == null) head = newNode;
        else {
            Node<T> temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    public void findFirst() { current = head; }

    public void findNext() { if (current != null) current = current.next; }

    public boolean last() { return current == null || current.next == null; }

    public T retrieve() { return (current == null) ? null : current.data; }

    public void remove() {
        if (head == null || current == null) return;
        if (current == head) {
            head = head.next;
            current = head;
            return;
        }
        Node<T> prev = head;
        while (prev.next != current) prev = prev.next;
        prev.next = current.next;
        current = prev.next;
    }
}
