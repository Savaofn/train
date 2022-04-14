package сarriage;

import humans.Passanger;
import сarriage.Carriage;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;

public class PassangerCarriage extends Carriage {
    private int numberOfSeats;
    private ArrayList<Passanger> passangerList;

    public PassangerCarriage(int number, int numberOfSeats) {
        super(number);
        this.numberOfSeats = numberOfSeats;
        this.passangerList = new ArrayList<>();
    }


    public String addPassanger(Passanger passanger) {
        if (passanger.getFirstName() == null || passanger.getLastName() == null || passanger.getId() == null) {
            throw new IllegalArgumentException("Fields are not filled");
        }
        for (Passanger i : this.passangerList) {
            if (passanger.getTicketNumber() == i.getTicketNumber()) {
                throw new IllegalArgumentException("Place already taken");
            }
        }
        if (passanger.getTicketNumber() > this.numberOfSeats || passanger.getTicketNumber() <= 0) {
            throw new IllegalArgumentException("This place doesn't exist");
        }
        this.passangerList.add(passanger);
        return "Humans.Passanger added";
    }

    public String infoAboutPassangerByTicketNumber(int ticketNumber) {
        for (Passanger i : this.passangerList) {
            if (i.getTicketNumber() == ticketNumber) {
                return i.getInfo();
            }
        }
        return "There is no passenger with such a ticket in the carriage";
    }

    public String deletePassangerByTicketNumber(int ticketNumber) {
        for (Passanger i : this.passangerList) {
            if (i.getTicketNumber() == ticketNumber) {
                this.passangerList.remove(i);
                return "Humans.Passanger deleted";
            }
        }
        return "There is no passenger with such a ticket in the carriage";
    }
}

