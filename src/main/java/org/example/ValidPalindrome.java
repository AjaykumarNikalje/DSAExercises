package org.example;

class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            }
            else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            }
            else if (leftChar != rightChar) {
                return false;
            }
            else {
                left++;
                right--;
            }
        }

        return true;
    }
    public static void main(String[] agrs){
        String str = "A man, a plan, a canal: Panama";
        System.out.println(" The palindrome is valid "+isPalindrome(str));
    }
}
