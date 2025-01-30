import java.util.Scanner;

public class MostFrequentCharacter {
    public static char findMostFrequentCharacter(String input) {
        if(input==null||input.isEmpty())throw new IllegalArgumentException("Input string cannot be empty.");
        int[] frequency = new int[256]; // Assuming ASCII characters
        for(char c:input.toCharArray())frequency[c]++;
        char mostFrequent=input.charAt(0);
        int maxCount=0;
        for(int i=0;i<256;i++) {
            if(frequency[i]>maxCount) {
                mostFrequent=(char)i;
                maxCount=frequency[i];
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a string:");
        String input=scanner.nextLine();
        try {
            char result=findMostFrequentCharacter(input);
            System.out.println("The most frequent character is:'"+result+"'");
        } catch(IllegalArgumentException e) {
            System.out.println("Error:"+e.getMessage());
        }
    }
}
