package practice_20;

import io.cucumber.java.sl.In;
import org.junit.Test;
import org.testng.ITestContext;

import java.util.*;

public class practice_20 {


    @Test
    public void reverseString() {
        String k = "naveen";
        String[] j = k.split("");
        for (int i = j.length - 1; i >= 0; i--) {
            System.out.print(j[i]);
        }
    }

    @Test
    public void swapTwoNumbers() {
        int a = 10;
        int b = 20;
        int temp;

        temp = a;//10
        a = b;//10
        b = temp;//20

        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void swapWithOutTemp() {
        int a = 10;
        int b = 20;

//        a= a+b; //10+20=30
//        b= a-b;//30-20=10
//        a=a-b;//30-20=10

        b = a + b - (a = b);//10+20-(20)

        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void findVowels() {
        String k = "a,e,i,o,u";

        String[] l = k.split(",");
        String s = "naveen reddy bandi";

        String[] j = s.split("");

        List<String> count = new ArrayList<>();
        int total = 0;
        boolean isPresent = false;
        for (int i = 0; i < j.length - 1; i++) {
            for (int q = 0; q < l.length - 1; q++) {
                if (l[q].equals(j[i])) {
                    isPresent = true;
                    count.add(j[i]);
                    total++;
                }
            }
        }

        System.out.println(isPresent);
        System.out.println(count);
        System.out.println(total);
    }

//
//
//
//

    @Test
    public void itest() {
        List<String> names = new ArrayList<>();
        names.add("hello abc");
        names.add("hello cbx");
        names.add("hello axs");
        names.add("hello tyu");
        names.add("hello uyt");

        names.forEach(System.out::println);
        System.out.println();
        String j = names.stream().filter(n -> n.endsWith("uyt")).findFirst().get().replace("uyt", "naveen");
        System.out.println(j);
        System.out.println();
        names.forEach(System.out::println);
    }

    interface hello {
        String say(String message);
    }

    public static class print {
        public static void main(String[] args) {
            hello k = (message) ->
                    "Hello " + message;

            System.out.println(k.say("Naveen"));
        }
    }

    @Test
    public void tesrststst() {
        int[] numbers = {1, -2, 4, 6, 8, -3, -1};

        List<Integer> p = new ArrayList<>();
        List<Integer> n = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > 0) {
                p.add(numbers[i]);
            }
            if (numbers[i] < 0) {
                n.add(numbers[i]);
            }

        }
        n.addAll(p);
        System.out.println(n);
    }


    @Test
    public void testNam() {

        /// 10,5,6,7,8,5,10
        int n = 15;

        int[] numbers = {10, 5, 6, 7, 8, 5, 10};

        int count = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i+1;j<numbers.length;j++){
            int s = numbers[i] + numbers[i + 1];
            if (s == n) {
                count++;
                System.out.println(numbers[i] + " " + numbers[i + 1]);
            }
//            }
        }
        System.out.println("Combinations :: " + count);
    }

    @Test
    public void replaceVowels() {
        String name = "naveen";
        //output =rejish
//        neviin
        char[] c = name.toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char dd : c) {
            switch (dd) {
                case 'a' -> builder.append('e');
                case 'e' -> builder.append('i');
                case 'o' -> builder.append('u');
                case 'u' -> builder.append('a');
                default -> builder.append(dd);
            }
        }
        System.out.println(builder);
    }


    @Test
    public void findMaxArray() {
        int[] list = {20, 30, 12, 30, 40};

        int min = list[0];
        int max = list[0];

        for (int i = 0; i < list.length; i++) {

            if (list[i] < min) {
                min = list[i];
                System.out.println("min" + list[i]);
            } else if (list[i] > max) {
                max = list[i];
            }
        }

        System.out.println(min + "\n" + max);
    }

    @Test
    public void reverseArray() {
        int[] list = {20, 30, 12, 30, 40, 40};

        int start = 0;
        int end = list.length - 1;

        while (start < end) {
            int temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(list));

    }

    @Test
    public void secondLargest() {
        int[] list = {20, 30, 12, 30, 40, 40};

        int largest = Integer.MIN_VALUE;
        Integer secondLargest = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println(secondLargest);
    }


    @Test
    public void febnosis_Series() {
        int i = 0;
        int j = 1;
        int n;
        System.out.print(i + " " + j);
        for (int k = 0; k < 10; k++) {
            n = i + j;
            System.out.print(" " + n);
            i = j;
            j = n;
        }
    }

    @Test
    public void findCommonCharacter() {
        String name = "naveekkn";

        char[] c = name.toCharArray();

        char l = c[0];

        for (int i = 0; i < c.length; i++) {
            if (c[i] == l) {
                System.out.println(l);
            } else {
                l = c[i];
            }

        }
    }

    @Test
    public void findCommonElements() {
        int[] k = {1, 2, 1, 3, 4, 3};
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < k.length; i++) {
            for (int j = i + 1; j < k.length; j++) {
                if (k[i] == k[j]) {
                    li.add(k[i]);
                }
            }
        }

        System.out.println(li.get(li.size() - 1));
    }

    @Test
    public void reverseStringWithPosition() {
        String company = "capgemini software company";
        String[] split = company.split(" ");
        for (String s : split) {
            char[] ch = s.toCharArray();
            for (int i = ch.length - 1; i >= 0; i--) {
                System.out.print(ch[i]);
            }
            System.out.print(" ");
        }
    }

    @Test
    public void sortTheArray() {
        int[] i = {1, 2, 3, 6, 9, 4, 4, 4, 4};
        Arrays.sort(i);
        System.out.println(Arrays.toString(i));
    }

    @Test
    public void reverseOrder(){
        Integer[] i = {1, 2, 3, 6, 9, 4, 4, 4, 4};
        Arrays.sort(i,Collections.reverseOrder());
        System.out.println(Arrays.toString(i));
    }

    @Test
    public void swapTwoNumbers12(){
        // with 3rd variable
        int i=10,j=20,temp;

        temp = i;
        i = j;
        j = temp;

        System.out.println(i);
        System.out.println(j+"\n");

        //without 3rd variable

        i = i+j;
        i = i-j;
        j = i-j;

        System.out.println(i);
        System.out.println(j);

    }

    //mul elements how can we add push new element middle

    @Test
    public void pushArray(){
        int[] num = {1,2,3,4,5,6};

        int push = 7;


        int[] newNum = new int[num.length+1];

        for (int n =0;n<num.length;n++){
            newNum[n] = num[n];
        }

        newNum[6] = push;
        for (int k=6;k< num.length;k++){
           newNum[k+1] = num[k];
        }

        System.out.println(Arrays.toString(newNum));

    }

    @Test
    public void stringOccurrence(){
        String n = "naveen";

        char[] c = n.toCharArray();

        Map<Character, Integer> charCountMap = new HashMap<>();

        // Iterate over the character array
        for (char ch : c) {
            // If the character is already in the map, increase the count
            if (charCountMap.containsKey(ch)) {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else {
                // If the character is not in the map, add it with a count of 1
                charCountMap.put(ch, 1);
            }
        }

        // Print the occurrences of each character
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void checkDuplicates(){
        String m = "naveen";

        char[] c = m.toCharArray();

        Map<Character,Integer> map= new  HashMap<>();

        for (char cc : c){
            if(map.containsKey(cc)){
                System.out.print(cc);
                map.put(cc,map.get(cc)+1);
            }else {
               map.put(cc,1);
            }
        }


        for (Map.Entry<Character, Integer> k : map.entrySet()){
//            System.out.println(k.getKey() + " "+ k.getValue() );
        }
    }
}
