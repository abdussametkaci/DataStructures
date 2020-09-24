/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLinkedList;

/**
 *
 * @author asus
 */
public class CLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    void addFirst(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }

        tail.nextNode = head;
        size++;
    }

    void addFirst(T newData) {
        addFirst(new Node<>(newData));
    }

    void addLast(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.nextNode = head;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
            tail.nextNode = head;
        }

        size++;
    }

    void addLast(T newData) {
        addLast(new Node<>(newData));
    }

    boolean addAfter(T search, T newData) {
        if (isEmpty()) {
            System.out.println("Empty list !");
            return false;
        } else {
            Node<T> temp = head;

            while (!temp.data.equals(search)) {
                temp = temp.nextNode;

                if (temp == head) {
                    return false;
                }
            }

            Node<T> newNode = new Node<>(newData);
            newNode.nextNode = temp.nextNode;
            temp.nextNode = newNode;

            if (temp == tail) {
                tail = newNode;
            }

            size++;
            return true;
        }
    }

    Node<T> remove(T search) {
        Node<T> removedNode = null;

        if (isEmpty()) {
            System.out.println("Empty list !");
        } else {
            if (head.data.equals(search) && size == 1) {
                removedNode = head;

                head = null;
                tail = null;

                size--;
            } else if (head.data.equals(search)) {
                removedNode = head;

                head = head.nextNode;
                tail.nextNode = head;

                size--;
            } else {
                Node<T> temp = head;

                for (int i = 1; i < size; i++) {
                    if (temp.nextNode.data.equals(search)) {
                        removedNode = temp.nextNode;

                        if (removedNode == tail) {
                            tail = temp;
                        }

                        temp.nextNode = temp.nextNode.nextNode;
                        size--;
                    }

                    temp = temp.nextNode;
                }
            }
        }

        return removedNode;
    }

    void print() {
        Node<T> temp = head;

        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(isEmpty() ? "Empty list !" : head.data);
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }
}
