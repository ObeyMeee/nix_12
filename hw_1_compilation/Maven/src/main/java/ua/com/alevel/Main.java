package ua.com.alevel;


import javax.servlet.*;
import ua.com.alevel.classes.IntegerUtils;
import ua.com.alevel.classes.MyNumber;

public class Main {

    public static void main(String[] args) {
        MyNumber year = new MyNumber();
        year.setNumber(2022);
        System.out.println(year);
        int result = IntegerUtils.addRandomNumber(year);
        System.out.println("New result is " + result);
    }
}
