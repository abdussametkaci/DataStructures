/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author asus
 */
public class Stack<T> {

    private Node<T> head;

    void push(T data) {
        push(new Node<>(data));
    }

    void push(Node<T> newNode) {
        newNode.nextNode = head;
        head = newNode;
    }

    Node<T> pop() {
        if (isEmpty()) {
            System.out.println("Empty stack !");
            return null;
        } else {
            Node<T> removed = head;

            head = head.nextNode;

            return removed;
        }
    }

    Node<T> peek() {
        return head;
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        int counter = 0;
        Node<T> temp = head;

        while (temp != null) {
            counter++;
            temp = temp.nextNode;
        }

        return counter;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Empty stack !");
        } else {
            System.out.println("Stack elements are :");

            Node<T> temp = head;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.nextNode;
            }

            System.out.println("null");
        }
    }
}
