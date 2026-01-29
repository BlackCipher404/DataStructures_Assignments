package Q4_CircularList;

public class CircularAssignment<E> {
    Node<E> tail = null;
    int size = 0;

    // --- سؤال 13: إضافة في موقع محدد ---
    public void insertAt(int pos, E data) {
        if (pos < 1 || pos > size + 1) return;
        if (pos == 1) { addFirst(data); return; }

        Node<E> temp = tail.next;
        for (int i = 1; i < pos - 1; i++) temp = temp.next;

        Node<E> newNode = new Node<>(data, temp.next);
        temp.next = newNode;
        if (temp == tail) tail = newNode;
        size++;
    }

    // --- سؤال 15: البحث عن عنصر ---
    public boolean search(E target) {
        if (tail == null) return false;
        Node<E> temp = tail.next;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(target)) return true;
            temp = temp.next;
        }
        return false;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data, null);
        if (tail == null) {
            tail = newNode;
            newNode.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E d, Node<E> n) { data = d; next = n; }
    }
}