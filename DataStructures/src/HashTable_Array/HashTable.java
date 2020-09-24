/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable_Array;

/**
 *
 * @author asus
 */
public class HashTable<K, V> {

    // linear probing (closed hashing)
    private HashEntry<K, V>[] table;

    public HashTable(int capacity) {
        this.table = new HashEntry[capacity];
    }

    void put(K key, V value) {
        int hashResult = hashFunction(key);
        int index = hashResult % table.length;

        if (table[index] == null) {
            table[index] = new HashEntry<>(key, value);
        } else if (table[index].key.equals(key)) { // duplicate key, update value
            table[index].value = value;
        } else {
            // search for an empty index, linear probing
            int tempIndex = (index + 1) % table.length;

            while (tempIndex != index) {
                if (table[tempIndex] == null) {
                    table[tempIndex] = new HashEntry<>(key, value);
                    return;
                } else if (table[tempIndex].key.equals(key)) { // duplicate key, update value
                    table[tempIndex].value = value;
                    return;
                }

                tempIndex = (tempIndex + 1) % table.length;
            }

            System.out.println("no empty index to put [" + key + " : " + value + "]");
        }

    }

    V get(K key) {
        int hashResult = hashFunction(key);
        int index = hashResult % table.length;

        if (table[index] != null && table[index].key.equals(key)) {
            return table[index].value;
        } else {
            // search for the given key, linear probing
            int tempIndex = (index + 1) % table.length;

            while (tempIndex != index) {
                if (table[tempIndex] != null && table[tempIndex].key.equals(key)) {
                    return table[tempIndex].value;
                }

                tempIndex = (tempIndex + 1) % table.length;
            }
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

            if (table[i] != null) {
                System.out.println("[" + table[i].key + " : " + table[i].value + "]");
            } else {
                System.out.println("null");
            }
        }
    }
}
