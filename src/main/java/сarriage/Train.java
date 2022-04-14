package сarriage;

public class Train {
    public Carriage carriage;
    public Train next;
    public Train(Carriage carriage) {
        this.carriage = carriage;
    }
}