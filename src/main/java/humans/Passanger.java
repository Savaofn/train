package humans;

public class Passanger extends User {
    private int ticketNumber;

    public Passanger(String id, String firstName, String lastName, int age, int ticketNumber) {
        super(id, firstName, lastName, age);
        this.ticketNumber = ticketNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " TicketNumber: " + ticketNumber + "\n";
    }
}
