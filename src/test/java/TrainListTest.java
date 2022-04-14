import org.junit.jupiter.api.Test;
import сarriage.Locomotive;
import сarriage.PassangerCarriage;
import сarriage.TrainList;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TrainListTest {

    @Test
    void addCarriageInTrain_Valid() {
        //any
        Locomotive locomotive = new Locomotive(1);
        TrainList trainList = new TrainList();

        //expected
        trainList.addCarriageInTrain(locomotive);
    }

    @Test
    void addCarriageInTrain_InValidNotLocomotiveFirst() {
        //any
        PassangerCarriage passangerCarriage = new PassangerCarriage(1, 23);
        TrainList trainList = new TrainList();

        //expected
        assertThrows(IllegalArgumentException.class, () -> trainList.addCarriageInTrain(passangerCarriage));
    }

    @Test
    void allCarriageNumberInfo_Valid() {
        //any
        Locomotive locomotive = new Locomotive(1);
        PassangerCarriage passangerCarriage = new PassangerCarriage(2, 23);
        TrainList trainList = new TrainList();

        //do
        trainList.addCarriageInTrain(locomotive);
        trainList.addCarriageInTrain(passangerCarriage);

        //expected
        assertThat(trainList.allCarriageNumberInfo(), is(true));
    }

    @Test
    void allCarriageNumberInfo_InValidTrainEmpty() {
        //any
        TrainList trainList = new TrainList();

        //expected
        assertThat(trainList.allCarriageNumberInfo(), is(false));
    }

    @Test
    void returnCarriageByNumber_Valid() {
        Locomotive locomotive = new Locomotive(1);
        TrainList trainList = new TrainList();

        //do
        trainList.addCarriageInTrain(locomotive);

        //expected
        assertThat(trainList.returnCarriageByNumber(1), is(Optional.of(locomotive)));
    }

    @Test
    void returnCarriageByNumber_InValid() {
        Locomotive locomotive = new Locomotive(1);
        TrainList trainList = new TrainList();

        //do
        trainList.addCarriageInTrain(locomotive);

        //expected
        assertThat(trainList.returnCarriageByNumber(2), is(Optional.empty()));
    }
}