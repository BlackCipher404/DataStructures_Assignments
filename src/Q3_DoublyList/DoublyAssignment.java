package Q3_DoublyList;

public class DoublyAssignment<E> {
    Node<E> head, tail;
    int size = 0;

    // --- سؤال 11: طباعة القائمة بالعكس ---
    public void displayReverse() {
        Node<E> temp = tail;
        System.out.print("Tail -> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Head");
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data, tail, null);
        if (tail != null) tail.next = newNode;
        tail = newNode;
        if (head == null) head = newNode;
        size++;
    }

    private static class Node<E> {
        E data;
        Node<E> prev, next;
        Node(E d, Node<E> p, Node<E> n) { data = d; prev = p; next = n; }
    }

    public static void main(String[] args) {
        DoublyAssignment<Integer> list = new DoublyAssignment<>();
        list.addLast(1); list.addLast(2); list.addLast(3);
        System.out.println("Reverse Display:");
        list.displayReverse();
    }
}