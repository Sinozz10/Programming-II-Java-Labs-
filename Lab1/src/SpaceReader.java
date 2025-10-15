/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1.tester;

import java.util.*;
/**
 *
 * @author Yassin
 */
public class SpaceReader {
    public static void main( String[] args){
        Scanner input = new Scanner(System.in);
        int count = 0 ;
        System.out.print("Enter Sentence");
        String s = input.nextLine();
        
        if(s == null || s.isEmpty()){
            count=0;
        }
        
        String s1 = s.trim();
        String[] words = s1.split("\\s+");
        
        count = words.length;
        if(count==0){
            System.out.println("No Words Found");
        }else{
            System.out.println("Count = " + count);
        }
    }
}
