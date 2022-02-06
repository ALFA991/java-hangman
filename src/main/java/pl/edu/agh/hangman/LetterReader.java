package pl.edu.agh.hangman;
import java.util.Scanner;

public class LetterReader {
    public char readLetter() {
        char letter;
        Scanner input = new Scanner(System.in);
        letter = input.next().charAt(0);
        return letter;
    }
}