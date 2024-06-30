package practice;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice {

    public static void main(String[] args) {
////        String s = "ab12c3de4";
////        String k =s.replaceAll("[^0-9]","");
////        System.out.println("numbers : "+k);
////        String[] j = k.split("");
////
////        int adding = 0;
////        for(int i=0;i<j.length;i++){
////            System.out.println("Splitting numbers : "+j[i]);
////            int num = Integer.parseInt(j[i]);
////            adding +=num;
////        }
////        System.out.println("sum : "+ adding);
////
        String s = "java is a programming language";
        String[] k = s.split(" ");
        for(int i=k.length-1;i>=0;i--){
            System.out.print(k[i]+" ");
        }

    }

//    public static void main(String[] args) {
//        String name = "oracle";
//        String[] kw = name.split("");
//        for (int i = kw.length-1; i >=0; i--) {
//            System.out.print(kw[i]);
//        }
//
//        int x=1;
//        int y =2;
//         x=x+y;
//         y=x-y;
//         x=x-y;
//         System.out.println("  ");
//         System.out.println(x);
//         System.out.println(y);
//
//        String k = "Oracle naveen";
//        String l = "a,e,i,o,u";
//        String[] j = k.split("");
//        String[] sp = l.split("");
//
//        for(String s : j){
//            for(String n : sp){
//              if(n.equalsIgnoreCase(s)){
//                  System.out.println("vowels : "+n);
//              }
//            }
//        }
//    }
}
