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
public class Box {
    private Object object;

    public Object get() {
        return object;
    }

    public void add(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {
        Box integerBox = new Box();

        integerBox.add(new Integer(10));
        //integerBox.add(new String("10")); -> Error

        Integer someInteger = (Integer) integerBox.get();
        System.out.println(someInteger);
    }
    
}
