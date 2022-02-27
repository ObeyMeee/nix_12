package ua.com.alevel.level3.GameOfLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

// based on https://codereview.stackexchange.com/questions/151461/game-of-life-java
public class LifeGame {

    private static State[][] board;

    private enum State {
        DEAD, ALIVE
    }

    private LifeGame() {
    }

    public static void run(BufferedReader reader) throws InterruptedException {
        getStartPosition(reader);
        System.out.println("Source board:");
        print();
        System.out.println("\nBoard after one iteration");
        getFinishPosition();
        System.out.println();
        print();
    }

    private static void getStartPosition(BufferedReader reader) throws InterruptedException {
        System.out.print("Input length of board ==> ");
        int length = 0;
        int height = 0;
        try {
            length = Integer.parseInt(reader.readLine());
            System.out.print("Input height of board ==> ");
            height = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Incorrect input. Try again");
            getStartPosition(reader);
        }
        board = new State[length][height];
        System.out.print("Generating random values...  ");
        Thread.sleep(1500);
        System.out.println("\n");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                int randomState = new Random().nextInt(2);
                if (randomState == 0) {
                    board[i][j] = State.DEAD;
                } else {
                    board[i][j] = State.ALIVE;
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == State.ALIVE) {
                    System.out.print(1);
                } else {
                    System.out.print('\u00d7');
                }
            }
            System.out.println();
        }
    }

    private static void getFinishPosition() {
        State[][] temp = new State[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, temp[i], 0, board[0].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = getNewState(i, j, temp);
            }
        }
    }


    private static State getNewState(int x, int y, State[][] board) {
        int amountLiveNeighbours = countLiveNeighbours(x, y, board);

        if ((amountLiveNeighbours < 2 || amountLiveNeighbours > 3) && board[x][y] == State.ALIVE)
            return State.DEAD;
        else if ((amountLiveNeighbours == 2 || amountLiveNeighbours == 3) && board[x][y] == State.ALIVE)
            return State.ALIVE;
        else if (board[x][y] == State.DEAD && amountLiveNeighbours == 3)
            return State.ALIVE;
        else
            return State.DEAD;
    }

    private static int countLiveNeighbours(int x, int y, State[][] board) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i >= 0 && y + j >= 0 && x + i < board.length && y + j < board.length) {
                    if (board[x + i][y + j] == State.ALIVE && !(i == 0 && j == 0)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
