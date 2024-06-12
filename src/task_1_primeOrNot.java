import java.util.Scanner;

public class task_1_primeOrNot {
    static String checkPrime(int n){
        int c = 0;
        for(int i=1 ; i<(n/2) ; i++){
            if(n%i == 0){
                c+=1;
            }

        }
        if(c>1){
            return "false";

        }
        else{
            return "true";
        }

    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = input.nextInt();
        String con = checkPrime(n);

        switch(con){
            case "true":
                System.out.println("The entered number " + n + " is prime");
                break;

            case "false":
                System.out.println("The entered number " + n + " is not prime");
                break;

        }

    }
}
