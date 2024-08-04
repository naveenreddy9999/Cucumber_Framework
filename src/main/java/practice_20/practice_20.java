package practice_20;


import org.testng.*;
import org.testng.annotations.Test;


import java.util.*;

public class practice_20 implements ITestListener{


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
//            }
            }
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
    public void reverseOrder() {
        Integer[] i = {1, 2, 3, 6, 9, 4, 4, 4, 4};
        Arrays.sort(i, Collections.reverseOrder());
        System.out.println(Arrays.toString(i));
    }

    @Test
    public void swapTwoNumbers12() {
        // with 3rd variable
        int i = 10, j = 20, temp;

        temp = i;
        i = j;
        j = temp;

        System.out.println(i);
        System.out.println(j + "\n");

        //without 3rd variable

        i = i + j;
        i = i - j;
        j = i - j;

        System.out.println(i);
        System.out.println(j);

    }

    //mul elements how can we add push new element middle

    @Test
    public void pushArray() {
        int[] num = {1, 2, 3, 4, 5, 6};

        int push = 7;


        int[] newNum = new int[num.length + 1];

        for (int n = 0; n < num.length; n++) {
            newNum[n] = num[n];
        }

        newNum[6] = push;
        for (int k = 6; k < num.length; k++) {
            newNum[k + 1] = num[k];
        }

        System.out.println(Arrays.toString(newNum));

    }

    @Test
    public void stringOccurrence() {
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
    public void checkDuplicates() {
        String m = "naveen";

        char[] c = m.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char cc : c) {
            if (map.containsKey(cc)) {
                System.out.print(cc);
                map.put(cc, map.get(cc) + 1);
            } else {
                map.put(cc, 1);
            }
        }


        for (Map.Entry<Character, Integer> k : map.entrySet()) {
//            System.out.println(k.getKey() + " "+ k.getValue() );
        }

    }

    @Test
    public void febnocieSeries_1() {
        int i = 0, n = 1, t;
        int count = 10;
        System.out.print(i + " " + n);
        for (int l = 3; l <= 10; l++) {
            t = i + n;
            System.out.print(" " + t);
            i = n;
            n = t;
        }
    }


    @Test
    public void isPrimeNumber() {
        int n = 4;
        int flag = 0;
        if (n == 0 || n == 1) {
            System.out.println("given number is not prime number");
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.println("given number is not prime number");
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0) {
            System.out.print(String.format(" is %d  prime number", n));
        }
    }

    @Test
    public void printPrimePrintNumbers() {
        for (int i = 2; i <= 10; i++) {
            if (!(i % 2 == 0)) {
                System.out.print(" " + i);
            }
        }
    }

    @Test
    public void findCommonCharacters() {
        String name = "lenovo";
        char[] c = name.toCharArray();

        for (int i = 0; i < c.length; i++) {
            for (int j = i + 1; j < c.length; j++) {
                if (c[i] == c[j]) {
                    System.out.print(c[i]);
                }
            }
        }
    }

    @Test
    public void reveseString() {
        String text = "hello how are you";

        char[] cc = text.toCharArray();

        for (int i = cc.length - 1; i >= 0; i--) {
            System.out.print(cc[i]);
        }
    }

    @Test
    public void findCommonCharactersUsingHashMap() {
        String name = "naveen";
        char[] cc = name.toCharArray();
        Map<Character, Integer> duplicates = new HashMap<>();

        for (int i = 0; i < cc.length; i++) {
            if (duplicates.containsKey(cc[i])) {
                duplicates.put(cc[i], duplicates.get(cc[i]) + 1);
            } else {
                duplicates.put(cc[i], 1);
            }
        }

        for (Character ss : duplicates.keySet()) {

            if (duplicates.get(ss) > 1)
                System.out.println(ss + " count " + duplicates.get(ss));
        }
    }

    @Test
    public void findCommonCharacters_in_word() {
        String word = "hello one by one";
        String[] splitWords = word.split("\\s");

        Map<String, Integer> countDuplicate = new HashMap<>();

        for (int i = 0; i < splitWords.length; i++) {
            if (countDuplicate.containsKey(splitWords[i])) {
                countDuplicate.put(splitWords[i], countDuplicate.get(splitWords[i]) + 1);
            } else {
                countDuplicate.put(splitWords[i], 1);
            }
        }

        for (String cc : countDuplicate.keySet()) {
            if (countDuplicate.get(cc) > 1) {
                System.out.println(cc + " count " + countDuplicate.get(cc));
            }
        }
    }

    @Test
    public void equalString() {
        String h = "naveen";
        String hh = "naveen";

        String s = "naveen";

        System.out.println(h.equals(s));
    }

    @Test
    public void convertNumberToRomanNumber() {

//        public static void main(String[] args) {
//            intToRoman(125);
//            intToRoman(252);
//            intToRoman(1000);
//            intToRoman(1010);
//
//        }
        int num = 125;
        System.out.println("Integer: " + num);
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        System.out.println("Corresponding Roman Numerals is: " + roman);
    }

    @Test
    public void powers() {
        int base = 2;
        int pow = 3;

        double nums = 0;
        if (pow < 0) {
            nums = -pow;
        }
        double result = 1;

        while (nums != 0) {
            result *= base;
            --nums;
        }

        if (pow < 0) {
            result = (1.0) / result;
        }
        System.out.println(result);
    }


    @Test
    public void calculatePowers() {
        int base = 2;
        double pow = 0.4;
        double result = 1;
        double nums = 0;

        // here we are converting negative value to positive;
        if (pow < 0) {
            nums = -pow;
        }

        System.out.println("converted number :: " + nums);

        // here we are calculating powers
        while (nums != 0) {
            result *= base;
            --nums;
        }

        //if power is negative we need to modify values
        if (pow < 0) {
            result = (1.0) / result;
        }
        System.out.println("final result :: " + result);
    }

    @Test
    public void convertNegativeToPositive() {
        int num = -10;

        if (num < 0) {
            num = -num;
        }

        System.out.println(num);
    }

    @Test
    public void findEvenOddNumber(){
        int i = 2;

        if(i%2 == 0){
            System.out.println("Even number");
        }else{
            System.out.println("odd number");
        }
    }
    @Test
    public void changePosition() {
        String k = "abcABC123";

        String caps = k.replaceAll("[^A-Z]","");
        String small = k.replaceAll("[^a-z]","");
        String nums = k.replaceAll("[^0-9]","");

        System.out.println(caps);
        System.out.println(small);
        System.out.println(Integer.parseInt(nums));

        int i=0;

        char[] ch = nums.toCharArray();

        for (char c:ch){
            i +=Integer.parseInt(String.valueOf(c));
        }

        System.out.println("sum of numbers : "+i);
    }

    @Test
    public void change(){
        String f="iyyyetetet2022jhh2022-10-22hhhhgh";

        String k =f.replaceAll("[a-zA-Z]","");
        System.out.println(k.substring(4));
        System.out.println(k.substring(k.indexOf("-")-4));
    }

    @Test
    public void test(){
        String k="naveen ezhil_prioriy_function";
        String f = k.replaceAll("_"," ");
        System.out.println(f);

        String[] s = f.split(" ");
        System.out.println(s[1]);
    }
}
