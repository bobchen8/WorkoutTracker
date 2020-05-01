package ui.accesslistpanels;

import model.WorkoutList;
import model.typesofworkouts.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static ui.MainContainer.accessListName;
import static ui.MainContainer.workoutMap;
import static ui.accesslistpanels.AccessContainer.accessCardLayout;

public class AccessRemovePanel extends JPanel implements ActionListener {

    private AccessContainer container;


    public AccessRemovePanel(AccessContainer container) {
        this.container = container;

        BorderLayout removeWorkoutLayout = new BorderLayout();

        JPanel numRepetitionsPanel = new JPanel();
        JLabel repetitionsLabel = new JLabel("Which workout would you like to remove?");

        JButton addWorkoutButton = new JButton("Remove workout from list!");
        JButton addBackButton = new JButton("Go back");

        addWorkoutButton.setActionCommand("remove");
        addBackButton.setActionCommand("back");

        addWorkoutButton.addActionListener(this);
        addBackButton.addActionListener(this);

        numRepetitionsPanel.add(container.removeComboBox);
        numRepetitionsPanel.add(repetitionsLabel);
        numRepetitionsPanel.add(addWorkoutButton);
        numRepetitionsPanel.add(addBackButton);

        setLayout(removeWorkoutLayout);
        add(container.removeWorkoutLabel, BorderLayout.NORTH);
        add(numRepetitionsPanel, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECT: Button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("remove")) {
            if (!container.removeIsNull()) {
                ArrayList<Workout> workoutList = new ArrayList<>(workoutMap.getWorkoutMap()
                        .get(accessListName).getWorkoutList());
                for (Workout w : workoutList) {
                    if (stringsEqual((String) container.removeComboBox.getSelectedItem(), w.getWorkoutName())) {
                        workoutMap.getWorkoutMap().get(accessListName).removeWorkout(w);
                        container.accessTrySave();
                        container.updateText();
                        container.updateComboBoxes();
                    }
                }
            }
        }
        if (e.getActionCommand().equals("back")) {
            accessCardLayout.show(container, "access main");
        }
    }

    // Citation: For comparing two strings without considering spaces and case
    // https://stackoverflow.com/questions/17973964/how-to-compare-two-strings-in-java-without-considering-spaces
    private boolean stringsEqual(String w, String win) {
        if (win.replaceAll("\\s+", "").equalsIgnoreCase(w.replaceAll("\\s+", ""))) {
            return true;
        }
        return false;
    }
}
