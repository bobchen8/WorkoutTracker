package ui.accesslistpanels;

import model.WorkoutList;
import model.typesofworkouts.*;
import sun.applet.Main;
import ui.MainContainer;

import javax.swing.*;
import java.awt.*;

import static ui.MainContainer.accessListName;
import static ui.MainContainer.workoutMap;

@SuppressWarnings("WeakerAccess")
public class AccessContainer extends JPanel {

    public JLabel accessLabel = new JLabel("");
    public static final CardLayout accessCardLayout = new CardLayout();
    public JLabel addWorkoutsLabel = new JLabel();
    public JLabel removeWorkoutLabel = new JLabel();
    public JLabel editWorkoutLabel = new JLabel();
    public JLabel recordWorkoutLabel = new JLabel();
    public JComboBox<String> editComboBox = new JComboBox<>();
    public JComboBox<String> removeComboBox = new JComboBox<>();
    public JComboBox<String> recordComboBox = new JComboBox<>();
    public JComboBox<String> addComboBox = new JComboBox<>();
    private MainContainer container;

    public AccessContainer(MainContainer container) {
        this.container = container;
        setLayout(accessCardLayout);

        JPanel accessMainPanel = new AccessMainPanel(container, this);
        JPanel accessSelectListPanel = new AccessSelectListPanel(container, this);
        JPanel addWorkoutPanel = new AccessAddPanel(this);
        JPanel removeWorkoutPanel = new AccessRemovePanel(this);
        JPanel editWorkoutPanel = new AccessEditPanel(this);
        JPanel recordWorkoutsPanel = new AccessRecordPanel(this);

        add(addWorkoutPanel, "add workout");
        add(editWorkoutPanel, "edit workout");
        add(recordWorkoutsPanel, "record workout");
        add(removeWorkoutPanel, "remove workout");
        add(accessMainPanel, "access main");
        add(accessSelectListPanel, "access select list");

        accessCardLayout.show(this, "access select list");
    }

    // Public methods
    // EFFECT: Saves the workoutMap to a file
    public void accessTrySave() {
        container.trySave();
    }

    // EFFECT: Saves the repetitions to a file
    public void accessTrySaveRepetitions() {
        container.trySaveRepetitions();
    }

    // MODIFIES: this
    // EFFECT: Updates the text of each JLabel
    public void updateText() {
        recordSetText();
        addSetText();
        removeSetText();
        editSetText();
    }

    // MODIFIES: this
    // EFFECT: Updates each JComboBox
    public void updateComboBoxes() {
        clearComboBoxes();
        addBoxComponents();
        setUpBoxes();
    }

