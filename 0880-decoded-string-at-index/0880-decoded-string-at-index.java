class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0; // Total length of the decoded strin
        for (char character : s.toCharArray()) {
            if (Character.isDigit(character)) decodedLength *= (character - '0');
            else decodedLength++;
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                // If the character is a digit, adjust the length and k accordingly
                decodedLength /= (currentChar - '0');
                k %= decodedLength;
            } 
            else{
                // If the character is a letter, check if it's the kth character
                if (k == 0 || decodedLength == k) return String.valueOf(currentChar); // Return the kth character as a string
                decodedLength--;
            }
        }
        return ""; 
    }
}