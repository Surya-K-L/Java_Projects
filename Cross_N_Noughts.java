import java.util.*;
public class Cross_N_Noughts {
    private static char board[][] = { { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' } };
    private static char current = 'X';

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean won = false;
        System.out.println(" Cross 'n' Noughts");
        System.out.print(" Enter \"R " + "to get Rules of the game (or) Enter \"N " + "to Skip the Rules: ");
        String needRules = sc.next().toUpperCase();
        if (needRules.equals("R")) {
            displayRules();
        }
        printBoard();
        while (!won && !isBoardFull()) 
        {
            int row = -1;
            int col = -1;
            while (true) {
                System.out.print("Player " + current + " move: ");
                if (sc.hasNextInt()) {
                    row = sc.nextInt() - 1;
                    if (sc.hasNextInt()) {
                        col = sc.nextInt() - 1;
                        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                            board[row][col] = current;
                            break;
                        } else if (board[row][col] == 'X' || board[row][col] == 'O') {
                            System.out.println("The particular place is already filled with " + board[row][col]);
                        } else {
                            System.out.println(
                                    "The valid Grid Values will be in range for row: 1 and 3 and for column: 1 and 3");
                        }
                    } else {
                        System.out.println("Enter only Integers!!");
                        sc.next();
                    }
                } else {
                    System.out.println("Enter only Integers!!");
                    sc.next();
                }
            }
            printBoard();
            won = checkwin();
            if (won) {
                System.out.println();
                System.out.println("---Player " + current + " wins!!---");
            } else if (isBoardFull()) {
                System.out.println(" ---The Game is tie---");
            } else {
                current = (current == 'X') ? 'O' : 'X';
            }
        }
        sc.close();
    }

    public static void printBoard() {
        System.out.println("     1   2   3");
        System.out.println("   -------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + (i + 1) + " " + "|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
                if (j < 3) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            System.out.println("   -------------");
        }
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkwin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == current && board[i][1] == current && board[i][2] == current) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == current && board[1][i] == current && board[2][i] == current) {
                return true;
            }
        }
        if (board[0][0] == current && board[1][1] == current && board[2][2] == current) {
            return true;
        }
        if (board[0][2] == current && board[1][1] == current && board[2][0] == current) {
            return true;
        }
        return false;
    }

    public static void displayRules() {
        char line = '-';
        int count = 109;
        System.out.println(" " + String.valueOf(line).repeat(count));
        System.out.println(
                " |                               Here are the Rules for Cross 'n' Noughts                                    |");
        System.out.println(" " + String.valueOf(line).repeat(count));
        System.out.println(
                " | 1. The game is Between Two players                                                                        |");
        System.out.println(" | 2. It is a 3X3 Grid game										     |");
        System.out.println(
                " | 3. Enter row value first then give space and enter column value					     |");
        System.out.println(
                " | 4. The valid Grid Values will be in range for row: 1 and 3 and for column: 1 and 3		             |");
        System.out.println(
                " | 5. Each player will get a chance alternatively to place their value in the grid                           |");
        System.out.println(
                " | 6. The objective is first who gets three of their marks in a row (horizontally , vertically , diagonally) |");
        System.out
                .println(" | 7. If there are no gird left out to fill then it is a Draw						     |");
        System.out.println(" " + String.valueOf(line).repeat(count));
    }
}