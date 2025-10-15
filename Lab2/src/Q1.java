import java.util.*;

public class Q1 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter 3 positive integers separated by ‘-‘ : ");
        String numb= s.nextLine();
        String[] separated = numb.split("-");
        int[] arr = new int[3];

        for ( int i = 0; i < 3; i++) {
            arr[i]= Integer.parseInt(separated[i]);
        }

        if((arr[0] == arr[1]) && (arr[1] == arr[2])){
            System.out.println("all equal");
        } else if ((arr[0] != arr[1]) && (arr[1] != arr[2] ) && (arr[0] != arr[2])) {
            System.out.println("all different");
        }else
            System.out.println("neither");
    }

}