import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map each letter ('a' through 'z') to its keyboard row index (0, 1, or 2)
        int[] charToRow = new int[26];
        
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };
        
        for (int r = 0; r < rows.length; r++) {
            for (char c : rows[r].toCharArray()) {
                charToRow[c - 'a'] = r;
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            int targetRow = charToRow[lower.charAt(0) - 'a'];
            boolean isValid = true;
            
            for (int i = 1; i < lower.length(); i++) {
                if (charToRow[lower.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
