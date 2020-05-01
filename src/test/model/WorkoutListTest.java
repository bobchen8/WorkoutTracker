package model;


import model.typesofworkouts.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutListTest {
    private WorkoutList workouts;
    private Workout w;

    @BeforeEach
    public void runBefore() {
        workouts = new WorkoutList();
        w = new Pushups(29);
    }


    @Test
    public void testAddWorkout(){
        Workout y = new Situps(43);
        workouts.addWorkout(w);
        assertEquals("Push Ups", workouts.getWorkoutList().get(0).getWorkoutName());
        assertEquals(29, workouts.getWorkoutList().get(0).getNumRepetitions());
        workouts.addWorkout(y);
        assertEquals("Sit Ups", workouts.getWorkoutList().get(1).getWorkoutName());
        assertEquals(43, workouts.getWorkoutList().get(1).getNumRepetitions());
    }

    @Test
    public void testRemoveWorkout(){
        Workout y = new Situps(43);
        workouts.addWorkout(w);
        workouts.addWorkout(y);
        workouts.removeWorkout(w);
        assertEquals("Sit Ups", workouts.getWorkoutList().get(0).getWorkoutName());
    }

    @Test
    public void testEqualsAndHashcode() {
        assertEquals(workouts, workouts);
        assertNotEquals(workouts, null);
        assertNotEquals(null, workouts);
        assertNotEquals(w, workouts);
        assertNotEquals(workouts, w);
        workouts.hashCode();
    }

}
