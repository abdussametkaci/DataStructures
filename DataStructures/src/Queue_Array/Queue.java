/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue_Array;

/**
 *
 * @author asus
 */
public class Queue<T> {

    private T[] dataArray;
    private int front, rear;
    private int size;

    public Queue(int capacity) {
        dataArray = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
    }

    void enqueue(T newData) {
        if (isFull()) {
            System.out.println("Queue is full !");
        } else {
            dataArray[rear] = newData;
            rear++;

            if (rear % dataArray.length == 0) {
                rear = 0;
            }

            size++;
        }
    }

    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            return null;
        } else {
            T temp = dataArray[front];
            front++;

            if (front % dataArray.length == 0) {
                front = 0;
            }

            size--;
            return temp;
            // return dataArray[front-1];
        }
    }

    private boolean isFull() {
        return size == dataArray.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void print() {
        int index = front;

        for (int i = 0; i < size; i++) {
            System.out.print(dataArray[index++] + " -> ");

            if (index % dataArray.length == 0) {
                index = 0;
            }
        }

        System.out.println("null");
    }
}
