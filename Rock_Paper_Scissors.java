import java.util.*;

public class Rock_Paper_Scissors {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int aiwinner=0;
        int userwinner=0;
        displayRules();
        while(true)
        {
            int ai = rand.nextInt(3);
            String gamearray[]={"Stone","Paper","Scissors"};

            String aiPlayed=gamearray[ai];
            System.out.println(("-").repeat(35));
            int userValue=userInput(sc);
            String userPlayed=gamearray[userValue];
            if(aiPlayed.equals(userPlayed))
            {
                System.out.println("Match is a              : Tie");
                displayScore(userwinner, aiwinner);
            }
            else if((aiPlayed.equals("Scissors") && userPlayed.equals("Paper"))||(aiPlayed.equals("Paper") && userPlayed.equals("Stone"))||(aiPlayed.equals("Stone") && userPlayed.equals("Scissors")))
            {
                System.out.println("Winner is               : AI"); 
                aiwinner++;  
                displayScore(userwinner, aiwinner);
            }
            else
            {
                System.out.println("Winner is               : Player");
                userwinner++;
                displayScore(userwinner, aiwinner);
            }
            if(aiwinner==5)
            {
                System.out.println(("-").repeat(35));
                System.out.println("Player won              : "+userwinner);
                System.out.println("AI won                  : "+aiwinner);
                System.out.println("Over All Winner is      : AI");
                System.out.println(("-").repeat(35));
                break;
            }
            else if(userwinner==5)
            {
                System.out.println(("-").repeat(35));
                System.out.println("AI won                  : "+aiwinner);
                System.out.println("Player won              : "+userwinner);
                System.out.println("Over All Winner is      : Player");
                System.out.println(("-").repeat(35));
                break;
            }
        }


    }
    public static int userInput(Scanner sc)
    {
        while(true)
        {
            System.out.print("Enter Value from 1 to 3 : ");
            int userInput=sc.nextInt();
            if(userInput>0 && userInput<4)
            {
                return userInput-1;
            }
            else
            {
                System.out.println("Enter a valid number for playing!!!");
            }
        }
    }
    public static void displayScore(int userwinner, int aiwinner)
    {
        System.out.println("Player score            : "+userwinner);
        System.out.println("AI score                : "+aiwinner);
    }

    public static void displayRules()
    {
        System.out.println(" "+("-").repeat(58));
        System.out.println("|                   Rock_Paper_Scissors                    |");
        System.out.println(" "+("-").repeat(58));
        System.out.println("| 1.It is a single player Game                             |");
        System.out.println("| 2.The opponent will be an random number (AI)             |");
        System.out.println("| 3.Enter a Value between the range 1 and 3                |");
        System.out.println("| 4.Enter 1 for Stone                                      |");
        System.out.println("| 5.Enter 2 for Paper                                      |");
        System.out.println("| 6.Enter 3 for Scissors                                   |");
        System.out.println("| 7.Ater every value entered the winner will be displayed  |");
        System.out.println("| 8.Who scores 5 points first will be the overall winner   |");
        System.out.println(" "+("-").repeat(58));
    }
}