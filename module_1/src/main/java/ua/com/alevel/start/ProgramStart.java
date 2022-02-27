package ua.com.alevel.start;

import ua.com.alevel.level1.MoveChessKnight.ChessKnight;
import ua.com.alevel.level1.TriangleSquare.TriangleSquare;
import ua.com.alevel.level1.UniqueSymbols.UniqueSymbols;
import ua.com.alevel.level2.ValidateBrackets.ValidateString;
import ua.com.alevel.level3.GameOfLife.LifeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramStart {
    private static final BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));


    private class StartLevelOne {
        private static void run() throws Exception {
            levelOneNavigate();
            levelOneCaseLogic();
        }

        private StartLevelOne() {

        }

        private static void levelOneNavigate() {
            System.out.println("Press 1 to check task 1");
            System.out.println("Press 2 to check task 2");
            System.out.println("Press 3 to check task 3");
            System.out.print("\nYour input ==> ");
        }

        private static void levelOneCaseLogic() throws Exception {
            String choice = reader.readLine();
            switch (choice) {
                case "1" -> UniqueSymbols.run(reader);
                case "2" -> ChessKnight.run(reader);
                case "3" -> TriangleSquare.run(reader);
            }
        }
    }

    public static void run() throws Exception {
        greeting();
        while (true) {
            mainNavigate();
            mainCaseLogic();
            System.out.println();
        }
    }

    private static void greeting() throws IOException {
        System.out.println("Welcome to the module 1!");
        System.out.print("\nPress Enter to continue...");
        reader.readLine();
    }

    private static void mainNavigate() {
        System.out.println("Press 1 to check level 1");
        System.out.println("Press 2 to check level 2");
        System.out.println("Press 3 to check level 3");
        System.out.println("Press 0 to exit");
        System.out.print("\nYour input ==> ");
    }

    private static void mainCaseLogic() throws Exception {
        String choice = reader.readLine();
        switch (choice) {
            case "1" -> StartLevelOne.run();
            case "2" -> checkValidateString();
            case "3" -> playLifeOfGame();
            case "0" -> System.exit(0);
        }
    }


    private static void playLifeOfGame() throws InterruptedException {
        System.out.println("Welcome to the Game of Life!");
        LifeGame.run(reader);
    }

    private static void checkValidateString() throws IOException {
        System.out.println("Task 2: Is input string validated on brackets?");
        System.out.println("Please, input any string. The program will check it on brackets placed in right way");
        System.out.print("Your input ==> ");
        String str = reader.readLine();
        if (ValidateString.isValidate(str)) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is not valid");
        }
    }
}
