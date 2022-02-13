package ua.com.alevel.start;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ProgramStart.greeting();
            while (true) {
                ProgramStart.menu();
                ProgramStart.caseLogic();
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Something went wrong: " + e.getMessage());
        }
    }
}
