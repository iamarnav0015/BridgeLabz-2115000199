import java.util.Scanner;

public class AnagramCheck {
    public static String replaceWord(String sentence,String target,String replacement) {
        return sentence.replace(target,replacement);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the sentence:");
        String sentence=scanner.nextLine();
        System.out.print("Enter the target word to replace:");
        String target=scanner.next();
        System.out.print("Enter the replacement word:");
        String replacement=scanner.next();
        System.out.println(sentence.contains(target)?"Original Sentence:"+sentence+"\nModified Sentence:"+replaceWord(sentence,target,replacement):"The target word '"+target+"' was not found in the sentence.");
    }
}
