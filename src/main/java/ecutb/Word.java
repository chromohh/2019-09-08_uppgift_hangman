package ecutb;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Word {

    private char[] letterArr;
    private char[] guessArr;
    private StringBuilder addGuesses = new StringBuilder();
    private String guesses;
    boolean match;

    public Word(String mainWord){
        this.letterArr = mainWord.toCharArray();
        this.guessArr = new char[Array.getLength(letterArr)];
        this.guesses = "";

    }

    public void tryGuess(String input){
        boolean loop = true;
        Scanner myInput = new Scanner(System.in);
        while(loop){
            if(input.length() > 1){
               System.out.println("Input only one letter. try again.");
               input = myInput.nextLine().trim().toLowerCase();
            }
            if(guesses.contains(input)){
                System.out.println("Letter is already guessed, try again");
                input = myInput.nextLine().trim().toLowerCase();
            }else if(!guesses.contains(input) && input.length() == 1){
                loop = false;
                char a = input.charAt(0);
                compareInput(a);
            }
            }
            if(input.length() == 1){
                loop = false;
                if(!guesses.contains(input)){
                  addGuesses.append(guesses + input);
                  setGuesses(addGuesses.toString());
                }
            }
    }

    public void compareInput(char input){
        boolean wasFound = false;
        match = true;
        for(int i = 0; i < Array.getLength(letterArr); i++){
            if(input == letterArr[i]){
                guessArr[i] = input;
                System.out.println("Letter was found!");
                wasFound = true;
            }else if('\u0000' == guessArr[i]){
                guessArr[i] = '_';
            }
        }
        if(!wasFound)
        {
            System.out.println("Letter was not found");
            match = false;
        }
        printGuessArr();
        setGuessArr(guessArr);
    }

    public void setGuessArr(char [] a){
        this.guessArr = a;
    }

    public void printGuessArr(){
        System.out.println("****Current standing****");
        for(int i = 0; i < Array.getLength(guessArr); i++){
            System.out.print(guessArr[i]);
        }
        if(Arrays.equals(guessArr, letterArr)){
            System.out.println("\nYou won! Congrats =)");
        }
    }

    public void setGuesses(String b)
    {
        this.guesses = b;
    }

    public boolean guessWord(String word){
        match = false;
        if(Arrays.equals(word.toCharArray(), letterArr)){ setGuessArr(word.toCharArray()); match = true; printGuessArr(); return true; }
       printGuessArr();
        return false;
    }


    public char[] getLetterArr() {
        return letterArr;
    }

    public char[] getGuessArr() {
        return guessArr;
    }


    public boolean getMatch(){return match;}
}
