import java.util.*;
public class Flames {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        RulesofGame();
        boolean validinput=false;
        while(true)
        {
            System.out.print("  Enter name of a Boy  : ");
            String firstname = sc.nextLine().toLowerCase().replaceAll("\\s+","");
            String fname=""+Character.toUpperCase(firstname.charAt(0))+firstname.substring(1,firstname.length());
            if(ValidName(firstname))
            {
                System.out.println();
                while(true)
                {
                    System.out.print("  Enter name of a Girl : ");
                    String secondname = sc.nextLine().toLowerCase().replaceAll("\\s+","");
                    String sname=""+Character.toUpperCase(secondname.charAt(0))+secondname.substring(1,secondname.length());
                    if(ValidName(secondname))
                    {
                        int count=RemoveCommon(firstname,secondname);
                        String Answer=FindFlames(count);
                        String OutputAnswer=Answer.equals("F")?"Friend":Answer.equals("L")?"Love":Answer.equals("A")?"Affection":Answer.equals("M")?"Marriage":Answer.equals("E")?"Enemy":"Siblings";
                        validinput=printRelation(fname, sname, OutputAnswer);
                        System.out.println();
                        break;
                    }
                    else
                    {
                        System.out.println("  Enter a Valid Name!!!");
                        System.out.println(" "+("-").repeat(55));
                    }
                }
            }
            else
            {
                System.out.println("  Enter a Valid Name!!!");
                System.out.println(" "+("-").repeat(55));
            }
            if(validinput==true)
            {
                break;
            }
        }
        sc.close();
    }

    public static int RemoveCommon(String a,String b)
    {
        String rep = "";
        for (int i = 0; i < a.length(); i++) 
        {
            rep = "";
            rep += a.charAt(i);
            if(b.contains(rep))
            {
                b = b.replaceFirst(rep, "");
                a = a.replaceFirst(rep,"");
                i--;
            }
        }
        return a.length()+b.length();
    }

    public static String FindFlames(int count)
    {
        String s="FLAMES";
        int len=s.length();
        ArrayList<Character>al=new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            al.add(s.charAt(i));
        }
        while(len!=1)
        {
               Collections.rotate(al,-count+1);
               al.remove(0);
               len=al.size(); 
        }
        String p=""+al.get(0);
        return p;
    }

    public static void RulesofGame()
    {
        System.out.println(" "+("-").repeat(65));
        System.out.println(" |                            FLAMES GAME                         |");
        System.out.println(" "+("-").repeat(65));
        System.out.println(" | 1.Enter the Name of a Boy                                      |");
        System.out.println(" | 2.Enter the Name of a Girl                                     |");
        System.out.println(" | 3.This program will just guess the relationship between them   |");
        System.out.println(" "+("-").repeat(65));
        System.out.println();
    }

    public static boolean ValidName(String name)
    {
        if(name==null ||name.trim().isEmpty())
        {
            return true;
        }
        String validate="^[a-zA-Z\\s]+$";
        if(!name.matches(validate))
        {
            return false;
        }
        if(name.length()<2 ||name.length()>50)
        {
            return false;
        }
        return true;
    }

    public static boolean printRelation(String firstname,String secondname,String Answer)
    {
        System.out.println();
        System.out.println(" "+("-").repeat(60));
        System.out.println("  The relationship between "+firstname+" and "+secondname+" is : "+Answer);
        System.out.println(" "+("-").repeat(60));
        return true;
    }
}
