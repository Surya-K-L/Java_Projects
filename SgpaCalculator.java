import java.util.*;

public class SgpaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a[] = { "O", "A+", "A", "B+", "B", "C", "D" };
        int mark[] = { 10, 9, 8, 7, 6, 5, 4 };
        while (true) {
            System.out.print("Enter the total number of subjects: ");
            int n = sc.nextInt();
            if (n > 0) {
                int i = 0, j = 1, ans = 0, totalcredits = 0;
                while (n > 0) {
                    while (true) {
                        System.out.print("Enter the grade of subject " + j + ": ");
                        String grade = sc.next().toUpperCase();
                        if (Arrays.asList(a).contains(grade)) {
                            int q = 0;
                            while (true) {
                                System.out.print("Enter the credits of subject " + j + ": ");
                                int credits = sc.nextInt();
                                q = 0;
                                if (credits > 0 && credits <= 5) {
                                    q = 0;
                                    for (i = 0; i < a.length; i++) {
                                        if (grade.equals(a[i])) {
                                            int t = mark[i] * credits;
                                            ans += t;
                                            totalcredits += credits;
                                            n--;
                                            q = 1;
                                            j++;
                                            break;
                                        }
                                    }
                                    if (q == 1) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Enter a Valid Credits");
                                }
                            }
                            if (q == 1) {
                                break;
                            }
                        } else {
                            System.out.println("Enter a Valid Grade");
                        }
                    }
                }
                float sgpa = (float) ans / totalcredits;
                System.out.printf("SGPA:  %.2f", sgpa);
                return;
            } else {
                System.out.println("Enter a Valid Number for total Subjects");
            }
        }
    }
}