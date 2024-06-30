package practice;

import org.junit.Test;

public class AssignmentOne {

    @Test
    public void reverseString(){
        String text = "naveen";
        char[] c = text.toCharArray();
        for(int i = c.length-1;i>=0;i--){
            System.out.print(c[i]);
        }
    }

    @Test
    public void swapTwoNumbers(){
        int i=10;
        int j=20;

        i=i+j;
        j=i-j;
        i=i-j;

        System.out.println(i);
        System.out.println(j);
    }

    @Test
    public void swapTwoNumbersWithTemp(){
        int i=10;
        int j =20;
        int temp;

        temp=i;
        i=j;
        j=temp;

        System.out.println(i);
        System.out.println(j);
    }

    @Test
    public void findVowelsInString(){
        String rex= ".*[aeiou].*";
        String text = "naveen";
        String text2 = "sktl";

        System.out.println(text.toLowerCase().matches(rex));
        System.out.println(text.toLowerCase().matches(text2));
    }

    @Test
    public void checkPrimeNumberOrNot(){

       System.out.println( isPrime(10));

    }

    public static boolean isPrime(int i){
        if(i==0||i==1){
            return false;
        }
        if(i==2){
            return true;
        }

        for(int n=2;n<=i/2;n++){
            if(i%n==0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void printFibonacciSequence(){
        int a=0;
        int b=1;
        int c=1;
        int count =10;
        for(int i=0;i<=count;i++){
            System.out.print(a+" ");
            a=b;
            b=c;
            c=a+b;
        }
    }
}
