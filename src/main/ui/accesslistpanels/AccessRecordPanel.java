package ui.accesslistpanels;

import model.typesofworkouts.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static ui.MainContainer.*;
import static ui.accesslistpanels.AccessContainer.accessCardLayout;

public class AccessRecordPanel extends JPanel implements ActionListener {

    private AccessContainer container;
    private JTextField numDid;
    private JLabel finishedLabel;
    private JLabel totalRepsLabel;

    public AccessRecordPanel(AccessContainer container) {

        this.container = container;

        BorderLayout recordWorkoutLayout = new BorderLayout();

        JPanel recordWorkoutPanel = new JPanel();
        JLabel instructionLabel = new JLabel("Enter the number of repetitions you did for each workout!");
        finishedLabel = new JLabel("");
        totalRepsLabel = new JLabel("");

        numDid = new JTextField();
        numDid.setPreferredSize(new Dimension(55, 25));
        JButton recordWorkoutButton = new JButton("Record workout!");
        JButton recordBackButton = new JButton("Go back");
        JButton stopWatchButton = new JButton("Open stopwatch!");

        recordWorkoutButton.setActionCommand("record");
        recordBackButton.setActionCommand("back");
        stopWatchButton.setActionCommand("stopwatch");

        recordWorkoutButton.addActionListener(this);
        recordBackButton.addActionListener(this);
        stopWatchButton.addActionListener(this);

        recordWorkoutPanel.add(instructionLabel);
        recordWorkoutPanel.add(container.recordComboBox);
        recordWorkoutPanel.add(numDid);
        recordWorkoutPanel.add(recordWorkoutButton);
        recordWorkoutPanel.add(finishedLabel);
        recordWorkoutPanel.add(totalRepsLabel);
        recordWorkoutPanel.add(stopWatchButton);
        recordWorkoutPanel.add(recordBackButton);

        setLayout(recordWorkoutLayout);

        add(container.recordWorkoutLabel, BorderLayout.NORTH);
        add(recordWorkoutPanel, BorderLayout.CENTER);
    }


    // MODIFIES: this
    // EFFECT: Button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("back")) {
            accessCardLayout.show(container, "access main");
        }
        if (e.getActionCommand().equals("record")) {
            if (!container.recordIsNull()) {
                recordWorkout();
                container.updateText();
            }
        }
        if (e.getActionCommand().equals("stopwatch")) {
            new SimpleStopWatch();
        }
    }

    private void recordWorkout() {
        if (container.canUpdate(numDid.getText())) {
            for (Workout workout : workoutMap.getWorkoutMap().get(accessListName).getWorkoutList()) {
                if (workout.getWorkoutName().equals(container.recordComboBox.getSelectedItem())) {
                    workout.subtractRepetitions(Integer.parseInt(numDid.getText()));
                    repetitionsMap.updateRepetition(workout.getWorkoutName(), Integer.parseInt(numDid.getText()));
                    totalRepsLabel.setText("You have done a total of "
                            + repetitionsMap.getRepetitionMap().get(workout.getWorkoutName()) + " "
                            + workout.getWorkoutName() + " for all workout lists combined!");
                    container.accessTrySaveRepetitions();
                    if (workout.getNumRepetitions() == 0) {
                        finishedLabel.setText("You finished the workout: " + workout.getWorkoutName());
                    }
                }
            }

        }
    }
}
