/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author asus
 */
public class Test {

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();

        intStack.pop();

        intStack.print();
        System.out.println("size : " + intStack.size());

        intStack.push(5);
        intStack.push(7);
        System.out.println("peek : " + intStack.peek());
        intStack.push(3);

        intStack.print();
        System.out.println("size : " + intStack.size());

        Node<Integer> pop1 = intStack.pop();
        Node<Integer> pop2 = intStack.pop();

        intStack.push(pop1);
        intStack.push(pop2);

        intStack.print();
        System.out.println("size : " + intStack.size());

        System.out.print("15 to binary : ");
        decToBinary(15);

        System.out.println("kek - isPalindrome : " + isPalindrome("kek"));
        System.out.println("fsm - isPalindrome : " + isPalindrome("fsm"));
        System.out.println("202 - isPalindrome : " + isPalindrome("202"));
        
        System.out.println("kelime : " + reverseRecursive("kelime"));
    }

    static void decToBinary(int number) {
        Stack<Integer> intStack = new Stack<>();

        while (number > 0) {
            intStack.push(number % 2);
            number /= 2;
        }

        while (intStack.peek() != null) {
            System.out.print(intStack.pop());
        }

        System.out.println();
    }

    static boolean isPalindrome(String text) {
        boolean isPalindrome = true;
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            charStack.push(text.charAt(i));
        }

        for (int i = 0; i < text.length(); i++) {
            if (charStack.pop().data != text.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
    
    // kelime - emilek
    static String reverseRecursive(String word) {
        if (word.isEmpty()) {
            return "";
        } else {
            char c = word.charAt(0);
            return reverseRecursive(word.substring(1)) + c;
        }
    }
}
