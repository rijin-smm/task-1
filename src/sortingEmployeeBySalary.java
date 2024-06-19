import java.util.*;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private double salary;
    public Employee(String name , double salary){
        this.name = name;
        this.salary = salary;
    }
    public double getSalary(){
        return salary;

    }

    public String toString(){
        return (name + " - " +salary);

    }

}

public class sortingEmployeeBySalary {
    public static void main(String[] args) {
        ArrayList <Employee> al = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of student : ");
        int n = in.nextInt();
        in.nextLine();
        for (int i=0 ; i<n ; i++){
            System.out.print("Enter the name of Employee : ");
            String name = in.nextLine();
            System.out.print("Enter the salary of the Employee : ");
            double salary = in.nextDouble();
            al.add(new Employee(name , salary));
            in.nextLine();
        }

        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(),o1.getSalary());
            }
        };
        Collections.sort(al,com);
        System.out.println("Employee details : ");
        for (Employee e : al){
            System.out.println(e);
        }

    }

}
