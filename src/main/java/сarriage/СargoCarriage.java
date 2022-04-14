package сarriage;

import cargo.Cargo;
import сarriage.Carriage;

import java.util.ArrayList;

public class СargoCarriage extends Carriage {
    private ArrayList<Cargo> cargoList;
    private final double maxCarrying;

    public double getCurrentWight() {
        return currentWight;
    }

    private double currentWight;
    private final double maxSize;
    private double currentSize;


    public СargoCarriage(int number, double maxCarrying, double maxSize) {
        super(number);
        this.maxCarrying = maxCarrying;
        this.maxSize = maxSize;

        this.cargoList = new ArrayList<>();
    }

    public double getMaxCarrying() {
        return maxCarrying;
    }

    public ArrayList<Cargo> getCargoList() {
        return cargoList;
    }

    public String addCargo(Cargo cargo) {
        if (cargo.getCargoName() == null || cargo.getWeight() <= 0 || cargo.getNumber() <= 0 || cargo.getSize() <= 0) {
            throw new IllegalArgumentException("Fields are incorrectly filled");
        }
        this.currentWight += cargo.getWeight() * cargo.getNumber();
        if (this.currentWight > this.maxCarrying) {
            throw new IllegalArgumentException("Weight limit exceeded");
        }
        this.currentSize += cargo.getSize() * cargo.getNumber();
        if (this.currentSize > this.maxSize) {
            throw new IllegalArgumentException("Size limit exceeded");
        }
        cargoList.add(cargo);
        return "cargo.Cargo added";
    }

    public String infoAboutCargoByName(String name) {
        for (Cargo i : this.cargoList) {
            if (i.getCargoName().equals(name)) {
                return i.getInfo();
            }
        }
        return "There is no cargo with such name in the carriage";
    }

    public String DeleteCargoByName(String name) {
        for (Cargo i : this.cargoList) {
            if (i.getCargoName().equals(name)) {
                this.cargoList.remove(i);
                return "cargo.Cargo deleted";
            }
        }
        return "There is no cargo with such name in the carriage";
    }
}



