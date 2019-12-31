package javaTask;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = (int) (Math.random() * 21);
        }
        System.out.println(Arrays.toString(array));

        Number number = new Number(array);
        System.out.println("Sum of numbers from array is: " + number.getSum());
        System.out.println("Sum of numbers from array + some text is: " + number.getSum("Merry Christmas"));
        System.out.println("Sum of numbers from array + some number is: " + number.getSum(5));
    }
}
