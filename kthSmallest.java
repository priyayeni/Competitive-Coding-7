// Time Complexity : O(n2logk)
// Space Complexity : O(k)
/* Approach : The approach involves using a max-heap (priority queue) to keep track of the k smallest elements in the matrix. 
We iterate through each element of the matrix, adding elements to the heap until it contains k elements. For each subsequent element, 
if it is smaller than the largest element in the heap, we replace the largest element with the current one. This ensures that the heap 
always contains the k smallest elements encountered so far. Finally, the root of the heap will be the k-th smallest element in the matrix. This method efficiently narrows down the k-th smallest element by leveraging the properties of the max-heap.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return 0; // If the matrix is empty, return 0

        // Create a max-heap (priority queue) to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Iterate through each element in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maxHeap.size() < k) {
                    // If the heap has less than k elements, add the current element
                    maxHeap.add(matrix[i][j]);
                } else if (matrix[i][j] < maxHeap.peek()) {
                    // If the current element is smaller than the largest element in the heap
                    maxHeap.poll(); // Remove the largest element
                    maxHeap.add(matrix[i][j]); // Add the current element
                } else {
                    // Since the rest of the row will only be bigger, break the inner loop
                    break;
                }
            }
        }
        // The root of the heap is the kth smallest element
        return maxHeap.peek();
    }
}
