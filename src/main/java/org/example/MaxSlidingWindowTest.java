package org.example;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*

Purpose of i - k:
The deque is used to store the indices of array elements that are candidates for being the maximum in the current sliding window. The sliding window "slides" from left to right over the array.

Key Points:
Sliding Window Range:

For any index i, the sliding window is [i-k+1, i].
For example, if i = 4 and k = 3, the current window covers indices [2, 3, 4].
Detecting Out-of-Range Indices:

The index i-k represents the first index before the current sliding window.
If deque.peek() == i - k, it means the element at the front of the deque is no longer within the current window (it's "out of range").
Removing Out-of-Range Elements:

If deque.peek() == i - k, the element at the front of the deque should be removed because it is no longer part of the current window.
This ensures that all indices in the deque are within the bounds of the current window, and the element at the front of the deque is always the maximum within the current window.


------------------
The condition i >= k - 1 is used to determine when the first complete sliding window has been processed, and it's time to start recording the maximum values for each window in the result array.

Explanation:
Index i: This represents the current position in the array as you iterate through it.

Window Size k: This is the size of each sliding window.

Sliding Window Formation:

The sliding window starts forming at index 0 and continues to include subsequent elements until it reaches size k.
The first complete sliding window covers the indices from 0 to k-1.
Condition i >= k - 1:

This condition checks if the current index i is at least as large as k-1.
When i is equal to k-1, the first full window has been processed. Before this, the window is not fully formed, so there is no valid maximum to record.
For any i greater than or equal to k-1, the sliding window is fully formed, and the maximum value within this window can be determined and stored in the result array.

Function MaxSlidingWindow(arr, k):
    size = length of arr
    res = new array of size (size - k + 1)  // To store the results
    ri = 0  // Result index

    deque = new empty deque  // To store indices of useful elements

    Print the input array

    For i from 0 to size - 1:
        // Step 1: Remove elements out of the current window
        If deque is not empty AND deque.peek() == i - k:
            Print "Removing element out of window" with index i
            Remove the element at the front of the deque (deque.poll())

        // Step 2: Remove elements that are smaller than the current element
        While deque is not empty AND arr[deque.peekLast()] < arr[i]:
            Print "Removing smaller element in deque" with index i
            Remove the element at the end of the deque (deque.pollLast())

        // Step 3: Add the current element's index to the deque
        Add i to the end of the deque (deque.offer(i))
        Print the current state of the deque

        // Step 4: Record the maximum for the current window
        If i >= k - 1:
            Print "Recording result for window ending at index" i
            res[ri] = arr[deque.peek()]  // The element at the front of the deque is the maximum
            Increment ri by 1

    Return res

Function main():
    arr = [4, 0, -1, 3, 5, 3, 6, 8]  // Input array
    k = 3  // Window size
    Print the result of MaxSlidingWindow(arr, k)


*/


public class MaxSlidingWindowTest {


    public static int[] MaxSlidingWindow(int[] arr,int k ){
      int size=arr.length;
      int[] res=new int[size-k+1];
      int ri = 0;

      Deque< Integer > deque = new ArrayDeque < > ();
      System.out.println(Arrays.toString(arr));
      for (int i=0;i<size;i++){

          // remove numbers out of range k
          if(!deque.isEmpty() && deque.peek()==i-k)
          {
             System.out.println("!deque.isEmpty() && deque.peek()==i-k   "+i);
             deque.poll();
          }

          // remove smaller numbers in k range as they are useless
          while(!deque.isEmpty() && arr[deque.peekLast()]< arr[i])
          {
              System.out.println("!deque.isEmpty() && deque.peekLast()< arr[i] i "+i+" Last element "+deque.peekLast() +" the actual value "+arr[deque.peekLast()]);
              deque.pollLast();
          }

          deque.offer(i);
          System.out.println("deque    :"+deque);
          if(i>=k-1)
          {
              System.out.println(" The i value :"+i +" and "+deque.peek() +" the actual value "+arr[deque.peek()]);
              res[ri++]=arr[deque.peek()];
          }

      }
    return res;
    }

    public static void main(String[] args){
        int arr[]={4,0,-1,3,5,3,6,8};
        int k=3;
        System.out.println(Arrays.toString(MaxSlidingWindow(arr,k)));

    }
}
