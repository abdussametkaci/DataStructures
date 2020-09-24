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
public class Test {
    public static void main(String[] args) {

        CLinkedList cList = new CLinkedList();

        cList.addAfter(5, 4);
        cList.addLast(16);
        cList.addLast(12);
        cList.addFirst(25);

        cList.print();
        System.out.println("size : " + cList.size());

        cList.remove(4);
        Node removedNode = cList.remove(16);

        cList.print();
        System.out.println("size : " + cList.size());

        cList.addLast(removedNode);

        cList.print();
        System.out.println("size : " + cList.size());
    }
    
}
