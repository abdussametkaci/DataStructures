/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue_Array;

/**
 *
 * @author asus
 */
public class Question {
    public static void main(String[] args) {
        int k = 10;
        System.out.println(fibonacci(k));
        // fibonacci(10) = 55

        fibonacciPrint(k);
        // 0 1 1 2 3 5 8 13 21 34
    }

    static int fibonacci(int n) {
        Queue<Integer> kuyruk = new Queue<>(2);

        kuyruk.enqueue(0);
        kuyruk.enqueue(1);

        for (int i = 0; i < n; i++) {
            Integer first = kuyruk.dequeue();
            Integer second = kuyruk.dequeue();

            kuyruk.enqueue(second);
            kuyruk.enqueue(first + second);
        }

        // TODO: return nth fibonacci number
        return kuyruk.dequeue();
    }

    static void fibonacciPrint(int n) {
        Queue<Integer> kuyruk = new Queue<>(2);

        kuyruk.enqueue(0);
        kuyruk.enqueue(1);
        
        for (int i = 0; i < n; i++) {
            Integer first = kuyruk.dequeue();
            Integer second = kuyruk.dequeue();

            kuyruk.enqueue(second);
            kuyruk.enqueue(first + second);
            
            System.out.print(first + " ");
        }
        
        System.out.println();
        // TODO: print first n fibonacci numbers
    }
    
}
