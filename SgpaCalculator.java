import java.util.*;

public class SgpaCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String garr[] = { "O", "A+", "A", "B+", "B", "C", "D" };
        int carr[] = { 10, 9, 8, 7, 6, 5, 4 };
        System.out.println("   SGPA Genius");
        int line=40;
        String design="-";
        while(true)
        {
            System.out.print("   Enter the number of Subjects      : ");
            int sub=sc.nextInt();
            if(sub>0)
            {
                String  userGrades[]=new String[sub];
                int userCredits[]=new int[sub];
                int creditIndex=0,gradeIndex=0,subindex=1,totalCredits=0,totalmark=0;
                while(sub>0)
                {
                    System.out.println(" "+String.valueOf(design).repeat(line));
                    System.out.print(" | Enter the grade of the subject "+subindex+"  : ");
                    String grade=sc.next().toUpperCase();
                    if(ValidGrade(garr,grade))
                    {
                        userGrades[gradeIndex++]=grade;
                        while(true)
                        {
                            System.out.print(" | Enter the credits of the subject "+subindex+": ");
                            int credits=sc.nextInt();
                            if(ValidCredit(credits))
                            {
                                userCredits[creditIndex++]=credits;
                                sub--;
                                subindex++;
                                for(int i=0;i<garr.length;i++)
                                {
                                    if(grade.equals(garr[i]))
                                    {
                                        int individualmark=carr[i]*credits;
                                        totalmark+=individualmark;
                                        totalCredits+=credits;
                                        break;
                                    }
                                }
                                break;
                            }
                            else
                            {
                                System.out.println("   Enter Valid Credits!!!");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("   Enter a Valid Grade!!!");
                    }
                }
                double sgpa=(double)totalmark/totalCredits;
                display(userCredits,userGrades,sgpa);
                break;
            }
            else
            {
                System.out.println("   Enter a Valid count for numnber of subjects!!!");
            }
        }
    }
    
    public static boolean ValidGrade(String garr[],String grade)
    {
        return Arrays.asList(garr).contains(grade);
    }
    
    public static boolean ValidCredit(int credits)
    {
        return credits>0 && credits<=5;
    }
    public static void display(int credits[],String grades[],double sgpa)
    {
        System.out.println(" "+String.valueOf("-").repeat(40));
        System.out.println();
        System.out.println("  "+String.valueOf("-").repeat(26));
        System.out.println(" |           SGPA           |");
        System.out.println("  "+String.valueOf("-").repeat(26));
        System.out.println(" |    Grade   |"+"  Credits    |");
        System.out.println("  "+String.valueOf("-").repeat(26));
        for(int i=0;i<credits.length;i++)
        {
            if(grades[i].length()==1)
                System.out.println(" |      "+grades[i]+"     |     "+credits[i]+"       |");
            else if(grades[i].length()==2)
                System.out.println(" |      "+grades[i]+"    |     "+credits[i]+"       |");
        }
        System.out.println("  "+String.valueOf("-").repeat(26));
        System.out.println(" |    CGPA    |    " + String.format("%.2f", sgpa) + "     |");
        System.out.println("  "+String.valueOf("-").repeat(26));
    }
}
