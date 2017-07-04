package jm.app;

import java.util.Scanner;

public class Level1 {
    int[][] board;
    boolean isLock = true;
    boolean isWin = false;
    Point pos = new Point(0, 0);

    public Level1() {
        board = new int[2][3];
        board[0][0] = 1;
        board[0][2] = 4;
        board[1][1] = 2;
    }

    private void moveLeft() {
        if (pos.getCol() <= 0) {
            return;
        }
        if (board[pos.getRow()][pos.getCol() - 1] == 0) {
            switch (board[pos.getRow()][pos.getCol()]) {
                case 1:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow()][pos.getCol() - 1] = 1;
                    break;
                case 3:
                    board[pos.getRow()][pos.getCol()] = 2;
                    board[pos.getRow()][pos.getCol() - 1] = 1;
                    break;
                case 5:
                    board[pos.getRow()][pos.getCol()] = 4;
                    board[pos.getRow()][pos.getCol() - 1] = 1;
                    break;
                case 7:
                    board[pos.getRow()][pos.getCol()] = 6;
                    board[pos.getRow()][pos.getCol() - 1] = 1;
                    break;
            }
            pos.setCol(pos.getCol() - 1);
        }
    }

    private void moveRight() {
        if (pos.getRow() == 0 && pos.getCol() == 2 && isLock == false) {
            isWin = true;
            return;
        }
        if (pos.getCol() >= board[0].length - 1) {
            return;
        }
        switch(board[pos.getRow()][pos.getCol() + 1]){
            case 0:
                switch (board[pos.getRow()][pos.getCol()]) {
                    case 1:
                        board[pos.getRow()][pos.getCol()] = 0;
                        board[pos.getRow()][pos.getCol() + 1] = 1;
                        break;
                    case 3:
                        board[pos.getRow()][pos.getCol()] = 0;
                        board[pos.getRow()][pos.getCol() + 1] = 3;
                        break;
                }
                break;
            case 2:
                switch (board[pos.getRow()][pos.getCol()]) {
                    case 1:
                        board[pos.getRow()][pos.getCol()] = 0;
                        board[pos.getRow()][pos.getCol() + 1] = 3;
                        break;
                }
                break;
            case 4:
                switch (board[pos.getRow()][pos.getCol()]) {
                    case 1:
                        board[pos.getRow()][pos.getCol()] = 0;
                        board[pos.getRow()][pos.getCol() + 1] = 5;
                        break;
                    case 3:
                        board[pos.getRow()][pos.getCol()] = 0;
                        board[pos.getRow()][pos.getCol() + 1] = 7;
                        isLock = false;
                        break;
                }
                break;
            case 6:
                switch (board[pos.getRow()][pos.getCol()]) {
                    case 1:
                        board[pos.getRow()][pos.getCol()] = 0;
                        board[pos.getRow()][pos.getCol() + 1] = 7;
                        break;
                }
                break;
        }
        pos.setCol(pos.getCol() + 1);
    }

    private void moveUp() {
        if (pos.getRow() <= 0) {
            return;
        }
        if (board[pos.getRow() - 1][pos.getCol()] == 0) {
            switch (board[pos.getRow()][pos.getCol()]) {
                case 1:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() - 1][pos.getCol()] = 1;
                    break;
                case 3:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() - 1][pos.getCol()] = 3;
                    break;
                case 5:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() - 1][pos.getCol()] = 5;
                    break;
                case 7:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() - 1][pos.getCol()] = 7;
                    break;
            }
            pos.setRow(pos.getRow() - 1);
        }
    }

    private void moveDown() {
        if (pos.getRow() >= board.length - 1) {
            return;
        }
        if (board[pos.getRow() + 1][pos.getCol()] == 0) {
            switch (board[pos.getRow()][pos.getCol()]) {
                case 1:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() + 1][pos.getCol()] = 1;
                    break;
                case 3:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() + 1][pos.getCol()] = 3;
                    break;
                case 5:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() + 1][pos.getCol()] = 5;
                    break;
                case 7:
                    board[pos.getRow()][pos.getCol()] = 0;
                    board[pos.getRow() + 1][pos.getCol()] = 7;
                    break;
            }
            pos.setRow(pos.getRow() + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Press \"w\", \"s\",\"a\",and \"d\" for Up, Down, Left and Right respectively.");
        Level1 level1 = new Level1();
        Scanner scanner = new Scanner(System.in);
        while(level1.isWin == false){
            level1.printBoard();
            String ch = scanner.nextLine();
            switch (ch){
                case "w": level1.moveUp();
                    break;
                case "s": level1.moveDown();
                    break;
                case "a": level1.moveLeft();
                    break;
                case "d": level1.moveRight();
                    break;
            }
            if(level1.isLock == false){
                System.out.println("Unlocked!\n");
            }
            if(level1.isWin == true){
                System.out.println("You win!\n");
                break;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Current position: [" + pos.getRow() + ", " + pos.getCol() + "]");
    }
}
