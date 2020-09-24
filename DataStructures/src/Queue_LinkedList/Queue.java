/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue_LinkedList;

/**
 *
 * @author asus
 */
public class Queue<T> {

    private Node<T> front, rear;

    void enqueue(T newData) {
        Node<T> newNode = new Node<>(newData);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            // LinkedList - addLast
            rear.nextNode = newNode;
            rear = newNode;
        }
    }

    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            return null;
        } else {
            T temp = front.data;

            front = front.nextNode;

            if (isEmpty()) {
                rear = null;
            }

            return temp;
        }
    }

    private boolean isEmpty() {
        return front == null;
    }

    int size() {
        int size = 0;

        Node<T> temp = front;

        while (temp != null) {
            size++;
            temp = temp.nextNode;
        }

        return size;
    }

    void print() {
        Node<T> temp = front;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }
}
