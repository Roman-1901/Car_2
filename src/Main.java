import Exceptions.NotDriveLicense;
import drivers.Driver;
import drivers.DriverB;
import drivers.DriverC;
import transport.Car;
import transport.Mechanic;
import transport.Transport;
import transport.Truck;

//тестовый класс, прошгу его не учитывать в качестве дз
public class Main {
    public static void main(String[] args) throws NotDriveLicense {
        Driver<Car> driver = new DriverB("Иван", "B", 10);

        var transport = new Car("volvo", "x6", 2.5, Car.CarType.HATCHBACK, driver);

        System.out.println(transport.getDriver());
    }
}