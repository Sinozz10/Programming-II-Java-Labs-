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
public class Problem4 {
    
    public static void main(String[] args){
        int n; 
        int minInd=0,maxInd=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        n= sc.nextInt();
        int[] numbers = new int[n];
        for(int i=0;i<numbers.length;i++){
            System.out.println("Enter number " +(i+1));
            numbers[i] = sc.nextInt();
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[maxInd]<numbers[i])
                maxInd=i;
            if(numbers[minInd]>numbers[i])
                minInd=i;
        }
        System.out.println("Max Value is " + numbers[maxInd]+" Min Value is " + numbers[minInd]);          
    }
}
