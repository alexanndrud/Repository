import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Hangman {


    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int option;
        System.out.println("Hello!");

        //choose option
        System.out.println("Please choose an option:");
        System.out.println();
        System.out.println("1. Play Game");
        System.out.println("2. Instructions");
        System.out.println();
        System.out.println("0.For Exit");
        System.out.println();
        System.out.println("Intoduce your option:");
        option = scan.nextInt();
        do {

            if (option == 0)
                break;
            else if (option == 1) {
                playGame();
                break;
            } else if (option == 2) {
                instructionsTxt();
                break;
            } else if (option > 2) {
                System.err.println("You introduced an invalid option, please try again. ");
                option = scan.nextInt();
            }
        } while (option != 0);
    }

    private static void instructionsTxt() {
        try {
            File myObj = new File("C:\\Users\\george.dobrota\\Desktop\\java core\\hangman\\src\\instructions.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        menu();
    }

    public static String[] words = new String[]{"car","dog","house","computer"};
    public  static void playGame() {

        String unused = "abcdefghijklmnopqrstuvwxyz";

        String randomWord = words[(int) (Math.random() * words.length)];

        System.out.println("The word has " + randomWord.length() + " letters.");

        char[] letters = new char[randomWord.length()];

        for (int i = 0; i < letters.length; i++) {
            letters[i] = '_';
        }

        int lives = 3;

        Scanner scanner = new Scanner(System.in);

        while (lives > 0) {
            System.out.print("Lives: ");

            for (int i = 0; i < lives; i++) {
                System.out.print("o");
            }

            System.out.println();

            System.out.println("Input: ");

            String input = scanner.nextLine();

            char letter = input.charAt(0);

            boolean isGuess = false;

            for (int i = 0; i < randomWord.length(); i++) {
                char l = randomWord.charAt(i);

                if (l == letter) {
                    letters[i] = l;
                    isGuess = true;
                }
            }

            if (!isGuess) {
                lives = lives - 1;
            }

            boolean isFinished = true;

            System.out.print("Word: ");

            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == '_') {
                    isFinished = false;
                }

                System.out.print(letters[i]);
            }

            System.out.println();

            unused = unused.replace(letter, '*');

            System.out.println("Unused letters: " + unused);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

            if (isFinished) {
                System.out.println("You won!");
                break;
            }
        }

        if (lives == 0) {
            System.out.println("You lost! Correct word: " + randomWord);
        }


    }

    public static void main(String[] args) {
        menu();
    }
}