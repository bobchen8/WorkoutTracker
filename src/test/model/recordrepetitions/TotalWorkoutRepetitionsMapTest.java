package model.recordrepetitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TotalWorkoutRepetitionsMapTest {

    private RepetitionsMap map;

    @BeforeEach
    public void runBefore(){
        map = new RepetitionsMap();
    }

    @Test
    public void testSaveAndLoad() throws IOException, ClassNotFoundException {
        map.getRepetitionMap().put("Test", 20);
        map.save("testrepetitionssavefile.txt");
        map.getRepetitionMap().replace("Test", 40);
        map.load("testrepetitionssavefile.txt");
        assertEquals(20, map.getRepetitionMap().get("Test"));
    }
//
//    @Test
//    public void testUpdate(){
//        assertEquals(0, map.getRepetitionMap().get("Crunches"));
//        map.update("Crunches", 20);
//        assertEquals(20, map.getRepetitionMap().get("Crunches"));
//        map.update("Crunches", 20);
//        assertEquals(40, map.getRepetitionMap().get("Crunches"));
//    }
}
