package StringBuilderBuffer;

public class SearchWordInSentences {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is powerful.",
            "Python is simple.",
            "C++ is fast."
        };
        String word = "simple";
        String result = findSentence(sentences, word);
        System.out.println("Result: " + result);
    }
}

