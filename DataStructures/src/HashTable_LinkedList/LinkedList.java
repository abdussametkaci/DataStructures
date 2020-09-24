/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable_LinkedList;

/**
 *
 * @author asus
 */
public class LinkedList<T, G> {

    protected Node<T, G> head;

    void addFirst(T key, G value) {
        Node<T, G> newNode = new Node<>(key, value);

        newNode.next = head;
        head = newNode;
    }

    void print() {
        Node<T, G> temp = head;

        while (temp != null) {
            System.out.print("[" + temp.key + " : " + temp.value + "] -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
