public class MostFrequentChar {
    public static void main(String[] args) {
        String s = "hello world";
        char ans = find(s);
        System.out.println("Most frequent character: " + ans);
    }
    public static char find(String s){
        int[] freq = new int[256]; // Assuming ASCII characters
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        char mostFrequent = s.charAt(0);
        int maxCount = freq[mostFrequent];
        
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (freq[currentChar] > maxCount) {
                maxCount = freq[currentChar];
                mostFrequent = currentChar;
            }
        }
        
        return mostFrequent;
    }
    
}
