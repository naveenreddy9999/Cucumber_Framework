package practice;

import io.cucumber.java.sl.In;
import org.junit.Test;

import java.util.*;

public class hello {


    @Test
    public void StringManipulations() {
        String name = "naveen";
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.reverse();
        System.out.println("TypeOne : " + stringBuilder);
        String[] nameR = name.split("");
        for (int i = nameR.length - 1; i >= 0; i--) {
            System.out.print(nameR[i]);
        }
    }

    @Test
    public void String2() {
        String k = "nan";
        String[] jr = k.split("");
        String rev = "";
        for (int i = jr.length - 1; i >= 0; i--) {
            rev += jr[i];
        }
        if (k.equals(rev)) {
            System.out.println("Is a palindrome name");
        } else {
            System.out.println("not a palindrome name");
        }
    }

    @Test
    public void String3() {
        String s = "123naveen";
        String j = s.replaceAll("[^0-9]", "");
        System.out.println(j);
        String[] a = j.split("");
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int p = Integer.parseInt(a[i]);
            sum += p;
        }
        System.out.println(sum);
    }

    @Test
    public void findMiddleOfTheString() {
        String name = "ram";
        String[] k = name.split("");
        int half = k.length / 2;
        System.out.println(k[half]);
        String name2 = "Hello how can we are work";
        String[] hh = name2.split(" ");
        System.out.println(hh.length);
        int halfLength = hh.length / 2;
        System.out.println(hh[halfLength]);
    }

    @Test
    public void capitalEachWord() {
        String name2 = "practice hello how can we are work";
        String[] hh = name2.split(" ");

        for (int i = 0; i < hh.length; i++) {
            String k = hh[i].substring(0, 1).toUpperCase();
            String l = hh[i].substring(1);
            System.out.print(k + l + " ");
        }
    }

    @Test
    public void reverseEachWordOfString() {
        String j = "practice.hello world naveen";
        String[] k = j.split("\\s");
        String rev = "";

        for (int i = 0; i < k.length; i++) {
            if (i == k.length - 1) {
                rev = k[i] + rev;
            } else {
                rev = " " + k[i] + rev;
            }
        }
        System.out.println(rev);
    }

    @Test
    public void reverseStringWithInSentence() {
        String k = "practice hello world naveen";
        String[] words = k.split("\\s");
        String revWord = "";
        for (int i = 0; i < words.length; i++) {
            String f = words[i];
            String rev = "";
            for (int w = f.length() - 1; w >= 0; w--) {
                rev = rev + f.charAt(w);
            }
            revWord = revWord + rev + " ";
        }
        System.out.print(revWord);
    }

    @Test
    public void findRepeatString() {
        String kk = "Chennai,Bengaluru,Kolkata,Chennai,Pune,Chennai,Mumbai,Chennai,Delhi,Delhi";

        List<String> repeatNames = Arrays.asList(kk.split(","));
        System.out.println(repeatNames);


        List<String> k = new ArrayList<>();

        for (int i = 0; i < repeatNames.size(); i++) {
            for (int j = i + 1; j < repeatNames.size(); j++) {
                if (repeatNames.get(i).equals(repeatNames.get(j))) {
//                    System.out.println(repeatNames.get(j));
                    k.add(repeatNames.get(j));
                }
            }
        }
        System.out.println(k);

        System.out.println("--");
        Set<String> set = new HashSet<>();

        for (String iterator : repeatNames) {
            if (!set.add(iterator)) {
                System.out.println("Repeat :: " + iterator);
            }
        }
        System.out.println("total : " + set);
    }

    @Test
    public void repeat() {
        String k = "naveen";
        char[] s = k.toCharArray();
        List n = new ArrayList();
        List r = new ArrayList();
        for (char c : s) {
            System.out.println(k.indexOf(c));
            System.out.println(k.lastIndexOf(c));

            System.out.println();
            if (k.indexOf(c) == k.lastIndexOf(c)) {
                n.add(c);
            }else {
                r.add(c);
            }
        }

        System.out.println("non repeating char ::" + n);
        System.out.println("repeating char ::" + r);

    }


    @Test
    public void check() {
        List<Integer> intOne = Arrays.asList(1, 2, 4, 5);
        List<Integer> intTwo = Arrays.asList(1, 2, 4, 5, 1, 1);
        List<Integer> intThree = Arrays.asList(1, 1, 2, 2, 5);

        Set<Integer> kk = new HashSet<>(intTwo);
        Set<Integer> kk1 = new HashSet<>(intThree);

        List<Integer> uu = new ArrayList<>(kk);
        List<Integer> jj = new ArrayList<>(kk1);


        if (intOne.equals(uu)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        if (intOne.equals(jj)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    @Test
    public void collection() {

//        String[] listOfArray = new String[]{"naveen","suresh","rahul"};
//        List<String> stringList = List.of("naveen","rajesh","abdul");
//
//        List nn = Arrays.asList(listOfArray);
//
//        List j=new ArrayList();
//
//        HashMap<Integer,String> h = new HashMap<>();
//
//       for(String k : stringList){
//           char[] c = k.toCharArray();
//           j.add(c.length);
//           h.put(k.length(),k);
//       }
//
//       System.out.println(j);
//
//       System.out.println(h.get(Collections.max(j)));

        String[] names = {"naveen","rajesh","abdul"};

//        int size = names.length;
//        String longestName = names[1];
//
//        for (int i = 0; i <= size-1; i++) {
//            if (names[i].length() > longestName.length()) {
//                longestName = names[i];
//            }
//        }

          Arrays.sort(names,Collections.reverseOrder());

          System.out.println(names[0]);
          System.out.println(names[1]);
          System.out.println(names[2]);
//        System.out.println(longestName);


    }

    @Test
    public void findVowels(){
        String j = "naveen";

        char[] c = j.toCharArray();
        int count =0;

        List<Character> l = new ArrayList();


        List<Character> list = List.of('a','e','i','o','u');
//        for(int i=0;i<=c.length-1;i++) {
//            for (char k : list) {
//               if(k == c[i]){
//                  count++;
//                  l.add(c[i]);
//               }
//            }
//        }
//        System.out.println(count);
//        System.out.println("vowel "+l);
//
//
//        String par = l.toString();
//        System.out.println(par);
//        String aa = j.replaceAll(par,"");
//
//        String xx = aa.replaceAll(par,"");
//
//
//
//        System.out.println("kk "+aa);
//        System.out.println("kk "+xx);

        Set<Character> ss = new HashSet();



        for (char ww : c){
            ss.add(ww);
        }

        System.out.println(ss);

        List ll = new ArrayList(ss);
       System.out.println(ll);
        for(int i=0;i<ll.size();i++) {
            for (int k=0;k<list.size(); k++) {
                System.out.print(ll.get(i));
                if(ll.get(i).equals(list.get(k))){
                    count++;
                    l.add(c[i]);
//                    break;
                }
            }
        }
        System.out.println("vowel "+l);
    }

    @Test
    public void findVowels2() {
        String j = "naveen";

        char[] c = j.toCharArray();
        int count = 0;

        List<Character> l = new ArrayList<>();
        List<Character> list = List.of('a', 'e', 'i', 'o', 'u');

        Set<Character> ss = new HashSet<>();

        for (char ww : c) {
            ss.add(ww);
        }

        System.out.println(ss);

        List ll = new ArrayList<>(ss);

        System.out.println(ll);

        for (int i = 0; i < ll.size(); i++) {
            for (int k = 0; k < list.size(); k++) {
                System.out.print(ll.get(i));
                if (ll.get(i).equals(list.get(k))) {
                    count++;
                    l.add((Character) ll.get(i));
                    break; // Once a vowel is found, no need to continue inner loop
                }
            }
        }
        System.out.println("\nNumber of vowels: " + count);
        System.out.println("Vowels: " + l);
    }


    @Test
    public void findVowelsqq(){
        String j = "naveen";
        char[] c = j.toCharArray();
        Set<Character> ss = new HashSet();
        for (char ww : c){
            ss.add(ww);
        }
        List ll = new ArrayList(ss);
        List<Character> l = new ArrayList();
        List<Character> list = List.of('a','e','i','o','u');

        int count=0;
        
        for(int i=0;i<ll.size();i++) {
            for (int k=0;k<list.size(); k++) {
                if(ll.get(i).equals(list.get(k))){
                    count++;
                    l.add(c[i]);
                    break;
                }
            }
        }
        System.out.println("vowel "+l);
    }

    @Test
    public void exception() throws Exception{

        int[] i = null;
        try {
            System.out.println(i.length);
        }catch (Exception ignore){
//            throw new NullPointerException(e.getMessage());
        }finally {
            System.out.println("hello");
        }
    }

    @Test
    public void commonChar(){
        String name ="naveen";

        Set<Character> u = new HashSet();
        Set<Character> d = new HashSet();
        Set<Character> non = new HashSet();

        int repeat =0;
        int nonRep =0;

        for(char c : name.toCharArray()){
            if(!u.add(c)){
                d.add(c);
                repeat++;
            }else {
              nonRep++;
            }
        }

        System.out.println("Repeat char :"+d);
        System.out.println("Non Repeat char :"+non);

        System.out.println("Repeat Count : "+repeat);
        System.out.println("Non Repeat Count :: "+nonRep);
    }

    @Test
    public void nonRepeatCharacters(){

        String name = "naveen";

        Map<Character,Integer> m = new HashMap();

        for(char c : name.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }

        System.out.println(m);


        List l = new ArrayList();
        for(char c:name.toCharArray()){

            if(m.get(c)==1){
//                stringBuilder.append(c);
                l.add(c);
            }
        }

        l.forEach(System.out::print);

    }
}
