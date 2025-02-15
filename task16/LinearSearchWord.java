
public class LinearSearchWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Java is a popular programming language.",
                "Artificial intelligence is evolving rapidly.",
                "Learning to code improves problem-solving skills."
        };

        String wordToFind = "Java";
        String result = findSentenceWithWord(sentences, wordToFind);
        System.out.println("Sentence containing '" + wordToFind + "': " + result);
    }
}

