import java.util.Scanner;

public class CountVowelsConsonants {
    public static void countVowelsAndConsonants(String input) {
        int vowels=0, consonants=0;
        input=input.toLowerCase();

        for(char c:input.toCharArray()) {
            if(c>='a'&&c<='z') {
                if("aeiou".indexOf(c)!=-1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: "+vowels+", Consonants: "+consonants);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input=scanner.nextLine();
        countVowelsAndConsonants(input);
    }
}