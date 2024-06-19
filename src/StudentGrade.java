import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;

public class StudentGrade {
    public static void main(String[] args) {
        HashMap<String , String > map1 = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("\nwhat do you want to do : \n");
            System.out.println("1. add new student");
            System.out.println("2. update grades");
            System.out.println("3. Display all students and grades");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice : ");
            try{
                n = in.nextInt();
                in.nextLine();

                switch (n){
                    case 1:
                        System.out.print("Enter the student name : ");
                        String new_name = in.nextLine();
                        if(map1.containsKey(new_name)){
                            System.out.println("Student " + new_name + " is already exist in the list");
                            break;
                        }
                        else{
                            System.out.print("Enter the student grade : ");
                            String garde = in.nextLine();
                            map1.put(new_name, garde);
                            System.out.println("New student added.");
                        }

                        break;

                    case 2:
                        System.out.print("which student grade you wish to change : ");
                        String update_name = in.nextLine();
                        if(map1.containsKey(update_name)){
                            System.out.print("Enter the new grade : ");
                            String update_grade = in.nextLine();
                            map1.put(update_name,update_grade);
                            System.out.println("Grade updated.\n");
                        }
                        else{
                            System.out.println("Student "+update_name + " is not present in the list");
                        }
                        System.out.println("\n----------------------------------------------------------\n");
                        break;

                    case 3:
                        for(Map.Entry<String, String> entry : map1.entrySet()){
                            System.out.println("\n"+entry.getKey() + " - " + entry.getValue());
                            System.out.println("\n----------------------------------------------------------\n");
                        }
                        break;

                    default:
                        System.out.println("\nInvalid choice please try again ! \n.");

                }

            }catch (InputMismatchException e){
                System.out.println("\nInvalid input. Please enter a valid choice.\n");
                System.out.println("----------------------------------------------------------\n");
                in.nextLine();
            }
                    }while (n!=4);
        in.close();
    }
}
