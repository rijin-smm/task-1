import java.util.Scanner;

public class primeOrNot {

    static void checkPrime(int n){
        int c = 0;
        for(int i=1 ; i<(n/2) ; i++){
            if(n%i == 0){
                c+=1;
            }

        }
        if(c>1){
            System.out.println("The entered number " + n + " is not prime");

        }
        else{
            System.out.println("The entered number " + n + " is prime");
        }

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = input.nextInt();
        checkPrime(n);

    }
}
