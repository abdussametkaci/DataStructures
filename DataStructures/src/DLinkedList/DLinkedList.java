/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLinkedList;

/**
 *
 * @author asus
 */
public class DLinkedList<T> {

    private Node<T> head;
    private int size;

    void addFirst(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.nextNode = head;
            head.prevNode = newNode;

            head = newNode;
        }

        size++;
    }

    void addFirst(T newData) {
        addFirst(new Node<>(newData));
    }

    void addLast(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> temp = head;

            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }

            newNode.prevNode = temp;
            temp.nextNode = newNode;
        }

        size++;
    }

    void addLast(T newData) {
        addLast(new Node<>(newData));
    }

    boolean addAfter(T search, T newData) {
        if (isEmpty()) {
            System.out.println("Empty list !");
        } else {
            Node<T> temp = head;

            while (temp != null && !temp.data.equals(search)) {
                temp = temp.nextNode;
            }

            if (temp != null) {
                Node<T> newNode = new Node<>(newData);

                newNode.nextNode = temp.nextNode;
                newNode.prevNode = temp;

                if (temp.nextNode != null) {
                    temp.nextNode.prevNode = newNode;
                }
                temp.nextNode = newNode;

                size++;
                return true;
            }
        }
        return false;
    }

    Node<T> remove(T data) {
        Node<T> removedNode = null;

        if (isEmpty()) {
            System.out.println("Empty list !");
        } else {

            if (head.data.equals(data)) {
                size--;
                removedNode = head;

                head = head.nextNode;
                if (head != null) {
                    head.prevNode = null;
                }
            } else {
                Node<T> temp = head.nextNode;

                while (temp != null && !temp.data.equals(data)) {
                    temp = temp.nextNode;
                }

                if (temp != null) {
                    size--;
                    removedNode = temp;

                    temp.prevNode.nextNode = temp.nextNode;
                    if (temp.nextNode != null) {
                        temp.nextNode.prevNode = temp.prevNode;
                    }
                }
            }
        }

        return removedNode;
    }

    void print() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }
}
