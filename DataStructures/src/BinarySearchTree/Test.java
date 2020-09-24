/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author asus
 */
public class Test {
    public static void main(String[] args) {
       BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(15);
        bst.insertRecursive(19);
        bst.insertRecursive(8);
        bst.insertRecursive(17);
        bst.insertRecursive(25);
        bst.insertRecursive(4);

        bst.preorder();
        bst.inorder();
        bst.postorder();

        System.out.println("2 ? " + bst.search(2));
        System.out.println("25 ? " + bst.search(25));
    }
    
}
