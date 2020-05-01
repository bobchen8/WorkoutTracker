package ui.accesslistpanels;

import model.WorkoutList;
import model.typesofworkouts.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MainContainer.accessListName;
import static ui.MainContainer.workoutMap;
import static ui.accesslistpanels.AccessContainer.accessCardLayout;

@SuppressWarnings("WeakerAccess")
public class AccessAddPanel extends JPanel implements ActionListener {

    private AccessContainer container;
    private Workout workout;
    private JTextField numRepetitionsText;

    public AccessAddPanel(AccessContainer container) {
        this.container = container;

        BorderLayout addWorkoutLayout = new BorderLayout();

        JPanel numRepetitionsPanel = new JPanel();
        numRepetitionsText = new JTextField();
        JLabel repetitionsLabel = new JLabel("Enter the number of repetitions to initiate workout with:");
        numRepetitionsText.setPreferredSize(new Dimension(55, 25));

        JButton addWorkoutButton = new JButton("Add workout to list!");
        JButton addBackButton = new JButton("Go back");

        addWorkoutButton.setActionCommand("add");
        addBackButton.setActionCommand("back");

        addWorkoutButton.addActionListener(this);
        addBackButton.addActionListener(this);

        numRepetitionsPanel.add(container.addComboBox);
        numRepetitionsPanel.add(repetitionsLabel);
        numRepetitionsPanel.add(numRepetitionsText);
        numRepetitionsPanel.add(addWorkoutButton);
        numRepetitionsPanel.add(addBackButton);

        setLayout(addWorkoutLayout);
        add(container.addWorkoutsLabel, BorderLayout.NORTH);
        add(numRepetitionsPanel, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECT: Adds workout if add button is clicked, shows menu if back button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add")) {
            if (!container.addIsNull()) {
                if (container.canUpdate(numRepetitionsText.getText())) {
                    addWorkout();
                }
            }
        }
        if (e.getActionCommand().equals("back")) {
            accessCardLayout.show(container, "access main");
        }
    }

    private void addWorkout() {
        workout = container.selectWorkout((String) container.addComboBox.getSelectedItem());
        workout.setNumber(Integer.parseInt(numRepetitionsText.getText()));
        workoutMap.getWorkoutMap().get(accessListName).addWorkout(workout);
        container.accessTrySave();
        container.updateText();
        container.updateComboBoxes();
    }

}
