class Employee{
    static void job(){
        System.out.println("Employee have job to do");
    }
}
class Engineer extends Employee{
    static void job(){
        System.out.println("job : Engineer");
    }
}
class Manager extends Employee{
    static void job(){
        System.out.println("job : Manager");
    }
}
public class question_3 {
    public static void main(String[] args) {
        Employee obj = new Employee();
        Engineer obj1 = new Engineer();
        Manager obj2 = new Manager();
        obj.job();
        obj1.job();
        obj2.job();
    }
}
