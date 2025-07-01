// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// n= number of meetings
/*Approach : To determine the minimum number of meeting rooms required, we first sort the meeting times by their start times. 
Using a min-heap, we track the end times of ongoing meetings. For each meeting, if the earliest ending meeting in the heap ends 
before or when the current meeting starts, we remove it from the heap, indicating that the room can be reused. We then add the 
current meeting's end time to the heap. The size of the heap at the end represents the minimum number of meeting rooms needed, 
as it reflects the maximum number of overlapping meetings at any point. */
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Test case 1
        int[][] meetingTime = {{0, 30}, {5, 15}, {20, 30}};
        int min = helper(meetingTime);
        System.out.println("Min Meeting Rooms == " + min);

        // Test case 2
        int[][] meetingTime1 = {{0, 30}, {10, 15}, {10, 30}};
        min = helper(meetingTime1);
        System.out.println("Min Meeting Rooms == " + min);

        // Test case 3
        int[][] meetingTime2 = {{0, 30}, {10, 15}, {15, 30}};
        min = helper(meetingTime2);
        System.out.println("Min Meeting Rooms == " + min);
    }

    public static int helper(int[][] meetingTime) {
        // Sort the meeting times based on the start time
        Arrays.sort(meetingTime, (a, b) -> a[0] - b[0]);

        // Min-heap to keep track of the end times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through each meeting time
        for (int[] time : meetingTime) {
            // If the earliest ending meeting ends before or when the current meeting starts
            if (!minHeap.isEmpty() && minHeap.peek() <= time[0]) {
                minHeap.poll(); // Remove the earliest ending meeting
            }
            // Add the current meeting's end time to the heap
            minHeap.add(time[1]);
        }

        // The size of the heap is the number of meeting rooms required
        return minHeap.size();
    }
}
