import humans.Driver;
import humans.License;
import сarriage.Locomotive;
import сarriage.PassangerCarriage;
import сarriage.Train;
import сarriage.TrainList;

public class main {
    public static void main(String[] args) {
        Locomotive locomotive=new Locomotive(1);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2,34);
        TrainList trainList = new TrainList();
        trainList.addCarriageInTrain(locomotive);
        trainList.addCarriageInTrain(passangerCarriage);
        trainList.allCarriageNumberInfo();
    }


}
