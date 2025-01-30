public class ReplaceWord {
    public static String replaceWord(String sentence,String target,String replacement) {
        return sentence.replace(target,replacement);
    }

    public static void main(String[] args) {
        String sentence="The quick brown fox jumps over the lazy dog.";
        String target="fox";
        String replacement="cat";
        System.out.println("Original Sentence:"+sentence);
        System.out.println("Modified Sentence:"+replaceWord(sentence,target,replacement));
    }
}
