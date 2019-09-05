package ecutb;
import java.util.Arrays;
import java.util.Scanner;

public class HangMan {

    private String secretWord;

    public HangMan(String secretWord){
        this.secretWord = secretWord;
    }

    public void playGame(){
        Word word = new Word(getSecretWord());
        Scanner myInput = new Scanner(System.in);
        int iGuesses = 0;

        do{
            System.out.println("Guess a letter");
            word.tryGuess(myInput.nextLine().trim().toLowerCase());
            if(!word.getMatch()){iGuesses++;}
            if(Arrays.equals(word.getGuessArr(), word.getLetterArr())){break;}
            System.out.println("\nGuesses used "+iGuesses+"/8");
        }while(iGuesses<8 || Arrays.equals(word.getGuessArr(), word.getLetterArr()));
        if(iGuesses == 8 && !Arrays.equals(word.getGuessArr(), word.getLetterArr())){
            System.out.println("You lose!");
        }

    }

    public String getSecretWord(){
        return secretWord;
    }
}
