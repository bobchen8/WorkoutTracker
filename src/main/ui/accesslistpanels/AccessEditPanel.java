package ui.accesslistpanels;

import model.typesofworkouts.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MainContainer.accessListName;
import static ui.MainContainer.workoutMap;
import static ui.accesslistpanels.AccessContainer.accessCardLayout;

public class AccessEditPanel extends JPanel implements ActionListener {

    private AccessContainer container;
    private JTextField newNum;

    public AccessEditPanel(AccessContainer container) {
        this.container = container;

        BorderLayout editWorkoutLayout = new BorderLayout();

        JPanel editWorkoutPanel = new JPanel();

        JLabel instructionsLabel = new JLabel("Choose a workout to edit, "
                + "and enter the number of repetitions to change to!");

        newNum = new JTextField();
        newNum.setPreferredSize(new Dimension(55, 25));
        JButton editWorkoutButton = new JButton("Update number of repetitions!");
        JButton editBackButton = new JButton("Go back");

        editWorkoutButton.setActionCommand("edit");
        editBackButton.setActionCommand("back");

        editWorkoutButton.addActionListener(this);
        editBackButton.addActionListener(this);

        editWorkoutPanel.add(container.editComboBox);
        editWorkoutPanel.add(instructionsLabel);
        editWorkoutPanel.add(newNum);
        editWorkoutPanel.add(editWorkoutButton);
        editWorkoutPanel.add(editBackButton);

        setLayout(editWorkoutLayout);
        add(container.editWorkoutLabel, BorderLayout.NORTH);
        add(editWorkoutPanel, BorderLayout.CENTER);
    }

    @Override
    // MODIFIES: this
    // EFFECT: Button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("back")) {
            accessCardLayout.show(container, "access main");
        }
        if (e.getActionCommand().equals("edit")) {
            if (!container.editIsNull()) {
                editWorkout();
                container.updateText();
            }
        }
    }

    private void editWorkout() {
        if (container.canUpdate(newNum.getText())) {
            for (Workout workout : workoutMap.getWorkoutMap().get(accessListName).getWorkoutList()) {
                if ((container.editComboBox.getSelectedItem()).equals(workout.getWorkoutName())) {
                    workout.setNumber(Integer.parseInt(newNum.getText()));
                    container.accessTrySave();
                }
            }
        }
    }


}
