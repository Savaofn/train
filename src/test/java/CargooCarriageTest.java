import cargo.Cargo;
import org.junit.jupiter.api.Test;
import сarriage.СargoCarriage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CargooCarriageTest {
    @Test
    void addCargo_Valid() {
        //any
        Cargo cargo = new Cargo("Car", 12, 3, 1);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //expect
        сargoCarriage.addCargo(cargo);
    }

    @Test
    void addCargo_Valdid() {
        //any
        Cargo cargo = new Cargo("Car", 1, 10, 1);
        Cargo cargo1 = new Cargo("Car", 1, 3, 1);
        Cargo cargo2 = new Cargo("Car", 1, 3, 1);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //expect
        сargoCarriage.addCargo(cargo);
        сargoCarriage.addCargo(cargo1);
        сargoCarriage.addCargo(cargo2);
        System.out.println(сargoCarriage.getCurrentWight());
    }

    @Test
    void addCargo_inValidNullInfo() {
        //any
        Cargo cargo = new Cargo(null, 0, 0, 0);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //expect
        assertThrows(IllegalArgumentException.class, () -> сargoCarriage.addCargo(cargo));

    }

    @Test
    void addDriver_inValidMaxWeightLimit() {
        //any
        Cargo cargo = new Cargo("Car", 2, 111_111_111, 1);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //expect
        assertThrows(IllegalArgumentException.class, () -> сargoCarriage.addCargo(cargo));


    }

    @Test
    void addDriver_inValidMaxSizeLimit() {
        //any
        Cargo cargo = new Cargo("Car", 2, 1, 111_111_111);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //expect
        assertThrows(IllegalArgumentException.class, () -> сargoCarriage.addCargo(cargo));


    }


    @Test
    void infoAboutCargoByName_CargoWithSuchNameExist() {
        //any
        Cargo cargo = new Cargo("Car", 2, 1, 1);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //do
        сargoCarriage.addCargo(cargo);

        //expect
        assertThat(сargoCarriage.infoAboutCargoByName("Car"), is(cargo.getInfo()));

    }

    @Test
    void infoAboutCargoByName_CargoWithSuchNameNotExist() {
        //any
        Cargo cargo = new Cargo("Car", 2, 1, 1);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //do
        сargoCarriage.addCargo(cargo);

        //expect
        assertThat(сargoCarriage.infoAboutCargoByName("Carr"), is("There is no cargo with such name in the carriage"));

    }

    @Test
    void DeleteCargoByName_CargoWithSuchNameExist() {
        //any
        Cargo cargo = new Cargo("Car", 2, 1, 1);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //do
        сargoCarriage.addCargo(cargo);

        //expect
        assertThat(сargoCarriage.DeleteCargoByName("Car"), is("cargo.Cargo deleted"));
        assertThat(сargoCarriage.infoAboutCargoByName("Car"), is("There is no cargo with such name in the carriage"));
    }

    @Test
    void DeleteCargoByName_CargoWithSuchNameNotExist() {
        //any
        Cargo cargo = new Cargo("Car", 2, 1, 1);
        СargoCarriage сargoCarriage = new СargoCarriage(3, 100_000, 100_000);

        //do
        сargoCarriage.addCargo(cargo);

        //expect
        assertThat(сargoCarriage.DeleteCargoByName("Carr"), is("There is no cargo with such name in the carriage"));
        assertThat(сargoCarriage.infoAboutCargoByName("Car"), is(cargo.getInfo()));
    }


}