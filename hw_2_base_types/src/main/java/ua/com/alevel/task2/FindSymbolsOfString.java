package ua.com.alevel.task2;

import ua.com.alevel.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//реализуйте задачу, которая принимает строку с консоли и вычленяет все символы
//      латиницы/кириллицы и сортирует их, указывая количество вхождений каждого символа

public class FindSymbolsOfString {
    public static void main(String[] args) {
        System.out.println("Welcome to task 2!");

        String string = Main.inputString("String");
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я]");
        Matcher matcher = pattern.matcher(string);
        Map<String, Integer> map = new HashMap<>();
        while(matcher.find()){
            String symbol = matcher.group();
            if(!map.containsKey(symbol)){
                map.put(symbol, 1);
            }else{
                int currentAmountOfSymbols = map.get(symbol);
                map.put(symbol,++currentAmountOfSymbols);
            }
        }
        map.entrySet()
                .stream()
                 .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
    }
}
