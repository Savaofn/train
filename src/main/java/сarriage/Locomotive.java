package сarriage;

import humans.Driver;
import humans.License;
import сarriage.Carriage;

import java.util.ArrayList;

public class Locomotive extends Carriage {


    private ArrayList<Driver> driversList;

    public Locomotive(int number) {
        super(number);
        this.driversList = new ArrayList();
    }

    public ArrayList<Driver> getDriversList() {
        return driversList;
    }

    public String addDriver(Driver driver) {
        if (this.getDriversList().size() >= 2) {
            throw new IllegalArgumentException("A locomotive cannot have more than two drivers");
        }
        if (driver.getFirstName() == null || driver.getLastName() == null || driver.getId() == null) {
            throw new IllegalArgumentException("Fields are not filled");
        }
        if (driver.getAge() < 18) {
            throw new IllegalArgumentException("Humans.Driver's age must be over 18");
        }
        if (driver.getLicense() != License.A) {
            throw new IllegalArgumentException("Еhe driver must have a class A license");
        }
        driversList.add(driver);
        return "Humans.Driver added";
    }

    public String infoAboutDriverByLastName(String name) {
        for (Driver i : this.driversList) {
            if (i.getLastName().equals(name)) {
                return i.getInfo();
            }
        }
        return "There is no driver with such a name in the carriage";
    }

    public String deleteDriverByLastName(String name) {
        for (Driver i : this.driversList) {
            if (i.getLastName().equals(name)) {
                this.driversList.remove(i);
                return "Humans.Driver deleted";
            }
        }
        return "There is no driver with such a name in the carriage";
    }
}
