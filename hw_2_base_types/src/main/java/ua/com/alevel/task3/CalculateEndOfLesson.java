package ua.com.alevel.task3;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.Main;

//Конец уроков
//В некоторой школе занятия начинаются в 9:00. Продолжительность урока — 45 минут,
//после 1-го, 3-го, 5-го и т.д. уроков перемена 5 минут, а после 2-го, 4-го, 6-го и т.д. — 15
//минут.
//Определите, когда заканчивается указанный урок.

public class CalculateEndOfLesson {

    public static void main(String[] args) {
        System.out.println("Welcome to task 3!");
        int numberOfLesson = Integer.parseInt(
                Main.inputString("number of lesson"));
        // znanija.com/task/33131013
        int hours = 9;
        int minutes = hours * 60;

        int endInMinutes = minutes + numberOfLesson * 45
                + (numberOfLesson / 2) * 5 + ((numberOfLesson + 1) / 2 - 1) * 15;
        hours = endInMinutes / 60;
        minutes = endInMinutes % 60;
        System.out.println("The end of the lesson " + numberOfLesson + " ==> "
                + StringUtils.leftPad(String.valueOf(hours), 2, "0")
                + ":" + StringUtils.leftPad(String.valueOf(minutes), 2, "0"));
    }
}

