package model;

import model.typesofworkouts.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

// Represents a list of Workouts
public class WorkoutList implements Serializable {
    private ArrayList<Workout> workoutList;

    // EFFECT: Returns true if two workout list objects are the same, false otherwise
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkoutList that = (WorkoutList) o;
        return Objects.equals(workoutList, that.workoutList);
    }

    // EFFECT: Returns the hashcode for a workout list object
    @Override
    public int hashCode() {
        return Objects.hash(workoutList);
    }

    // EFFECTS: workoutList is empty
    public WorkoutList() {
        workoutList = new ArrayList<>();
    }

    // EFFECTS: getter for WorkoutList
    public ArrayList<Workout> getWorkoutList() {
        return workoutList;
    }

    // MODIFIES: this
    // EFFECTS: Adds a workout to the list
    public void addWorkout(Workout w) {
        workoutList.add(w);
    }

    // MODIFIES: this
    // EFFECTS: Removes a workout from the list
    public void removeWorkout(Workout w) {
        workoutList.remove(w);
    }

}
