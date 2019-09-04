package ecutb;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.concurrent.ThreadLocalRandom;

public class App
{
    public static void main( String[] args )
    {
        Scanner myInput = new Scanner(System.in);
        String s = myInput.nextLine();
        String word = "bajs";
        boolean loop = true;
        while(loop) {
            switch (s) {
                case "1":
                    HangMan game = new HangMan(word);
                    game.playGame();
                case "2":
                    HangMan game1 = new HangMan(randomWord());
                    game1.playGame();
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

