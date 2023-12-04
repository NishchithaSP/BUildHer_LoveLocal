---> Approach 1 - Intuition 
  "Splitting and Retrieving Last Word Length"
  
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        return words[words.length-1].length();
    }
}

---> Approach 2 - By subtracting  
  "Trimming and Calculating Last Word Length"
  
class Solution {
    public int lengthOfLastWord(String s) {
       s = s.trim();
        return s.length()-s.lastIndexOf(" ")-1;
    }
}

---> Approach 3 - Backward looping 
"Backward Character Traversal for Last Word Length"

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
		
		// We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                length++;
            } else {  // it's a white space instead
				//  Did we already started to count a word ? Yes so we found the last word
                if (length > 0) return length;
            }
        }
        return length;
    }
}
