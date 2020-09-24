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
public class Node<T> {

    T data;
    Node<T> nextNode;
    Node<T> prevNode;

    public Node(T data) {
        this.data = data;
    }

}
