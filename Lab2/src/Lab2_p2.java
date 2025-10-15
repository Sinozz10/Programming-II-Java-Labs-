import java.util.*;

public class Lab2_p2 {

    //Helper fn to convert string to int
    static ArrayList<Integer> parseInput(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");
        for (int i = 0; i < parts.length; i++) {
            numbers.add(Integer.parseInt(parts[i].trim()));
        }
        return numbers;
    }

    //Helper fn to check prime
    static boolean isPrime(int n) {
        if ( n <= 1) return false;  // 1 and negatives are not prime
        if ( n == 2) return true;   // 2 is prime
        if ( n % 2 == 0) return false;  // Even numbers are not prime

        // Check odd divisors up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Main
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the members of the first set (Separated by ','): ");
        CustomSet s1 = new CustomSet(parseInput(s.nextLine()));

        System.out.print("Please enter the members of the Second set (Separated by ','): ");
        CustomSet s2 = new CustomSet(parseInput(s.nextLine()));

        CustomSet unionlist = s1.union(s2);
        System.out.println("The union of the two sets is "+unionlist);
        System.out.print("The prime numbers that are members of the union: ");
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < unionlist.getData().size(); i++) {
            int num = unionlist.getData().get(i);
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        for (int i = 0; i < primes.size(); i++) {
            System.out.print(primes.get(i));
            if (i < primes.size() -1) {
                System.out.print(", ");
            }
        }
    }
}
