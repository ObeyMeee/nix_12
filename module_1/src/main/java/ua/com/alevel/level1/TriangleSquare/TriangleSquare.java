package ua.com.alevel.level1.TriangleSquare;

import java.io.BufferedReader;
import java.io.IOException;

public class TriangleSquare {

    private TriangleSquare() {

    }

    public static void run(BufferedReader reader) throws IOException {
        System.out.println("Task: find square of triangle by its coordinates\n");
        double[] sides = new double[3];
        int[] xCoordinates = new int[3];
        int[] yCoordinates = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Please, input X coordinate of " + (i + 1) + " point: ");
            xCoordinates[i] = Integer.parseInt(reader.readLine());
            System.out.print("Please, input Y coordinate of " + (i + 1) + " point: ");
            yCoordinates[i] = Integer.parseInt(reader.readLine());
        }
        sides[0] = getLength(xCoordinates[0], yCoordinates[0], xCoordinates[1], yCoordinates[1]);
        sides[1] = getLength(xCoordinates[1], yCoordinates[1], xCoordinates[2], yCoordinates[2]);
        sides[2] = getLength(xCoordinates[0], yCoordinates[0], xCoordinates[2], yCoordinates[2]);
        double square = getSquare(sides[0], sides[1], sides[2]);
        if (square == 0.0) {
            System.out.println("This shape is not triangle");
            return;
        }
        System.out.println("The square of triangle is " + square);
    }

    private static double getSquare(double firstSideLength, double secondSideLength, double thirdSideLength) {

        double halfPerimeter = (firstSideLength + secondSideLength + thirdSideLength) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSideLength) *
                (halfPerimeter - secondSideLength) * (halfPerimeter - thirdSideLength));
    }

    private static double getLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

}
