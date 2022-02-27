package ua.com.alevel;

import ua.com.alevel.task1.CalculateSumOfNumber;
import ua.com.alevel.task2.FindSymbolsOfString;
import ua.com.alevel.task3.CalculateEndOfLesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.println("Welcome to homework 2!");
        System.out.println("Please enter!");

        try {
            String line = reader.readLine();
            while (true) {
                menu();
                caseLogic();
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

    }

    private static void menu() {
        System.out.println();
        System.out.println("Which task do you want to check?");
        System.out.println("Press 1 to check task 1");
        System.out.println("Press 2 to check task 2");
        System.out.println("Press 3 to check task 3");
        System.out.println("Press 0 to exit");
        System.out.println();
        System.out.print("Your choice ==> ");
    }

    private static void caseLogic() throws IOException {
        String choice = reader.readLine();

        switch (choice) {
            case "1" -> CalculateSumOfNumber.main(null);
            case "2" -> FindSymbolsOfString.main(null);
            case "3" -> CalculateEndOfLesson.main(null);
            case "0" -> {
                reader.close();
                System.exit(0);
            }
            default -> System.out.println("Try again");
        }
    }

    public static String inputString(String enteredType) {
        System.out.print("Please, enter " + enteredType + " ==> ");
        String string = null;

        try {
            string = reader.readLine();
        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }
        return string;
    }
}
