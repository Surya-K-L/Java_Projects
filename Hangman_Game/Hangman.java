import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Hangman {
    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner sc=new Scanner(new File("F:/Java Projects Git/Console.txt"));
        Scanner input=new Scanner(System.in);
        ArrayList<String> words =new ArrayList<>();
        while(sc.hasNext())
        {
            words.add(sc.nextLine().toLowerCase());
        }
        displayRules();

        Random rand=new Random();
        
        String word=words.get(rand.nextInt(words.size()));

        //System.out.print(word);

        ArrayList<Character>playerGuess=new ArrayList<>();
        int wrongCount=0;

        while(true)
        {
            printHangedMan(wrongCount);
            if(wrongCount>=6)
            {
                System.out.println("You Lose!");
                System.out.println("The word is : "+word);
                break;
            }
            printWord(word, playerGuess);
            if(!getPlayerGuess(input, word, playerGuess))
            {
                wrongCount++;
            }

            if(printWord(word, playerGuess))
            {
                System.out.println(("-").repeat(45));
                System.out.println("You Win!!");
                break;
            }
            System.out.print("Please enter your guess for the word: ");
            if(input.nextLine().equals(word))
            {
                System.out.println(("-").repeat(45));
                System.out.println("You Win!!");
                break;
            }
            else
            {
                System.out.println("Nope!! Please try again");
                System.out.println(("-").repeat(45));
            }
        }
        sc.close();
    }

    public static boolean printWord(String word,List<Character>playerGuess)
    {
        int correctCount=0;
        System.out.print("Guess the word:  ");
        for(int i=0;i<word.length();i++)
        {
            if(playerGuess.contains(word.charAt(i)))
            {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else
            {
                System.out.print("_");
            }
        }
        System.out.println();

        return (word.length()==correctCount);
    }


    public static boolean getPlayerGuess(Scanner input,String word,List<Character>playerGuess)
    {
        String letterGuess="";
        while(true)
        {
            System.out.print("Guess a letter: ");
            letterGuess=input.nextLine();
            char guessinput=letterGuess.charAt(0);
            if(playerGuess.contains(guessinput))
            {
                System.out.println("Already the character is entered");
            }
            else
            {
                playerGuess.add(letterGuess.charAt(0));
                break;
            }
        }
        return word.contains(letterGuess);
    }


    public static void printHangedMan(int wrongCount)
    {
        System.out.println(("-").repeat(45));
        //System.out.println();
        System.out.println(" ------- ");
            System.out.println(" |     | ");
            if(wrongCount>=1)
            {
                System.out.println(" O");
            }
            if(wrongCount>=2)
            {
                System.out.print("\\ ");
                if(wrongCount>=3)
                {
                    System.out.println("/");
                }
                else
                {
                    System.out.println("");
                }
            }
            if(wrongCount>=4)
            {
                System.out.println(" |");
            }
            if(wrongCount>=5)
            {
                System.out.print("/ ");
                if(wrongCount>=6)
                {
                    System.out.println("\\");
                }
                else
                {
                    System.out.println("");
                }
            }            
    }


    public static void displayRules()
    {
        System.out.println(" "+("-").repeat(96));
        System.out.println(" |                                   Rules for HANGMAN                                          |");
        System.out.println(" "+("-").repeat(96));
        System.out.println(" | 1.Java oriented words are in the guess word try to find it out.                              |");
        System.out.println(" | 2.There will be a word name Guess the word with underscore.                                  |");
        System.out.println(" | 3.User have to guess a character                                                             |");
        System.out.println(" | 4.If it is present in the word then it will be displayed in all possible places              |");
        System.out.println(" | 5.Now the user will be asked to enter the guess word if he knows he guess the word           |");
        System.out.println(" | 6.If it is correct it will display you win! else it will display nope please try again       |");
        System.out.println(" | 7.There will be a hangman for every wrong guess the one part of the man will be displayed    |");
        System.out.println(" | 8.There are only 6 wrong chances available if all the chances are over the hangman will hang |");
        System.out.println(" | 9.After it displays you lose it will display what the exact word that needs to be found      |");
        System.out.println(" "+("-").repeat(96));
    }
}