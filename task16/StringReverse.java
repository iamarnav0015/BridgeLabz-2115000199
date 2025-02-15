import java.util.Scanner;

public class StringReverse{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string");
        String input =scanner.nextLine();
        System.out.println("Reversed string :"+ reverseString(input));

    }

    public static String reverseString(String str) {
        StringBuilder sb =new StringBuilder(str);
        return sb.reverse().toString();

    }
}