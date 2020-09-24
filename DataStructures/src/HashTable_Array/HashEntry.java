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
public class HashEntry<K, V> {

    K key;
    V value;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}