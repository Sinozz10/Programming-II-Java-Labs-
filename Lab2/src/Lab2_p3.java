import java.util.*;

public class Lab2_p3 {
    public static void main(String[] args){
        Invoice account1;
        Invoice account2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account 1 Data: ");
        System.out.print("Invoice Number: ");
        int num=sc.nextInt();
        System.out.print("Customer Name: ");
        String name=sc.nextLine();
        sc.nextLine();
        System.out.print("Number of Elements: ");
        int element = sc.nextInt();
        sc.nextLine();
        System.out.print("Prices: ");
        String pricesInput1 = sc.nextLine();
        String[] pricesStr1 = pricesInput1.split(",");
        double[] prices1 = new double[element];
        for ( int i = 0; i < element && i < pricesStr1.length; i++) {
            prices1[i] = Double.parseDouble(pricesStr1[i].trim());
        }
        account1 = new Invoice(num, name, prices1);


        System.out.println("================================================================");


        System.out.println("Enter Account 2 Data: ");
        System.out.print("Invoice Number: ");
        int num2=sc.nextInt();
        sc.nextLine();
        System.out.print("Customer Name: ");
        String name2=sc.nextLine();
        System.out.print("Number of Elements: ");
        int element2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Prices: ");
        String pricesInput2 = sc.nextLine();
        String[] pricesStr2 = pricesInput2.split(",");
        double[] prices2 = new double[element2];
        for (int i = 0; i < element2 && i < pricesStr2.length; i++) {
            prices2[i] = Double.parseDouble(pricesStr2[i].trim());
        }

        account2 =new Invoice(num2,name2,prices2);

        System.out.println("================================================================");

        System.out.println("The data of the first account: ");
        account1.report();

        System.out.println("================================================================");

        System.out.println("The data of the Second account: ");
        account2.report();
    }
}
