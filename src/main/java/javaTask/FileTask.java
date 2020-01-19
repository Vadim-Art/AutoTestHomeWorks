package javaTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileTask {
    public static void main(String[] args) throws FileNotFoundException {
        int[] numbers = new int[10];
        readFile(numbers);
        sqrtNumber(numbers);
        creatFile();
        writeToFile(numbers);
    }

    public static int[] readFile(int[] numbers) throws FileNotFoundException {
        File firstFile = new File("C:\\Users\\Вадим\\IdeaProjects\\Lektorium\\src\\main\\java\\javaTask\\lektorium1.txt");
        Scanner scanner = new Scanner(firstFile);
        String line = scanner.nextLine();
        String[] stringOfNumbers = line.split(" ");
        int counter = 0;

        for (String number : stringOfNumbers) {
            numbers[counter++] = Integer.parseInt(number);
        }
        System.out.println("Numbers from the first file are: " + Arrays.toString(numbers));

        scanner.close();
        return numbers;
    }

    public static int[] sqrtNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= numbers[i];
        }
        System.out.println("Numbers were raised to a second power: " + Arrays.toString(numbers));
        return numbers;
    }

    public static String creatFile() {
        File newFile = new File("C:\\Users\\Вадим\\IdeaProjects\\Lektorium\\src\\main\\java\\javaTask\\lektorium2.txt");
        try {
            boolean created = newFile.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void writeToFile(int[] numbers) throws FileNotFoundException {
        File secondFile = new File("C:\\Users\\Вадим\\IdeaProjects\\Lektorium\\src\\main\\java\\javaTask\\lektorium2.txt");
        PrintWriter prw = new PrintWriter(secondFile);
        prw.println(Arrays.toString(numbers));
        prw.close();
    }
}
