---> Approach 1 - Intuition 
  "Splitting and Retrieving Last Word Length"
  
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        return words[words.length-1].length();
    }
}

/* Logic Breakdown:

1.Trimming the String:
	s.trim(): Trims the input string s, removing any leading and trailing whitespace. This step ensures that any extra spaces at the start or end of the string are disregarded.

2.Splitting the Trimmed String:
	s.trim().split("\\s+"): Splits the trimmed string into an array of substrings (words) using the split() method.
	\\s+ is a regular expression that matches one or more whitespace characters (such as spaces, tabs, etc.). This pattern splits the string at spaces and separates individual words.

3.Accessing the Last Word:
	String[] words = s.trim().split("\\s+");: Stores the split words in the words array.
	words[words.length - 1]: Retrieves the last element (last word) from the words array using the array index words.length - 1.

4.Calculating the Length of the Last Word:
	return words[words.length - 1].length();: Returns the length of the last word obtained from the words array using the length() method of the String class.

Algorithm Overview:

-Trim the input string s to remove leading and trailing whitespace.
-Split the trimmed string into an array of words based on one or more whitespace characters.
-Retrieve the last word from the resulting array of words.
-Return the length of the last word as the final result.   */


---> Approach 2 - By subtracting  
  "Trimming and Calculating Last Word Length"
  
class Solution {
    public int lengthOfLastWord(String s) {
       s = s.trim();
        return s.length()-s.lastIndexOf(" ")-1;
    }
}

/* Logic Breakdown: 

1.Trimming the String:
	s.trim(): Trims the input string s, removing any leading and trailing whitespace. This step ensures that any extra spaces at the start or end of the string are ignored.

2.Finding the Last Word Length:
	s.length(): Retrieves the length of the trimmed string obtained from s.trim().
	s.lastIndexOf(" "): Finds the index of the last space character in the trimmed string.
	s.length() - s.lastIndexOf(" ") - 1: Calculates the length of the last word by subtracting the index of the last space from the total length of the trimmed string and then subtracting 1 more to account for the space itself.

Algorithm Overview:

-Trim the input string s to remove leading and trailing whitespace.
-Retrieve the length of the trimmed string.
-Find the index of the last space character within the trimmed string.
-Calculate the length of the last word by subtracting the index of the last space from the total length of the trimmed string.  */

	
---> Approach 3 - Backward looping 
"Backward Character Traversal for Last Word Length"

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { 
                length++;
            } else {  
                if (length > 0) return length;
            }
        }
        return length;
    }
}

/* Logic Breakdown:

1.Backward Traversal:
	for (int i = s.length() - 1; i >= 0; i--): Initiates a backward iteration through the characters of the input string s. The loop starts from the last character of the string and moves towards the beginning (i >= 0).

2.Finding the Last Word Length:
	if (s.charAt(i) != ' '): Checks if the character at index i is not a space. If it's a non-space character, the method increments the length variable, indicating the count of characters in the last word encountered so far.
	else { if (length > 0) return length; }: When a space character is encountered:
		If the length is greater than 0, it means that a word has already been encountered. The method returns the length, which represents the length of the last word found.

3.Returning Length:
	If no word is found (e.g., the input string has only spaces or no characters), the method returns the length, which would be 0 in such cases.

Algorithm Overview:

-Start iterating through the characters of the string s from the end.
-While iterating backward:
-Increment the length for each non-space character until a space is encountered.
-If a space is found and a word was encountered before (indicated by length > 0), return the length of the last word.
-If no word is found, return 0.   */