    // EFFECT: Returns true if it is possible to update, otherwise opens a JOptionPane and returns false
    public boolean canUpdate(String selectedItem) {
        if (checkTextInteger(selectedItem) && Integer.parseInt(selectedItem) >= 0) {
            return true;
        } else {
            if (!checkTextInteger(selectedItem)) {
                JOptionPane.showMessageDialog(null, "Enter a number for the number of "
                        + "repetitions!");
            } else {
                JOptionPane.showMessageDialog(null, "Enter a positive number "
                        + "for the number of repetitions!");
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECT: Returns a workout
    public Workout selectWorkout(String text) {
        Workout workout;
        if (text.equals("Crunches")) {
            workout = new Crunches(0);
            return workout;
        }
        if (text.equals("Jump Rope")) {
            workout = new JumpRope(0);
            return workout;
        }
        if (text.equals("Plank")) {
            workout = new Plank(0);
            return workout;
        }
        if (text.equals("Lunges")) {
            workout = new Lunges(0);
            return workout;
        }
        return surpassCheckstyleSelectWorkout(text);
    }

    // EFFECT: Returns true if item in addComboBox is null, returns false otherwise
    public boolean addIsNull() {
        if (addComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You didn't select a workout!");
            return true;
        }
        return false;
    }

    // EFFECT: Returns true if item in recordComboBox is null, returns false otherwise
    public boolean recordIsNull() {
        if (recordComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You didn't select a workout!");
            return true;
        }
        return false;
    }

    // EFFECT: Returns true if item in editComboBox is null, returns false otherwise
    public boolean editIsNull() {
        if (editComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You didn't select a workout!");
            return true;
        }
        return false;
    }

    // EFFECT: Returns true if item in removeComboBox is null, returns false otherwise
    public boolean removeIsNull() {
        if (removeComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You didn't select a workout!");
            return true;
        }
        return false;
    }

    // Private methods
    private StringBuilder workoutString(WorkoutList workoutList) {
        StringBuilder workoutsString = new StringBuilder("<html>Here are the current workouts in your list:<br/>");
        for (Workout workout : workoutList.getWorkoutList()) {
            workoutsString.append(workout.getWorkoutName());
            workoutsString.append(" -- Number of ");
            workoutsString.append(workout.getWorkoutName());
            workoutsString.append(" to do: ");
            workoutsString.append(workout.getNumRepetitions());
            workoutsString.append("<br/>");
        }
        return workoutsString;
    }

    private void recordSetText() {
        StringBuilder text = workoutString(workoutMap.getWorkoutMap().get(accessListName));
        text.append("Which workout would you like to record?<html>");
        recordWorkoutLabel.setText(text.toString());
    }

    private void addSetText() {
        StringBuilder text = workoutString(workoutMap.getWorkoutMap().get(accessListName));
        text.append("Which workout would you like to add?<html>");
        addWorkoutsLabel.setText(text.toString());
    }

    private void removeSetText() {
        StringBuilder text = workoutString(workoutMap.getWorkoutMap().get(accessListName));
        text.append("Which workout would you like to remove?<html>");
        removeWorkoutLabel.setText(text.toString());
    }

    private void editSetText() {
        StringBuilder text = workoutString(workoutMap.getWorkoutMap().get(accessListName));
        text.append("Which workout would you like to edit?<html>");
        editWorkoutLabel.setText(text.toString());
    }

    private void setUpBoxes() {
        for (Workout workout : workoutMap.getWorkoutMap().get(accessListName).getWorkoutList()) {
            addComboBox.removeItem(workout.getWorkoutName());
        }
        for (Workout workout : workoutMap.getWorkoutMap().get(accessListName).getWorkoutList()) {
            removeComboBox.addItem(workout.getWorkoutName());
        }
        for (Workout workout : workoutMap.getWorkoutMap().get(accessListName).getWorkoutList()) {
            editComboBox.addItem(workout.getWorkoutName());
        }
        for (Workout workout : workoutMap.getWorkoutMap().get(accessListName).getWorkoutList()) {
            recordComboBox.addItem(workout.getWorkoutName());
        }
    }

    private void clearComboBoxes() {
        addComboBox.removeAllItems();
        removeComboBox.removeAllItems();
        editComboBox.removeAllItems();
        recordComboBox.removeAllItems();
    }

    private void addBoxComponents() {
        addComboBox.addItem("Crunches");
        addComboBox.addItem("Jump Rope");
        addComboBox.addItem("Lunges");
        addComboBox.addItem("Plank");
        addComboBox.addItem("Push Ups");
        addComboBox.addItem("Sit Ups");
        addComboBox.addItem("Squats");
    }

    //  Citation: https: stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
    private boolean checkTextInteger(String repetitions) {
        try {
            Integer.parseInt(repetitions);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private Workout surpassCheckstyleSelectWorkout(String text) {
        Workout workout;
        if (text.equals("Push Ups")) {
            workout = new Pushups(0);
            return workout;
        }
        if (text.equals("Sit Ups")) {
            workout = new Situps(0);
            return workout;
        } else {
            workout = new Squats(0);
            return workout;
        }
    }
}
