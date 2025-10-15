
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1.tester;

import java.util.*;

/**
 *6
 * @author Yassin
 */

public class Lab1Problem1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        int num;
        System.out.print("Enter a Number : ");
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        System.out.println("Try out Me for Git");
        if (num > 0) {
            System.out.print(num + " is +ve");
        } else if (num < 0) {
            System.out.print(num + " is -ve");
        } else {
            System.out.println("ZERO");
        }
        
        if (num % 2 == 0 && num != 0) {
            System.out.println(" & is even");
        } else if(num != 0){
            System.out.println(" & is odd");
        }
        
    }
}
