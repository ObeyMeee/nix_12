package ua.com.alevel.level1.MoveChessKnight;

import java.io.BufferedReader;
import java.io.IOException;

public class ChessKnight {
    private static final int BOARD_SIZE = 8;
    private static int row;
    private static int column;

    private ChessKnight() {

    }

    public static void run(BufferedReader reader) throws IOException {
        System.out.println("Task 3: Check if move of knight is possible\n");
        setKnightArrangement(reader);
        drawBoard();
        System.out.print("Input move ==> ");
        String move = reader.readLine();
        move(move);
        System.out.println("\nBoard after move\n");
        drawBoard();
    }

    private static void setKnightArrangement(BufferedReader reader) throws IOException {
        System.out.print("Input arrangement of knight ==> ");
        String knightArrangement = reader.readLine();
        knightArrangement = knightArrangement.toLowerCase();
        row = knightArrangement.charAt(0) - 'a';
        column = Integer.parseInt(String.valueOf(knightArrangement.charAt(1)));
    }

    private static void drawBoard() {
        System.out.print("    ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char) ('A' + i) + "\t");
        }
        for (int i = BOARD_SIZE; i > 0; i--) {
            System.out.println();
            System.out.println("  ---------------------------------");
            System.out.print(i + " ");
            for (int j = 0; j <= BOARD_SIZE; j++) {
                if (column == i && row == j) {
                    System.out.print("| " + "\u2658");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.print(i);
        }
        System.out.println("\n  ---------------------------------");
        System.out.print("    ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char) ('A' + i) + "\t");
        }
        System.out.println();
    }

    private static void move(String move) {
        int currentRow = move.charAt(0) - 'a';
        int currentColumn = Integer.parseInt(String.valueOf(move.charAt(1)));
        if (Math.abs(currentRow - row) == 2 && Math.abs(currentColumn - column) == 1) {
            row = currentRow;
            column = currentColumn;
        } else if (Math.abs(currentRow - row) == 1 && Math.abs(currentColumn - column) == 2) {
            row = currentRow;
            column = currentColumn;
        } else {
            System.out.println("Incorrect move");
        }
    }
}
