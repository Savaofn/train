import humans.Passanger;
import org.junit.jupiter.api.Test;
import сarriage.PassangerCarriage;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.MatcherAssert.assertThat;

class PassangerCarriageTest {

    @Test
    void addPassanger_Valid() {
        //any
        Passanger passanger = new Passanger("1", "Joh", "White", 23, 1);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //expect
        passangerCarriage.addPassanger(passanger);
    }

    @Test
    void addDriver_inValidPlaceNotExist() {
        //any
        Passanger passanger = new Passanger("1", "Joh", "White", 23, 234);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //expect
        assertThrows(IllegalArgumentException.class, () -> passangerCarriage.addPassanger(passanger));

    }

    @Test
    void addDriver_inValidPlaceAlreadyTaken() {
        //any
        Passanger passanger = new Passanger("1", "Joh", "White", 23, 2);
        Passanger passanger1 = new Passanger("1", "Joffdfh", "White", 23, 2);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //do
        passangerCarriage.addPassanger(passanger);

        //expect
        assertThrows(IllegalArgumentException.class, () -> passangerCarriage.addPassanger(passanger1));


    }

    @Test
    void addDriver_inValidPassangerNullInfo() {
        //any
        Passanger passanger = new Passanger("1", null, "White", 23, 234);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //expect
        assertThrows(IllegalArgumentException.class, () -> passangerCarriage.addPassanger(passanger));

    }


    @Test
    void infoAboutPassangerByTicketNumber_PassangerWithSuchTicketNumberExist() {
        //any
        Passanger passanger = new Passanger("1", "vcdc", "White", 23, 2);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //do
        passangerCarriage.addPassanger(passanger);

        //expect
        assertThat(passangerCarriage.infoAboutPassangerByTicketNumber(2), is(passanger.getInfo()));

    }

    @Test
    void infoAboutPassangerByTicketNumber_PassangerWithSuchTicketNumberNotExist() {
        //any
        Passanger passanger = new Passanger("1", "cdfw", "White", 23, 2);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //do
        passangerCarriage.addPassanger(passanger);

        //expect
        assertThat(passangerCarriage.infoAboutPassangerByTicketNumber(3), is("There is no passenger with such a ticket in the carriage"));
    }

    @Test
    void deletePassangerByTicketNumber_PassangerWithSuchTicketNumberExist() {
        //any
        Passanger passanger = new Passanger("1", "cdfw", "White", 23, 2);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //do
        passangerCarriage.addPassanger(passanger);

        //expect
        assertThat(passangerCarriage.deletePassangerByTicketNumber(2), is("Humans.Passanger deleted"));
        assertThat(passangerCarriage.infoAboutPassangerByTicketNumber(2), is("There is no passenger with such a ticket in the carriage"));
    }

    @Test
    void deletePassangerByTicketNumber_PassangerWithSuchTicketNumberNotExist() {
        //any
        Passanger passanger = new Passanger("1", "cdfw", "White", 23, 2);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);

        //do
        passangerCarriage.addPassanger(passanger);

        //expect
        assertThat(passangerCarriage.deletePassangerByTicketNumber(3), is("There is no passenger with such a ticket in the carriage"));
        assertThat(passangerCarriage.infoAboutPassangerByTicketNumber(2), is(passanger.getInfo()));
    }
}
