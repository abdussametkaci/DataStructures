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
public class Test {
    public static void main(String[] args) {

        DLinkedList<Integer> dList = new DLinkedList<>();

        dList.print();
        System.out.println("size : " + dList.size());

        dList.addLast(5);
        dList.addLast(3);
        dList.addAfter(5, 7);
        dList.addFirst(5);
        dList.addAfter(5, 1);

        dList.print();
        System.out.println("size : " + dList.size());

        dList.remove(4);
        dList.remove(1);
        dList.remove(5);

        dList.print();
        System.out.println("size : " + dList.size());
    }
    
}
