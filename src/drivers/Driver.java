package drivers;


import Exceptions.NotDriveLicense;
import transport.*;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Driver<T extends Transport> {

    private String name;
    private String driveLicense;

    int experience;
    private final int yearDriveLicense;

    private T transport;


    public Driver(String name, String driveLicense, int experience) throws NotDriveLicense {
        setName(name);
        setDriveLicense(driveLicense);

        if (experience <= 0) {
            experience = 1;
        }
        this.experience = experience;
        this.yearDriveLicense = LocalDate.now().getYear() - experience;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Укажите ФИО");
        } else {
            this.name = name;
        }
    }

    public String getDriveLicense() {
        return driveLicense;
    }




    public void setDriveLicense(String driveLicense) throws NotDriveLicense{
        if (driveLicense.equals("B") || driveLicense.equals("C") || driveLicense.equals("D")) {
            this.driveLicense = driveLicense;
        } else {
            throw new NotDriveLicense("Необходимо указать тип прав для " + name);
        }
    }



    public int getExperience() {
        experience = LocalDate.now().getYear() - yearDriveLicense;
        return experience;
    }

    public int getYearDriveLicense() {
        return yearDriveLicense;
    }

    public void startMoving() {
        System.out.println("Водитель " + name + " начинает движение");
    }

    public void stopMoving() {
        System.out.println("Водитель " + name + " останавливается");
    }

    public void refuelCar() {
        System.out.println("Водитель " + name + " заправляется");
    }

    public abstract void drive(T transport);


    @Override
    public String toString() {
        return name + ", водительские права " + driveLicense + ", срок действия прав " + experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return experience == driver.experience && yearDriveLicense == driver.yearDriveLicense && Objects.equals(name, driver.name) && Objects.equals(driveLicense, driver.driveLicense) && Objects.equals(transport, driver.transport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, driveLicense, experience, yearDriveLicense, transport);
    }
}