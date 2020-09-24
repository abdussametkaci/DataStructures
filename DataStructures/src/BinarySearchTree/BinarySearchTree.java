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
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    // iterative insert method
    void insert(T newData) {
        Node<T> newNode = new Node<>(newData);

        if (isEmpty()) {
            root = newNode;
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        return;
                    }

                    temp = temp.rightChild;
                } else if (newData.compareTo(temp.data) < 0) {
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        return;
                    }

                    temp = temp.leftChild;
                } else {
                    return;
                }
            }
        }
    }

    void insertRecursive(T newData) {
        root = insertRecursive(root, newData);
    }

    // recursive insert method
    private Node<T> insertRecursive(Node<T> node, T newData) {
        if (node == null) {
            return new Node<>(newData);
        } else {
            if (newData.compareTo(node.data) > 0) {
                node.rightChild = insertRecursive(node.rightChild, newData);
            } else if (newData.compareTo(node.data) < 0) {
                node.leftChild = insertRecursive(node.leftChild, newData);
            }

            return node;
        }
    }

    // iterative search method
    boolean search(T searchData) {
        if (isEmpty()) {
            System.out.println("BinarySearchTree is empty !");
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.data) > 0) {
                    temp = temp.rightChild;
                } else if (searchData.compareTo(temp.data) < 0) {
                    temp = temp.leftChild;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    void preorder() {
        System.out.print("preorder : ");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    void inorder() {
        System.out.print("inorder : ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(node.data + " ");
            inorder(node.rightChild);
        }
    }

    void postorder() {
        System.out.print("postorder : ");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node<T> node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.data + " ");
        }
    }

    private boolean isEmpty() {
        return root == null;
    }

    // TODO: int sumRecursive
    int sumRecursive() {
        return sumRecursive(root);
    }

    private int sumRecursive(Node<T> node) {
        // implement recursive method to find sum
        if (node != null) {
            if (node.data instanceof Number) {
                return (Integer) node.data + sumRecursive(node.leftChild) + sumRecursive(node.rightChild);
            }
        }

        return 0;
    }

    // TODO: int sizeRecursive
    int sizeRecursive() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node<T> node) {
        // implement recursive method to find size
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeRecursive(node.leftChild) + sizeRecursive(node.rightChild);
        }
    }

    // TODO: int fullNodeCountRecursive (node with both left and right child)
    int fullNodeCountRecursive() {
        return fullNodeCountRecursive(root);
    }

    private int fullNodeCountRecursive(Node<T> node) {
        // implement recursive method to find full node count
        if (node == null) {
            return 0;
        } else {
            if (node.leftChild != null && node.rightChild != null) {
                return 1 + fullNodeCountRecursive(node.leftChild) + fullNodeCountRecursive(node.rightChild);
            } else {
                return 0 + fullNodeCountRecursive(node.leftChild) + fullNodeCountRecursive(node.rightChild);
            }
        }
    }

    T findMaxRecursive() {
        return findMaxRecursive(root);
    }

    // BST, max element located at right most side of the tree
    private T findMaxRecursive(Node<T> node) {
        if (node.rightChild != null) {
            return findMaxRecursive(node.rightChild);
        }

        return node.data;
    }
}
