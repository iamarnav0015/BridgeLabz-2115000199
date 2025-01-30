import java.util.Scanner;

public class SubstringOccurrence {
    public static int countSubstringOccurrences(String input,String substring) {
        int count=0,index=0;
        while((index=input.indexOf(substring,index))!=-1) {
            count++;
            index+=substring.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the main string:");
        String input=scanner.nextLine();
        System.out.print("Enter the substring to count:");
        String substring=scanner.nextLine();
        System.out.println(substring.isEmpty()?"The substring cannot be empty.":"The substring '"+substring+"' occurs "+countSubstringOccurrences(input,substring)+" time(s) in the main string.");
    }
}
