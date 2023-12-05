---> Approach 1 - HashMap Solution
  
 class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

Time complexity: O(n+k)
      Constructing the countMap HashMap by iterating through the array takes O(n) time, where n is the length of the input array nums.
      Iterating through the HashMap to identify majority elements takes O(k) time, where k is the number of distinct elements in the countMap.
Space complexity: O(n)
      The space complexity is O(k), where k represents the number of distinct elements in the input array, due to the storage of elements and their counts in the countMap.
      The result list can also contribute to space complexity but won't exceed O(k) because it stores the majority elements identified.
  
/*  Logic and Algorithm breakdown
  
1. Initializing Variables:
      -Create an ArrayList named result to store the elements that appear more than ⌊n/3⌋ times in the input array.
      -Check if the input array nums is null or empty. If so, return an empty result list.

2. Counting Occurrences using HashMap:
      -Create a HashMap named countMap to store the count/frequency of each element in the input array.
      -Iterate through the nums array:
          -For each element num in the array:
              -Check if the element is already present in the countMap.
              -If present, increment its count by 1 using countMap.getOrDefault(num, 0) + 1.
              -If not present, add the element to the countMap with a count of 1.

3.Identifying Majority Elements:
      -Iterate through the entries in the countMap HashMap using countMap.entrySet().
      -For each entry (element and its count) in the HashMap:
          -Check if the count of the element is greater than ⌊n/3⌋.
          -If the count is greater, add the element to the result list.

4. Return Result:
  -Return the result list containing the elements that occur more than ⌊n/3⌋ times in the input array.
*/


---> Approach 2 - Boyer-Moore Voting Algorithm

  class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}

Time Complexity: O(n)
    The algorithm performs two passes through the array. Both passes operate in linear time, so the time complexity is O(n), where n is the length of the input array nums.
Space Complexity: O(1)
    The space complexity is O(1) as the algorithm uses only a constant amount of extra space for variables and the result list.

/* Logic and Algorithm breakdown 

1. Initialize two variables candidate1 and candidate2 to None, and two counters count1 and count2 to 0.
2. Iterate through the array.
3. For each element num in the array:
      -If num is equal to candidate1, increment count1.
      -If num is equal to candidate2, increment count2.
      -If count1 is 0, set num as candidate1 and increment count1.
      -If count2 is 0, set num as candidate2 and increment count2.
      -If neither of the above conditions is met, decrement count1 and count2.
4. Initialize count1 and count2 to 0.
5. Iterate through the array again.
6. For each element num in the array:
      -If num is equal to candidate1, increment count1.
      -If num is equal to candidate2, increment count2.
7. Check if count1 and count2 are greater than ⌊n/3⌋. If they are, both candidates are potential majority elements.
8. Iterate through the array again and count the occurrences of candidate1 and candidate2.
9. Return the candidates that meet the majority criteria.*/
