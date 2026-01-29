package Q2_SinglyList;

public class SinglyAssignment<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // --- Question 5: Concatenate two linked lists ---
    public void concatenate(SinglyAssignment<E> otherList) {
        if (otherList.isEmpty()) return;
        if (this.isEmpty()) {
            this.head = otherList.head;
            this.tail = otherList.tail;
        } else {
            this.tail.next = otherList.head;
            this.tail = otherList.tail;
        }
        this.size += otherList.size;
    }

    // --- Question 7: Search for element and return its position ---
    public int search(E target) {
        Node<E> temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data.equals(target)) return pos;
            temp = temp.next;
            pos++;
        }
        return -1; // Not found
    }

    // --- Question 9: Remove at specific position ---
    public E removeAt(int position) {
        if (position < 1 || position > size) return null;
        if (position == 1) return removeFirst();

        Node<E> prev = head;
        for (int i = 1; i < position - 1; i++) {
            prev = prev.next;
        }
        Node<E> target = prev.next;
        E data = target.data;
        prev.next = target.next;
        if (prev.next == null) tail = prev;
        size--;
        return data;
    }

    private E removeFirst() {
        if (head == null) return null;
        E data = head.data;
        head = head.next;
        size--;
        if (size == 0) tail = null;
        return data;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data, null);
        if (head == null) head = newNode;
        else tail.next = newNode;
        tail = newNode;
        size++;
    }

    public boolean isEmpty() { return size == 0; }

    public void display() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data, Node<E> next) { this.data = data; this.next = next; }
    }

    public static void main(String[] args) {
        SinglyAssignment<Integer> list1 = new SinglyAssignment<>();
        list1.addLast(10); list1.addLast(20); list1.addLast(30);

        System.out.print("List 1: "); list1.display();
        System.out.println("Position of 20: " + list1.search(20));

        list1.removeAt(2);
        System.out.print("After remove position 2: "); list1.display();
    }
}