import Exceptions.NotDriveLicense;
import drivers.Driver;
import drivers.DriverB;
import drivers.DriverC;
import drivers.DriverD;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Set {
    public static void main(String[] args) throws NotDriveLicense {
        // - добавил в ArrayList водителей из старого спика
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new DriverB("Самохин Иван Петрович", "B", 10));
        drivers.add(new DriverB("Гвоздикин Петр Сергеевич", "B", 8));
        drivers.add(new DriverB("Лановой Сергей Николаевич", "B", 5));
        drivers.add(new DriverB("Барзыкин Владимир Андреевич", "B", 12));

        drivers.add(new DriverC("Панкратов Сергей Николаевич", "C", 18));
        drivers.add(new DriverC("Игнатьев Семен Владимирович", "C", 6));
        drivers.add(new DriverC("Калмыков Владимир Евгеньевич", "C", 16));
        drivers.add(new DriverC("Нигматуллин Ильшат Рамазанович", "C", 12));

        drivers.add(new DriverD("Шляппо Василий Ираклиевич", "D", 11));
        drivers.add(new DriverD("Куценко Андрей Романович", "D", 17));
        drivers.add(new DriverD("Жулебин Игорь Дмитриевич", "D", 15));
        drivers.add(new DriverD("Зарипов Ренат Ильгизович", "D", 9));

        // - Создал HashSet и добавил ArrayList весь список водителей туда
        HashSet<Driver> driversSet = new HashSet<>(drivers);

        //копируем еще трех водителей, чтобы появились дубли, данные водители также имеются в списке ArrayList
        driversSet.add(new DriverB("Гвоздикин Петр Сергеевич", "B", 8));
        driversSet.add(new DriverC("Игнатьев Семен Владимирович", "C", 6));
        driversSet.add(new DriverD("Шляппо Василий Ираклиевич", "D", 11));

        //выводим список водителей и видим, что дубли отсутсвуют. В данном случае еще понадобилось создать equals() и hashcode() в классе Drivers
        for (Driver driver : driversSet) {
            System.out.println(driver);
        }

        //выводим снова список, но с помощью итератора
        System.out.println();
        Iterator<Driver> driverIterator = drivers.iterator();
        while (driverIterator.hasNext()) {
            System.out.println(driverIterator.next());
        }


    }
}
