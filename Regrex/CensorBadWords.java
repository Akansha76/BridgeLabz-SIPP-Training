public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        for (String bad : badWords) {
            input = input.replaceAll("(?i)" + bad, "****"); // (?i) makes it case-insensitive
        }

        System.out.println(input);
    }
}
