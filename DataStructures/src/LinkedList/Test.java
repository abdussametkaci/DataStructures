/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author asus
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SLinkedList<Integer> liste = new SLinkedList<>();

        liste.addFirst(5);
        liste.addLast(3);
        liste.addAfter(2, 7);
        liste.addFirst(8);
        liste.addAfter(3, 6);

        liste.print();
        System.out.println("size : " + liste.size());

        liste.remove(6);
        liste.print();
        System.out.println("size : " + liste.size());
    }
    /*
    public static SLinkedList mergeList(SLinkedList llist1, SLinkedList llist2) {
        if (llist1.isEmpty() && llist2.isEmpty()) {
            return null;
        }
        if (llist1.isEmpty()) {
            return llist2;
        }
        if (llist2.isEmpty()) {
            return llist1;
        }
        SLinkedList mList = new SLinkedList();
        Node crr1 = llist1.head;
        Node crr2 = llist2.head;
        while (crr1 != null && crr2 != null) {
            if (crr1.element <= crr2.element) {
                mList.addLast(crr1);
                crr1 = crr1.next;
            } else {
                mList.addLast(crr2);
                crr2 = crr2.next;
            }
        }
        while (crr1 != null) {
            mList.addLast(crr1);
            crr1 = crr1.next;
        }
        while (crr2 != null) {
            mList.addLast(crr2);
            crr2 = crr2.next;
        }
        return mList;
    }
*/

}
