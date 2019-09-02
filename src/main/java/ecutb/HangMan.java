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
            iGuesses++;
            word.tryGuess(myInput.nextLine());
            if(Arrays.equals(word.getGuessArr(), word.getLetterArr())){break;}
            System.out.println("Guesses used "+iGuesses+"/8");
        }while(iGuesses<8);

    }

    public String getSecretWord(){
        return secretWord;
    }
}
