package Streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Practice {

    @Test
    public void reverse() {
        String name = "naveen";
        char[] chars = name.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }

    @Test
    public void reverseWithBuilder() {
        StringBuilder builder = new StringBuilder("naveen");
        builder.reverse();
        System.out.println(builder);
    }

    @Test
    public void swapWithoutThird() {
        int a = 10;
        int b = 20;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void swapWithoutThird_TWo() {
        int a = 10;
        int b = 20;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void swapWithThirdVariable() {
        int a = 20;
        int b = 80;
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);

    }

    @Test
    public void findStringIsPalindromeOrNotWithBuilder(){
        String name = "rar";
        StringBuilder s = new StringBuilder(name);
        s.reverse();
        boolean status = s.toString().equals(name);
        if(status){
          System.out.println("String is Palindrome");
        }else {
            System.out.println("String is not a Palindrome");

        }
    }

    @Test
    public void findStringIsPalindromeOrNot(){
        String name = "abbal";
        char[] c = name.toCharArray();
        String j="";
        for(int i =c.length-1;i>=0;i--){
            j=j+c[i];
        }
        System.out.println(j);
        if(j.equals(name)){
            System.out.println("String is Palindrome");
        }else {
            System.out.println("String is not a Palindrome");

        }
    }

    @Test
    public void findCommonStrings(){
        String text = "ram need ram need";
        String[] k = text.split(" ");
        for (int i=0;i<=k.length;i++){
            for (int j = i+1;j<k.length;j++){
                if(k[i].equals(k[j])){
                 System.out.println(k[j]);
                }
            }
        }
    }

    @Test
    public void findDuplicateChar(){
        String text ="naveen";
//        int count=0;
        String[] k = text.split("");
        for (int i=0;i<=k.length;i++){
            for (int j = i+1;j<k.length;j++){
                if(k[i].equals(k[j])){
                    System.out.println(k[j]);
//                    count++;
                }
            }
        }
//        System.out.println(count);
    }

    @Test
    public void nonDuplicates(){
        int[] array = {1, 2, 3, 4, 5, 1, 2, 3};

        Arrays.sort(array);
        int previousElement = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] != previousElement) {
                System.out.println(array[i]);
            }

            previousElement = array[i];
        }

    }
}
