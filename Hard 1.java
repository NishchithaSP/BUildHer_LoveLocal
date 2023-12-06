---> Using Deque(Double Ended Queue)
  
class Solution {
   public int[] maxSlidingWindow(int[] a, int k) {		
		int n = a.length;
		int[] r = new int[n-k+1]; //to store values
		int ri = 0;
		// Deque to store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range 
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
}

Space Complexity: O(n) 
  - Linear space due to the result array and deque.
Time Complexity: O(n) 
  - Linear time due to iterating through the input array and performing constant time operations within the loop.

/* Logic and Algorithm breakdown:

1. Initialization:
    -int n = a.length;: n holds the length of the input array a.
    -int[] r = new int[n - k + 1];: r is an array to store the maximum values within the sliding windows. Its length is determined by n - k + 1 because there are n - k + 1 possible windows of size k in an array of length n.
    -int ri = 0;: ri is an index variable to keep track of the position in the result array r.
    -Deque<Integer> q = new ArrayDeque<>();: q is a deque (double-ended queue) to store indices.

2. Sliding Window Processing:
    -The main for loop (for (int i = 0; i < a.length; i++) { ... }) iterates through each element in the input array a.

3. Maintaining the Deque:
    -while (!q.isEmpty() && q.peek() < i - k + 1) { q.poll(); }: This loop removes indices from the front of the deque (q) that are out of the current window range (i.e., indices that do not belong to the current window).
    -while (!q.isEmpty() && a[q.peekLast()] < a[i]) { q.pollLast(); }: This loop removes indices of smaller elements from the back of the deque within the window, as they won't be the maximum in the window.
    -q.offer(i);: Adds the current index i to the deque q.
 
4. Storing Maximum Values:
    -if (i >= k - 1) { r[ri++] = a[q.peek()]; }: If the current index i has reached a point where a complete window has been formed (i.e., i >= k - 1), it stores the maximum value within the window by accessing the element in the input array a at the index obtained from the front of the deque (q.peek()). It stores this maximum value in the result array r at index ri and increments ri.

5. Returning the Result:
    -return r;: Finally, it returns the array r containing the maximum values within each sliding window. */
