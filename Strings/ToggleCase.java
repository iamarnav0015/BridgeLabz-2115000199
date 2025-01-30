import java.util.Scanner;

public class ToggleCase {
    public static String toggleCase(String input) {
        StringBuilder toggled=new StringBuilder();
        for(char c:input.toCharArray()) {
            toggled.append(Character.isUpperCase(c)?Character.toLowerCase(c):Character.isLowerCase(c)?Character.toUpperCase(c):c);
        }
        return toggled.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a string to toggle case:");
        String input=scanner.nextLine();
        System.out.println("Toggled Case:"+toggleCase(input));
    }
}
