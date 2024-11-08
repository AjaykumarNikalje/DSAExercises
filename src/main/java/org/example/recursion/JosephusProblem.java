package org.example.recursion;
import java.util.*;

public class JosephusProblem{

        static void solve(ArrayList<Integer> person, int k, int index, int ans[]) {
            if (person.size() == 1) { //base case
                ans[0] = person.get(0); //if last element is left
                return;
            }
            index = (index + k) % person.size(); //finding the person to be killed
            person.remove(index); //to erase that person
            solve(person, k, index, ans); //recursive call
            return;
        }

        public static void main(String args[]) {
            int n=7, k=3;
            ArrayList<Integer> person=new ArrayList<>(); //to store the person numbering
            for (int i = 1; i <= n; i++) {
                person.add(i);
            }
            int ans[]=new int[1];
            ans[0]=-1; //to store the safest place
            solve(person, k - 1, 0, ans);
            System.out.println("The safe position is: "+ans[0]);
        }
    }