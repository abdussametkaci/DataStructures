package Sorting;

public class Sorting {

    public static void main(String[] args) {
        int[] array = {2, 9, 5, 4, 8, 1, 6, 15, 16, 17};

        System.out.println("before sort :");
        printArray(array);

        System.out.println("\nbubble sort :");
        bubleSort(array);

        System.out.println("\nafter bubble sort :");
        printArray(array);
    }

    static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            // swap
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

    }

    static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];

            int j = i - 1;
            while (j >= 0 && currentElement < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = currentElement;
        }
    }

    static void bubleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean isSwapped = false;

            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    isSwapped = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            System.out.print(i + ". pass : ");
            printArray(array);

            if (!isSwapped) {
                System.out.println(array.length + " numbers sorted in " + i + " passes");
                break;
            }
        }
    }

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
