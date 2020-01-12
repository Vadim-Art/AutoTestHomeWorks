package javaTask;

import java.util.Scanner;

public class pyramid {

    private static String symbol;

    public static void main(String[] args) {
        symbol = getSymbol();
        pattern(getNumber(), 1);
    }

    private static int getNumber() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число для количества выведенных строк:");

        if (sc.hasNextInt()) {
            n = sc.nextInt();
            if (n > 0 && n <= 15) {
                return n;
            } else {
                System.out.println("Количество строк вывода должно быть от 1 до 15");
                return getNumber();
            }
        } else {
            System.out.println("Вы ввели не число! Повторите ввод!");
            return getNumber();
        }
    }

    public static String getSymbol() {
        String symbol;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите символ:");

        if (sc.hasNextLine()) {
            symbol = sc.nextLine();
        } else {
            System.out.println("Вы ввели не символ! Повторите ввод!");
            return getSymbol();
        }

        switch (symbol) {
            case "+":
                return "+";
            case "-":
                return "-";
            case "=":
                return "=";
            case "/":
                return "/";
            default:
                System.out.println("Неправильный символ! Повторите ввод!");
                return getSymbol();
        }
    }

    static void printn(int num) {
        if (num == 0)
            return;
        System.out.print(symbol);

        printn(num - 1);
    }


    static void pattern(int n, int i) {
        if (n == 0)
            return;
        printn(i);
        System.out.println();

        pattern(n - 1, i + 1);
    }
}

