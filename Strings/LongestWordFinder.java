import java.util.Scanner;
public class LongestWordFinder {
    public static String findLongestWord(String sentence) {
        if(sentence==null||sentence.trim().isEmpty())return "No valid words found.";
        String[] words=sentence.split("\\s+");
        String longestWord="";
        for(String word:words) {
            if(word.length()>longestWord.length())longestWord=word;
        }
        return longestWord;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a sentence:");
        String sentence=scanner.nextLine();
        String longestWord=findLongestWord(sentence);
        System.out.println(longestWord.equals("No valid words found.")?longestWord:"The longest word is:'"+longestWord+"'");
    }
}
