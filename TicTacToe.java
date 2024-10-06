package InternshipProjects;

import java.util.Scanner;

public class TicTacToe {
    private static final char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            boolean gameOn = true;
            resetBoard();
            printBoard();

            while (gameOn) {
                System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
                int move = scanner.nextInt();
                if (isValidMove(move)) {
                    placeMove(move);
                    printBoard();
                    if (checkWin()) {
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameOn = false;
                    } else if (isBoardFull()) {
                        System.out.println("It's a draw!");
                        gameOn = false;
                    } else {
                        switchPlayer();
                    }
                } else {
                    System.out.println("Invalid move, try again.");
                }
            }

            System.out.println("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void resetBoard() {
        char count = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = count++;
            }
        }
        currentPlayer = 'X';
    }

    private static boolean isValidMove(int move) {
        return move >= 1 && move <= 9 && board[(move - 1) / 3][(move - 1) % 3] == (char) (move + '0');
    }

    private static void placeMove(int move) {
        board[(move - 1) / 3][(move - 1) % 3] = currentPlayer;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        return board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
