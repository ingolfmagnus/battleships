package inf101.v19.sem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {

    public static String readInputLine() {
        return readInputLine("");
    }

    public static String readInputLine(String prompt){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        try {
            return br.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public static void printBoard(Board theMap) {
        BoardPiece[][] pieceArray = theMap.getArray();
        System.out.println("\n   1 2 3 4 5 6 7 8 9 10");
        for (int y = 0; y < 10; y++) {
            System.out.print((char)('A'+y));System.out.print('|');
            for (int x = 0; x < 10; x++) {
                if (pieceArray[x][y] != null)
                    System.out.print(" " + pieceArray[x][y].getSymbol());
                else
                    System.out.print(" .");
            }
            System.out.println();
        }
    }
 }
