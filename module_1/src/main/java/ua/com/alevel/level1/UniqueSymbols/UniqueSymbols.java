package ua.com.alevel.level1.UniqueSymbols;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueSymbols {

    private UniqueSymbols() {

    }

    public static void run(BufferedReader reader) throws Exception {
        System.out.println("Task: Check unique digits in array\n");
        System.out.print("Please, input array of integers ==> ");
        String array = reader.readLine();
        System.out.println("Count unique digits is " + countUniqueDigits(array));
    }

    private static int countUniqueDigits(String array) throws Exception {
        if (!array.matches("[0-9 ]+")) {
            throw new Exception("Incorrect input");
        }
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(array);
        Set<Integer> uniqueDigits = new HashSet<>();
        while (matcher.find()) {
            uniqueDigits.add(Integer.parseInt(matcher.group()));
        }
        return uniqueDigits.size();
    }
}
