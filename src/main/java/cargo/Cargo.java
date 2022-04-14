package cargo;

public class Cargo {
    private final String cargoName;
    private final int number;
    private final double weight;
    private final double size;

    public Cargo(String cargoName, int number, double weight, double size) {
        this.cargoName = cargoName;
        this.number = number;
        this.weight = weight;
        this.size = size;
    }

    public String getCargoName() {
        return cargoName;
    }

    public int getNumber() {
        return number;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }

    public String getInfo() {
        return "CargoName: " + cargoName + " Number: " + number + " Weight: " + weight + " Size: " + size + "\n";
    }
}
