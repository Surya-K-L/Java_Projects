import java.util.*;

public class CGPA_Calculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CGPA Genius");
        System.out.println(("*").repeat(34));
        float totalgpa = 0;
        int totalsemster = 0;
        while (true) {
            System.out.print("Enter total number of semester: ");
            int semester = sc.nextInt();
            System.out.println(("*").repeat(34));
            totalsemster = semester;
            totalgpa = 0;
            int sem = 1;
            if (semester > 0) {
                while (semester > 0) {
                    System.out.print("Enter the gpa of semester " + sem + "   :");
                    float gpa = sc.nextFloat();
                    if (isValidgpa(Float.toString(gpa)) && gpa > 0 && gpa <= 10) {
                        totalgpa += gpa;
                        sem++;
                        semester--;
                    } else {
                        System.out.println("Enter a Valid number for gpa!!");
                        System.out.println(("*").repeat(34));
                    }
                }
                if (semester == 0) {
                    break;
                }
            } else {
                System.out.println("Enter a valid number of semester!!");
                System.out.println(("*").repeat(34));
            }
        }
        sc.close();
        displayCgpa(totalgpa, totalsemster);
    }

    public static boolean isValidgpa(String gpa) {
        try {
            Float.parseFloat(gpa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void displayCgpa(float totalgpa, int totalsemster) {
        float cgpa = totalgpa / totalsemster;

        System.out.println(("*").repeat(34));
        System.out.println("*      OverAll CGPA is : " + String.format("%.2f", cgpa) + "    *");
        System.out.println(("*").repeat(34));
    }
}