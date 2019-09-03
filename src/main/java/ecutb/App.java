package ecutb;
import java.util.Scanner;
import java.lang.reflect.Array;

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
                    HangMan game1 = new HangMan(word);
                    game1.playGame();
                default:
                    loop = false;
            }
        }

    }
}

