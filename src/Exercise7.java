import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

public class Exercise7 {

    public static void printBoard(char[] chars) {
        for (int i = 0; i < 9; i++) {
            System.out.print(chars[i] + " ");
            if ((i+1) % 3 == 0) {
                System.out.println();
            }

        }
    }

    public static boolean isAvailable(char[] chars, int location) {

        return chars[location] != 'O' && chars[location] != 'X';

    }

    public static int getPositionFromUser() {
        int position;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter location: ");
        do {
            position = scanner.nextInt();
            if (position < 1 || position > 9) {
                System.out.print("Invalid number try again! ");
            }
        } while (position < 1 || position > 9);

        return position-1;
    }

    public static char checkWinner(char[] chars) {

        // 0 1 2 | 3 4 5 | 6 7 8
        // 0 3 6 | 1 4 7 | 2 5 8
        // 0 4 8 | 2 4 6

        // Checking the rows!
        for (int i = 0; i < 3; i++) {
            if (chars[0+i*3] == chars[1+i*3] && chars[1+i*3] == chars[2+i*3]) {
                return chars[0+i*3];
            }
        }

        // Checking the columns!
        for (int i = 0; i < 3; i++) {
            if (chars[0+i] == chars[3+i] && chars[3+i] == chars[6+i]) {
                return chars[0+i];
            }
        }

        // Checking diagonals!

        if (chars[0] == chars[4] && chars[4] == chars[8]){
                return chars[0];
        }

        if (chars[2] == chars[4] && chars[4] == chars[6]){
            return chars[0];
        }

        return '-';

    }

    public static boolean placeSymbolOnBoard(char[] chars, int location, char ch) {

        chars[location] = ch;

        char isWon = checkWinner(chars);

        if (isWon == 'O' || isWon == 'X') {
            System.out.println(isWon + " Won the game!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] chars = new char[9];
        for (int i = 0; i < 9; i++) {
            chars[i] = ' ';
        }

        boolean win = false;
        int turns = 0;
        int location;

        boolean isNotFullBoard = true;

        while (!win && isNotFullBoard) {

            System.out.println("-----------------");
            if (turns % 2 == 0) {
                // X turn

                do {
                    location = getPositionFromUser();
                    if (!isAvailable(chars, location)) {
                        System.out.println("TAKEN, TRY AGAIN!");
                    }
                } while (!isAvailable(chars, location));

                win = placeSymbolOnBoard(chars, location, 'X');
                printBoard(chars);

            }
            else {
                // O turn
                do {
                    location = getPositionFromUser();
                    if (!isAvailable(chars, location)) {
                        System.out.println("TAKEN, TRY AGAIN!");
                    }
                } while (!isAvailable(chars, location));

                win = placeSymbolOnBoard(chars, location, 'O');
                printBoard(chars);
            }
            turns++;

            isNotFullBoard = false;
            for (int i = 0 ; i < 9; i++) {
                if (chars[i] == ' ') {
                    isNotFullBoard = true;
                }
            }

        }
    }
}

