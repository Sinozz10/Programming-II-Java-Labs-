import java.util.*;

public class Person {

    //----Instance Variables----
    private String name;
    private double salary;
    private boolean isWorking;
    private double monExpenses;
    private static final double defSalary = 1000.00;

    //Getters & Setters

    @Override
    public String toString() {

        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", isWorking=" + isWorking +
                ", monExpenses=" + monExpenses +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if (isWorking){
            this.salary = salary;
        }
        else{
            this.salary=0.0;
        }

    }
    public boolean isWorking() {
        return isWorking;
    }
    public void setWorking(boolean working) {
        isWorking = working;
        if (!isWorking) {
            this.salary = 0.0;
        } else {
            if (this.salary <= 0) {
                this.salary = defSalary;
            }
        }
    }
    public double getMonExpenses() {
        return monExpenses;
    }
    public void setMonExpenses(double monExpenses) {
        if(salary==0){
            this.monExpenses= 0.0;
        }else{
            this.monExpenses=monExpenses;
        }
    }

    //----Constructors----
    public Person(String name){
        this.name= name;
        this.salary=0.0;
        this.isWorking=false;
        this.monExpenses=0.0;
    }

    public Person(String name, double salary, double monExpenses, boolean isWorking){
        this.name=name;
        this.isWorking=isWorking;
        this.monExpenses=monExpenses;
        setSalary(salary);

    }

    //Methods
    public double netincome(){
        return salary - monExpenses;
    }

    //Main Testing

    public static void main(String[] args) {
        System.out.println("=== Testing Person Class ===");

//        //Tester for empty constructor
//        System.out.println("No Name or money");
//        Person person4 = new Person("");
//        System.out.println(person4);
//        System.out.println();

        // Test Constructor 1
        System.out.println(" Constructor with name only");
        Person person1 = new Person("Alice");
        System.out.println(person1);
        System.out.println();

        // Test Constructor 2
        System.out.println(" Constructor with all parameters");
        Person person2 = new Person("Bob", -5000, 3000, true);
        System.out.println(person2);
        System.out.println();

        // Test setting working status
        System.out.println(" Setting person1 to working");
        person1.setWorking(true);
        System.out.println(person1);
        System.out.println();

        // Test setting invalid salary when working
        System.out.println(" Setting invalid salary (0) when working");
        person1.setSalary(0);
        System.out.println("Salary after setting to 0: " + person1.getSalary());
        System.out.println();

        // Test setting person to not working
        System.out.println(" Setting person2 to not working");
        person2.setWorking(false);
        System.out.println(person2);
        System.out.println();

        // Test net income
        System.out.println(" Net income calculation");
        Person person3 = new Person("Charlie", 6000, 4500, true);
        System.out.println("Name: " + person3.getName());
        System.out.println("Salary: " + person3.getSalary());
        System.out.println("Monthly Expenses: " + person3.getMonExpenses());
        System.out.println("Net Income: " + person3.netincome());
    }
}