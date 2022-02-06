package pl.edu.agh.hangman;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Hangman {
    private static String word;
    private static String asterisk;
//    private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0;
    private static boolean gameOver = true;

    public Hangman(String word) {
        this.word = word;
        this.asterisk = new String(new char[word.length()]).replace("\0", "*");
    }

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };
    public static void hang(String guess) {
        String newasterisk = "";

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            count++;
            if (count == 6 ){
                gameOver = false;
                System.out.println("GAME OVER");
            }

            System.out.println(HANGMANPICS[count]);
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(word)) {
            System.out.println("Correct! You win! The word was " + word);
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println(HANGMANPICS[0]);
        ReadFileFromResourcesUsingGetResourceAsStream File = new ReadFileFromResourcesUsingGetResourceAsStream();
        String wordToFind = File.getRandomLine(File.GetFullFilePath("slowa.txt"));


        //System.out.println(wordToFind);
        Hangman game = new Hangman(wordToFind);
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (gameOver && asterisk.contains("*")) {
            System.out.println("Guess any letter in the word");
            System.out.println(asterisk);
            String guess = sc.next();
            game.hang(guess);

        }
        sc.close();


    }

}
