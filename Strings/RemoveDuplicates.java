import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        String result="";
        for(char c:input.toCharArray()) {
            if(result.indexOf(c)==-1)result+=c;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a string:");
        String input=scanner.nextLine();
        System.out.println("String after removing duplicates:"+removeDuplicates(input));
    }
}
