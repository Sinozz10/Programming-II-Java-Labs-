/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1.tester;

/**
 *
 * @author Yassi
 */

public class Rectangle {
    
    //Attributes
    private double width ;
    private double length;
    
    
    //Constructor
    public Rectangle(double length , double width){
        this.length=length;
        this.width=width;
    
    }
    
    public double calculateArea(){
        return length * width;
    }
    
    public double calculatePerimeter(){
        return length + width;
    }
    
     public boolean isSquare(){
        return length==width;
     }
     
   public void printData(){
       System.out.println("Rectangle Details :-");
       System.out.println("Length = " + length);
       System.out.println("width = " + width);
       System.out.println("Area = " + calculateArea());
       System.out.println("Perimeter = " + calculatePerimeter());
       System.out.println("Is Square??" + isSquare());
   }
}
