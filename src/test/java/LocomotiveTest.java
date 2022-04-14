import humans.Driver;
import humans.License;
import org.junit.jupiter.api.Test;
import сarriage.Locomotive;

import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

class LocomotiveTest {


    @Test
    void addDriver_Valid() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 21, License.A);
        Locomotive locomotive = new Locomotive(1);

        //expect
        System.out.println(locomotive.addDriver(driver));
    }

    @Test
    void addDriver_inValidDriverAge() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 15, License.A);
        Locomotive locomotive = new Locomotive(1);

        //expect
        assertThrows(IllegalArgumentException.class, () -> locomotive.addDriver(driver));

    }

    @Test
    void addDriver_inValidDriverNumberInLocomotive() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 20, License.A);
        Driver driver1 = new Driver("2", "Jon", "Black", 20, License.A);
        Driver driver2 = new Driver("3", "Jon", "Black", 20, License.A);
        Locomotive locomotive = new Locomotive(1);

        //do
        locomotive.addDriver(driver);
        locomotive.addDriver(driver1);

        //expect
        assertThrows(IllegalArgumentException.class, () -> locomotive.addDriver(driver2));


    }

    @Test
    void addDriver_inValidDriverNullInfo() {
        //any
        Driver driver = new Driver(null, null, null, 21, License.A);
        Locomotive locomotive = new Locomotive(1);

        //expect
        assertThrows(IllegalArgumentException.class, () -> locomotive.addDriver(driver));

    }

    @Test
    void addDriver_inValidDriverLicenseNotA() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 23, License.B);
        Locomotive locomotive = new Locomotive(1);

        //expect
        assertThrows(IllegalArgumentException.class, () -> locomotive.addDriver(driver));

    }

    @Test
    void infoAboutDriverByLastName_DriverWithSuchLastNameExist() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 23, License.A);
        Locomotive locomotive = new Locomotive(1);

        //do
        locomotive.addDriver(driver);

        //expect
        assertThat(locomotive.infoAboutDriverByLastName("Black"), is(driver.getInfo()));

    }

    @Test
    void infoAboutDriverByLastName_DriverWithSuchLastNameNotExist() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 23, License.A);
        Locomotive locomotive = new Locomotive(1);

        //do
        locomotive.addDriver(driver);

        //expect
        assertThat(locomotive.infoAboutDriverByLastName("Blak"), is("There is no driver with such a name in the carriage"));

    }

    @Test
    void deleteDriverByLastName_DriverWithSuchLastNameExist() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 23, License.A);
        Locomotive locomotive = new Locomotive(1);

        //do
        locomotive.addDriver(driver);
        //expect
        assertThat(locomotive.deleteDriverByLastName("Black"), is("Humans.Driver deleted"));
        assertThat(locomotive.infoAboutDriverByLastName("Black"), is("There is no driver with such a name in the carriage"));
    }

    @Test
    void deleteDriverByLastName_DriverWithSuchLastNameNotExist() {
        //any
        Driver driver = new Driver("1", "Jon", "Black", 23, License.A);
        Locomotive locomotive = new Locomotive(1);

        //do
        locomotive.addDriver(driver);
        //expect
        assertThat(locomotive.deleteDriverByLastName("Blac"), is("There is no driver with such a name in the carriage"));
        assertThat(locomotive.infoAboutDriverByLastName("Black"), is(driver.getInfo()));
    }
}