package model.typesofworkouts;

import model.WorkoutList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Workout implements Serializable {
    protected int numRepetitions;
    protected String workoutName;

    public Workout(int numRepetitions) {
        this.numRepetitions = numRepetitions;
    }

    // MODIFIES: this
    // EFFECT: subtracts int i from numRepetitions, sets numRepetitions at 0 if i > numRepetitions
    public void subtractRepetitions(int i) {
        if (i <= getNumRepetitions()) {
            numRepetitions -= i;
        } else {
            numRepetitions = 0;
        }
    }

    // MODIFIES: this
    // EFFECT: Adds int i to numRepetitions
    public void addRepetitions(int i) {
        numRepetitions += i;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    // EFFECTS: getter for numRepetitions
    public int getNumRepetitions() {
        return numRepetitions;
    }

    // MODIFIES: this
    // EFFECTS: Integer i is the new number of repetitions for the workout
    public void setNumber(int n) {
        this.numRepetitions = n;
    }

    // EFFECT: Returns a string of the tips of a workout
    public abstract String workoutTips();

    // EFFECT: Returns a string of the benefits of a workout
    public abstract String workoutBenefits();

}
