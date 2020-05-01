package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class WorkoutMapTest {
    private WorkoutMap workoutMap;

    @BeforeEach
    public void runBefore(){workoutMap = new WorkoutMap();}


    @Test
    public void testAddWorkoutList(){
        workoutMap.addWorkoutList("test", new WorkoutList());
        assertEquals(1,workoutMap.getWorkoutMap().size());
    }

    @Test
    public void testRemoveWorkoutList(){
        workoutMap.addWorkoutList("test", new WorkoutList());
        workoutMap.removeWorkoutList("test");
        assertEquals(0, workoutMap.getWorkoutMap().size());
    }

    @Test
    public void testSaveAndLoad() throws IOException, ClassNotFoundException {
        WorkoutList testList = new WorkoutList();
        WorkoutList testList2 = new WorkoutList();
        workoutMap.addWorkoutList("test", testList);
        workoutMap.save("testsavefile.txt");
        workoutMap.getWorkoutMap().replace("test", testList, testList2);
        workoutMap.load("testsavefile.txt");
        assertEquals(testList, workoutMap.getWorkoutMap().get("test"));
    }

}
