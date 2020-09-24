/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

/**
 *
 * @author asus
 */
public class BoxGeneric<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        BoxGeneric<Integer> integerBox = new BoxGeneric<>();
        //BoxGeneric<String> stringBox = new BoxGeneric<String>();

        integerBox.add(10);
        //stringBox.add(new String("Hello World"));

        Integer someInteger = integerBox.get();
        System.out.println(someInteger);
    }
}
