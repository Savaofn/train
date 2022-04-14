package сarriage;

import сarriage.Carriage;
import сarriage.Locomotive;

import java.util.Optional;

public class TrainList {
    private Train head;

    public TrainList() {
        head = null;
    }

    private boolean isTrainEmpty() {
        return head == null;
    }

    public Boolean addCarriageInTrain(Carriage carriage) {
        if (carriage == null) {
            return false;
        }
        Train temp = new Train(carriage);
        if (head == null && carriage.getClass() != Locomotive.class) {
            throw new IllegalArgumentException("The first carriage must be a locomotive");
        }
        temp.next = head;
        head = temp;
        return true;
    }

    public boolean allCarriageNumberInfo() {
        if (isTrainEmpty()) {
            System.out.println("сarriage.Train is empty");
            return false;
        }
        Train temp = head;
        while (temp != null) {
            System.out.println(temp.carriage.getNumber()+"   "+temp.carriage.getClass().getName());
            temp = temp.next;
        }
        return true;
    }

    public Optional<Carriage> returnCarriageByNumber(int number) {
        Train temp = head;
        while (temp != null) {
            if (temp.carriage.getNumber() == number) {
                System.out.println(number);
                return Optional.of(temp.carriage);
            }
            temp = temp.next;
        }
        System.out.println("There is no carriage with such number in the train" + "\n");
        return Optional.empty();
    }
}
