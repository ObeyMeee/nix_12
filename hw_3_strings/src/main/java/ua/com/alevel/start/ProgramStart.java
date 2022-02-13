package ua.com.alevel.start;

import ua.com.alevel.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ProgramStart {
    private static final BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));
    private static String input;
    private ProgramStart(){

    }

    public static void greeting() throws IOException {
        System.out.println("Welcome to the homework 3!");
        System.out.println("\tTopic: Reverse string");
        System.out.println();

        System.out.print("Press Enter to continue...");
        reader.readLine();
        System.out.println();
    }

    public static void menu(){
        System.out.println("Press 1 to reverse full string");
        System.out.println("Press 2 to reverse each word of string");
        System.out.println("Press 3 to reverse substring of string");
        System.out.println("Press 4 to reverse by indicated indexes");
        System.out.println("Press 0 to exit");
        System.out.print("Your input ==> ");
    }

    public static void caseLogic() throws IOException {
        String choice = reader.readLine();
        if(!choice.equals("0")) {
            System.out.print("Please, enter string ==> ");
            input = reader.readLine();
        }
        switch (choice){
            case "1" -> System.out.println(StringUtils.reverse(input));
            case "2" -> System.out.println(StringUtils.reverseEachWord(input));
            case "3" -> {
                System.out.print("Please, enter substring ==> ");
                String substr = reader.readLine();
                System.out.println(StringUtils.reverse(input, substr));
            }
            case "4" ->{
                System.out.print("Please, enter index of beginning reversing ==> ");
                int firstIndex = Integer.parseInt(reader.readLine());
                System.out.print("Please, enter index of end reversing ==> ");
                int lastIndex = Integer.parseInt(reader.readLine());
                System.out.println(StringUtils.reverse(input, firstIndex, lastIndex));
            }
            case "0" -> {
                System.out.println("Bye!");
                reader.close();
                System.exit(0);
            }
            default -> System.out.println("Incorrect input. Try again");
        }
    }
}
