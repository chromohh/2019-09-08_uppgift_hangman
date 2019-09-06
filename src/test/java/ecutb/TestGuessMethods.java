package ecutb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

public class TestGuessMethods {
    private Word testWord;

    @Before
     public void init(){
        testWord = new Word("kattapa");
    }

    @Test
    public void compareInput_Test(){
        char test1 = 'k';
        char test2 = 'a';
        char test3 = 'b';
        char[] expected = {'k','a','_','_','a','_','a'};
        testWord.compareInput(test1);
        testWord.compareInput(test2);
        testWord.compareInput(test3);

        Assert.assertArrayEquals(expected, testWord.getGuessArr());
        //testar så att metoden skapar en char array där de gissade bokstäverna plus "_" på de tomma platserna läggs till. Samt att en bokstav som inte finns inte läggs till.
    }

    @Test
    public void guessWord_test (){

        char[] expected = "kattapa".toCharArray();

        testWord.guessWord("kattapa"); //först testar den det korrekta ordet
        testWord.guessWord("stålmannen"); //sen ett felaktikt så att det inte byts ut.

        Assert.assertArrayEquals(expected, testWord.getGuessArr());

        //testar metoden för att gissa hela ordet, samt att man inte kan gissa fel ord
    }


}
