import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class Vehicle{
    static void fuel(){

    }
}
class Car extends Vehicle{
    static void fuel(){
        System.out.println("Fuel type is : Diesel");
    }
}
class Bike extends Vehicle{
    static void fuel(){
        System.out.println("Fuel type is : Petrol");
    }
}
public class question_2 {
    public static void main(String[] args) {
        Car obj1 = new Car();
        Bike obj2 = new Bike();
        obj1.fuel();
        obj2.fuel();
    }
}
