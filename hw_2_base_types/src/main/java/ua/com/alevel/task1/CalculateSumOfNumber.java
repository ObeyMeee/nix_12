package ua.com.alevel.task1;

import ua.com.alevel.Main;

// 1. реализуйте задачу, которая принимает строку с консоли и вычленяет все числа и находит
//их сумму

public class CalculateSumOfNumber {
    public static void main(String[] args) {
        System.out.println("Welcome to task 1!");
        String string = Main.inputString("string");
        int sum = getSumNumbers(string);
        System.out.println("Sum of numbers of input string is " + sum);
    }

    private static int getSumNumbers(String string) {
        int sum = 0;
        char[] inputString = string.toCharArray();
        for (char symbol: inputString) {
            if(symbol >= '0' && symbol <= '9'){
                sum += symbol - '0';
            }
        }
        return sum;
    }

}
