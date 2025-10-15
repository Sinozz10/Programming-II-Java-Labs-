 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1.tester;

/**
 *
 * @author Yassin
 */

public class TrafficLight {
    String color;
    static int count = 0;
    
    public TrafficLight(String color){
        this.color=color;
        count ++;
    }
    public void changeColor(){
        if(color.equalsIgnoreCase("green")){
            this.color="yellow";
        }else if(color.equalsIgnoreCase("yellow")){
            this.color="red";
        }else if(color.equalsIgnoreCase("red")){
            this.color="green";
        }
    }

    public static int getTrafficLight(){
            return count;
    }
    
    public void showaction(){
        switch(color.toLowerCase()){
            case "green" -> System.out.println("Color Green -> GO!!");
            case "yellow" -> System.out.println("Color Yellow -> Be Ready!");
            case "red" -> System.out.println("Color Red -> STOP!!");
            default -> System.out.println("Unknown Color");
            
        }
    }
    
    public static void main(String[] args){
        TrafficLight l1= new TrafficLight("green");
        TrafficLight l2= new TrafficLight("red");
        
        for (int i = 0; i < 6; i++) {
            l1.showaction();
            l1.changeColor();
            
        }
        
        System.out.println("------------------------------");
        
        for (int i = 0; i < 6; i++) {
            l2.showaction();
            l2.changeColor();
        }
        
        System.out.println("------------------------------");
        System.out.println("TOTAL TRAFFIC LIGHTS :" + TrafficLight.getTrafficLight());
        
        
    }
}
