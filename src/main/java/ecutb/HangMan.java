package ecutb;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HangMan {

    private String secretWord;

    public HangMan(String secretWord) {
        this.secretWord = secretWord;
    }

    public void playGame() {
        Word word = new Word(getSecretWord());
        Scanner myInput = new Scanner(System.in);
        int iGuesses = 0;

        do {
            System.out.println("1 to guess word, any to guess a letter");
            String s = myInput.nextLine();
            if(s.equals("1")) {
                System.out.println("guess your word");
                word.guessWord(myInput.nextLine().trim().toLowerCase());
            }else {
                System.out.println("guess your letter");
                word.tryGuess(myInput.nextLine().trim().toLowerCase());
            }
            if (!word.getMatch()) {
                iGuesses++;
            }
            if (Arrays.equals(word.getGuessArr(), word.getLetterArr())) {
                break;
            }
            System.out.println("\nGuesses used " + iGuesses + "/8");
            System.out.println("Guesses:" + word.getGuesses());
        } while (iGuesses < 8 || Arrays.equals(word.getGuessArr(), word.getLetterArr()));
        if (iGuesses == 8 && !Arrays.equals(word.getGuessArr(), word.getLetterArr())) {
            System.out.println("You lose!");
        }

    }

    public static String randomWord() {
        String[] wordArr = {"giraff", "elefant", "kamel", "get", "katt", "hund"};
        int maxVal = Array.getLength(wordArr);
        int indexArr = ThreadLocalRandom.current().nextInt(0, maxVal);
        return wordArr[indexArr];
    }

    public void startGame() {
        {
            System.out.println("******HANG MAN******");
            Scanner myInput = new Scanner(System.in);
            boolean loop = true;
            while (loop) {
                System.out.println("1 to play 1 player game with random word\n2 to play 2 player game \nAny to exit");
                String s = myInput.nextLine();
                switch (s) {
                    case "2":
                        System.out.println("Enter you secret word");
                        HangMan game = new HangMan(myInput.nextLine());
                        game.playGame();
                        break;
                    case "1":
                        HangMan game1 = new HangMan(randomWord());
                        game1.playGame();
                        break;
                    default:
                        loop = false;
                }
            }
        }
    }
    public String getSecretWord(){return secretWord;}

}

