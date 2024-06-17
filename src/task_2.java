/* Create a base class Employee with attributes name and salary. Derive two classes, Manager and Developer, from the
 Employee class. Ensure that the salary attribute is private and provide methods to access and modify it.
 */

import java.util.Scanner;

class Employee{
    String name;
    private double salary;
    public Employee(String name,double salary){
        this.name = name;
        this.salary =salary;

    }
    public  double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;

    }
}
class Manager extends Employee{
    public Manager(String name,double salary){
        super(name, salary);

    }
    public void changeSalary(double s){
        setSalary(s);
    }

    public void display(){
        double s1 = getSalary();
        System.out.println("Name : "+name+  ", salary : "+s1);
    }

}
class Developer extends Employee{
    public Developer(String name,double salary){
        super(name,salary);

    }
    public void changeSalary(double s){
        setSalary(s);
    }

    public void display(){
        double s1 = getSalary();
        System.out.println("Name : "+name+  ", salary : "+s1);
    }
}



public class task_2 {
    public static void main(String[] args) {
        Manager obj1 = new Manager("avinash", 2000);
        Developer obj2 = new Developer("sharath",2500);
        obj1.display();
        obj2.display();

        Scanner input = new Scanner(System.in);
        System.out.print("Manager new Salary : ");
        double s1 = input.nextDouble();
        obj1.changeSalary(s1);
        obj1.display();
        System.out.print("Developer new Salary : ");
        double s2 = input.nextDouble();
        obj2.changeSalary(s2);
        obj2.display();

    }
}
