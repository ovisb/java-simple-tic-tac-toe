package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int maxsize = 3;

        System.out.println("-".repeat(input.length()));
        for (int i = 0; i < input.length(); i += maxsize) {
            System.out.print("| ");
            for (int j = i; j < i + maxsize ; j++) {
                System.out.printf("%c ", input.charAt(j));
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-".repeat(input.length()));
    }
}
