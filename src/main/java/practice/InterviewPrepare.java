package practice;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class InterviewPrepare {

    @Test
    public void longestSubString() {
        String k = "sivaa";
        Set<Character> c = new HashSet<>();
        int i = 0, j = 0;
        int longestSubString = 0;

        while (i < k.length()) {
//            System.out.println("charAt i :: " + k.charAt(i));
            if (!c.contains(k.charAt(i))) {
                c.add(k.charAt(i));
                longestSubString = Math.max(longestSubString, c.size());
                i++;
            } else {
//                System.out.println("charAt j -- " + k.charAt(j));
                c.remove(k.charAt(j));
                j++;
            }
        }
        System.out.println(longestSubString);
    }

    @Test
    public void stringsPalindrome() {
        String name = "naveen";
        StringBuilder builder = new StringBuilder(name);
        builder.reverse();
        System.out.println(builder.toString().equals(name));
    }

    @Test
    public void stringPalindromeWithOutInbuiltMethod() {
        String name = "aba";
        String reverse = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reverse = reverse + name.charAt(i);
        }
        if (reverse.equals(name)) {
            System.out.println("is a palindrome");
        } else {
            System.out.println("is not a palindrome");
        }
    }
}
