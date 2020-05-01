package model;

import model.typesofworkouts.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutTest {
    private Workout pushups;
    private Workout situps;
    private Workout plank;
    private Workout crunches;
    private Workout squats;
    private Workout lunges;
    private Workout jumpRope;

    @BeforeEach
    public void runBefore() {
        pushups = new Pushups(100);
        situps = new Situps(200);
        plank = new Plank(300);
        crunches = new Crunches(400);
        squats = new Squats(500);
        lunges = new Lunges(600);
        jumpRope = new JumpRope(700);
    }

    @Test
    public void testSetNumber() {
        assertEquals(600, lunges.getNumRepetitions());
        lunges.setNumber(12);
        assertEquals(12, lunges.getNumRepetitions());
        lunges.setNumber(24);
        assertEquals(24, lunges.getNumRepetitions());
    }

    @Test
    public void testAddRepetitions(){
        squats.addRepetitions(23);
        assertEquals(523, squats.getNumRepetitions());
    }

    @Test
    public void testSubtractRepetitions(){
        crunches.subtractRepetitions(50);
        assertEquals(350, crunches.getNumRepetitions());
        plank.subtractRepetitions(1000);
        assertEquals(0, plank.getNumRepetitions());
    }

    @Test
    public void testAllWorkoutMethods() {
        pushups.workoutBenefits();
        pushups.workoutTips();
        crunches.workoutTips();
        crunches.workoutBenefits();
        plank.workoutBenefits();
        plank.workoutTips();
        situps.workoutTips();
        situps.workoutBenefits();
        squats.workoutBenefits();
        squats.workoutTips();
        jumpRope.workoutTips();
        jumpRope.workoutBenefits();
        lunges.workoutBenefits();
        lunges.workoutTips();
    }
}
