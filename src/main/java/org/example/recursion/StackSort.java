package org.example.recursion;
import java.util.Arrays;
import java.util.Stack;
public class StackSort {

    public static void insertSort(Stack<Integer> stk,int first)
    {

        if(stk.isEmpty() || first>stk.peek())
        {
            System.out.println("insertSort "+ Arrays.toString(stk.toArray()));
            stk.push(first);
            System.out.println("insertSort "+ Arrays.toString(stk.toArray()));
            return;
        }

        int temp=stk.pop();
        insertSort(stk,first);
        stk.push(temp);

    }
    public static void sortStack(Stack<Integer> stk){
        //base case
        if(stk.isEmpty() ){
            System.out.println("    sortStack stk.isEmpty() "+ Arrays.toString(stk.toArray()));
            return;
        }

        int first=stk.pop();
        //Hypothesis
        System.out.println("    sortStack "+ Arrays.toString(stk.toArray()));
        sortStack(stk);

        //induction
        //When the base condition is met then induction step will be executed for stack frames.
        insertSort(stk,first);
    }

    public static void main(String[] args)
    {
        Stack<Integer> stk=new Stack();
        stk.push(5);
        stk.push(4);
        stk.push(2);
        stk.push(3);
        stk.push(1);
        System.out.println("Main "+ Arrays.toString(stk.toArray()));

        sortStack(stk);
        System.out.println("Main "+ Arrays.toString(stk.toArray()));

        int top=stk.peek();
                System.out.println("the top element is "+top);

    }
}


/*
Initial Call to sortStack([5, 4, 2, 3, 1]):
1. First sortStack Call:
    * Stack Input: [5, 4, 2, 3, 1]
    * Popped Value (first): 1
    * Stack After Pop: [5, 4, 2, 3]
    * Next Action: Call sortStack([5, 4, 2, 3])
Nesting Begins:
2. Second sortStack Call:
    * Stack Input: [5, 4, 2, 3]
    * Popped Value (first): 3
    * Stack After Pop: [5, 4, 2]
    * Next Action: Call sortStack([5, 4, 2])
3. Third sortStack Call:
    * Stack Input: [5, 4, 2]
    * Popped Value (first): 2
    * Stack After Pop: [5, 4]
    * Next Action: Call sortStack([5, 4])
4. Fourth sortStack Call:
    * Stack Input: [5, 4]
    * Popped Value (first): 4
    * Stack After Pop: [5]
    * Next Action: Call sortStack([5])
5. Fifth sortStack Call:
    * Stack Input: [5]
    * Popped Value (first): 5
    * Stack After Pop: []
    * Next Action: Call sortStack([])
6. Sixth sortStack Call (Base Case):
    * Stack Input: []
    * Base Case Reached: The stack is empty, so the function returns.
Unwinding and Induction:
Now, as the recursion unwinds, the first values are reinserted back into the stack in the correct order using insertSort. Let's see how this works:
1. Returning from sortStack([]) to sortStack([5]):
    * Popped Value (first): 5
    * Stack Before insertSort: []
    * Action: Call insertSort([], 5)
    * Stack After insertSort: [5]
    * Stack Frame Unwinds: Control returns to the sortStack([5]) frame.
2. Returning from sortStack([5]) to sortStack([5, 4]):
    * Popped Value (first): 4
    * Stack Before insertSort: [5]
    * Action: Call insertSort([5], 4)
    * Stack After insertSort: [4, 5]
    * Stack Frame Unwinds: Control returns to the sortStack([5, 4]) frame.
3. Returning from sortStack([5, 4]) to sortStack([5, 4, 2]):
    * Popped Value (first): 2
    * Stack Before insertSort: [4, 5]
    * Action: Call insertSort([4, 5], 2)
    * Stack After insertSort: [2, 4, 5]
    * Stack Frame Unwinds: Control returns to the sortStack([5, 4, 2]) frame.
4. Returning from sortStack([5, 4, 2]) to sortStack([5, 4, 2, 3]):
    * Popped Value (first): 3
    * Stack Before insertSort: [2, 4, 5]
    * Action: Call insertSort([2, 4, 5], 3)
    * Stack After insertSort: [2, 3, 4, 5]
    * Stack Frame Unwinds: Control returns to the sortStack([5, 4, 2, 3]) frame.
5. Returning from sortStack([5, 4, 2, 3]) to sortStack([5, 4, 2, 3, 1]):
    * Popped Value (first): 1
    * Stack Before insertSort: [2, 3, 4, 5]
    * Action: Call insertSort([2, 3, 4, 5], 1)
    * Stack After insertSort: [1, 2, 3, 4, 5]
    * Stack Frame Unwinds: Control returns to the final sortStack([5, 4, 2, 3, 1]) frame.
Summary of Stack Frames with first Values:
* First sortStack([5, 4, 2, 3, 1]): Popped 1, stack is [5, 4, 2, 3].
* Second sortStack([5, 4, 2, 3]): Popped 3, stack is [5, 4, 2].
* Third sortStack([5, 4, 2]): Popped 2, stack is [5, 4].
* Fourth sortStack([5, 4]): Popped 4, stack is [5].
* Fifth sortStack([5]): Popped 5, stack is [].
* Sixth sortStack([]): Base case reached, stack is empty.
As the recursion unwinds:
* Insert 5 back into [] resulting in [5].
* Insert 4 back into [5] resulting in [4, 5].
* Insert 2 back into [4, 5] resulting in [2, 4, 5].
* Insert 3 back into [2, 4, 5] resulting in [2, 3, 4, 5].
* Insert 1 back into [2, 3, 4, 5] resulting in [1, 2, 3, 4, 5].
This structure of first values and stack contents at each stage helps us understand how the recursive calls are nested and how they work together to sort the stack.

*/