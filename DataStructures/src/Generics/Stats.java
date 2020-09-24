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
public class Stats<T extends Number> {

    // sayılar dizisi
    T[] numbers;

    Stats(T[] array) {
        numbers = array;
    }

    double average() {
        double sum = 0.0;

        for (T num : numbers) {
            sum += num.doubleValue();
        }

        return sum / numbers.length;
    }

    boolean sameAvg(Stats<?> ob) {
        return average() == ob.average();
    }

    <E extends Number> boolean sameAvg2(Stats<E> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(inums);
        double avg1 = iob.average();
        System.out.println("iob average is " + avg1);

        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<>(dnums);
        double avg2 = dob.average();
        System.out.println("dob average is " + avg2);

        if (iob.sameAvg(dob)) {
            System.out.println("are the same.");
        } else {
            System.out.println("differ.");
        }

        System.out.println(iob.sameAvg2(dob));
    }
}
