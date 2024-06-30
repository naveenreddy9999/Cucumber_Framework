package practice;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class Practice_Strings {


    @Test
    public void vowels() {
        String k = "naveen";
        List<Character> l = Arrays.asList('a', 'e', 'i', 'o', 'u');

        char[] c = k.toLowerCase().toCharArray();
        boolean flag = false;
        int count =1;
        Set<Character> q = new HashSet<>();
        String e= "";

        for (int i = 0; i < c.length;i++){
            for(int j=0;j< l.size();j++){
                if(c[i] == l.get(j)){
                   flag = true;
                   count++;
                   q.add(c[i]);
                   e += " "+c[i];
                }
            }
        }

        System.out.println("Check vowels are there or not : "+flag);
        System.out.println("Check how many vowels are there : "+count);
        System.out.println("Non repeated vowels :: "+q);
        System.out.println("vowels :: "+e.trim());
    }

    @Test
    public void reverseString(){
        String n = "naveen";
        char[] c = n.toCharArray();
        for(int i=c.length-1;i>=0;i--){
            System.out.print(c[i]);
        }
    }

    @Test
    public void removeNumbersInAString(){
        String k = "Naveen11344 hello @@#$%^&*(";

        String regx = "[^a-zA-Z]"; // carry only letters
        String regx1 = "[\\W+]";// remove special chars
        String regx2 = "[\\D]";// carry only numbers
        String regx3 = "[\\d+]";// carry only numbers

        System.out.println(k.replaceAll(regx,""));
        System.out.println(k.replaceAll(regx1,""));
        System.out.println(k.replaceAll(regx2,""));
        System.out.println(k.replaceAll(regx3,""));


        System.out.println("gbp255500".replaceAll(regx1,"").contains("gbp2555"));
    }

}
