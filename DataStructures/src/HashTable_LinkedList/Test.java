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
public class Test {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>(2);

        hashTable.put(150110001, "Öğrenci-1");
        hashTable.put(150110002, "Öğrenci-2");
        hashTable.put(150110003, "Öğrenci-3");

        System.out.println("150110001 : " + hashTable.hashFunction(150110001));
        System.out.println("150110001 : " + hashTable.get(150110001));

        System.out.println("Hash Table:");
        hashTable.printTable();
    }
    
}
