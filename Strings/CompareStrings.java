import java.util.Scanner;

public class CompareStrings {
    public static void compareStrings(String str1,String str2) {
        int comparison=str1.compareTo(str2);
        System.out.println(comparison<0?"'"+str1+"' comes before '"+str2+"' lexicographically.":comparison>0?"'"+str2+"' comes before '"+str1+"' lexicographically.":"Both strings are equal.");
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the first string:");
        String str1=scanner.nextLine();
        System.out.print("Enter the second string:");
        String str2=scanner.nextLine();
        compareStrings(str1,str2);
    }
}
