package ecutb;
import java.util.Scanner;
import java.lang.reflect.Array;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner assd = new Scanner(System.in);
        System.out.println("***Hangman***");
        Word asd = new Word("bajs");
        asd.tryGuess(assd.nextLine());
        asd.tryGuess(assd.nextLine());
        asd.tryGuess(assd.nextLine());
        asd.tryGuess(assd.nextLine());
        asd.tryGuess(assd.nextLine());
        asd.tryGuess(assd.nextLine());
        asd.tryGuess(assd.nextLine());
        asd.printGuessArr();
    }
}
