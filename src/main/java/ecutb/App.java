package ecutb;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.concurrent.ThreadLocalRandom;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("******HANG MAN******");
        Scanner myInput = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
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

    public static String randomWord(){
        String[] wordArr = {"giraff", "elefant", "kamel", "get", "katt", "hund"};
        int maxVal = Array.getLength(wordArr);
        int indexArr = ThreadLocalRandom.current().nextInt(0, maxVal);
        return wordArr[indexArr];
    }
}

