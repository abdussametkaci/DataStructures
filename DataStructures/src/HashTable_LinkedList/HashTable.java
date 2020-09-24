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
public class HashTable<K, V> {

    // seperate chaining (open hashing)
    private LinkedList<K, V>[] table;

    public HashTable(int capacity) {
        this.table = new LinkedList[capacity];

        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    void put(K key, V value) {
        int hashResult = hashFunction(key);
        int index = hashResult % table.length;

        // duplicate key control
        Node<K, V> temp = table[index].head;
        while (temp != null && !temp.key.equals(key)) {
            temp = temp.next;
        }

        if (temp == null) {
            table[index].addFirst(key, value);
        } else {
            // duplicate key
            temp.value = value;
        }
    }

    V get(K key) {
        int hashResult = hashFunction(key);
        int index = hashResult % table.length;

        // search
        Node<K, V> temp = table[index].head;
        while (temp != null && !temp.key.equals(key)) {
            temp = temp.next;
        }

        if (temp != null) {
            return temp.value;
        }

        System.out.println("key \"" + key + "\" not found !");
        return null;
    }

    int hashFunction(K key) {
        String temp = String.valueOf(key);
        int first = temp.charAt(0);
        int last = temp.charAt(temp.length() - 1);

        return first + last;
    }

    void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("[" + i + "]");
            table[i].print();
        }
    }
}
