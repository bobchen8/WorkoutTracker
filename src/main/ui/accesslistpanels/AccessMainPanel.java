package ui.accesslistpanels;

import ui.MainContainer;
import ui.accesslistpanels.AccessContainer;

import javax.swing.*;
import java.awt.*;

import static ui.accesslistpanels.AccessContainer.accessCardLayout;
import static ui.MainContainer.*;

public class AccessMainPanel extends JPanel {

    public AccessMainPanel(MainContainer container, AccessContainer accessContainer) {
        GridLayout accessMainGrid = new GridLayout(3, 3, 5, 5);

        JButton accessReturnMainMenuButton = new JButton("Return to main menu");
        JButton accessAddWorkoutButton = new JButton("Add a workout to your list");
        JButton accessRemoveWorkoutButton = new JButton("Remove a workout from your list");
        JButton accessEditWorkoutsButton = new JButton("Edit workouts in your list");
        JButton accessRecordWorkoutsButton = new JButton("Record workouts done");


        accessAddWorkoutButton.addActionListener(ae -> {
            accessContainer.updateText();
            accessCardLayout.show(accessContainer, "add workout");
        });
        accessRemoveWorkoutButton.addActionListener(ae -> {
            accessContainer.updateText();
            accessCardLayout.show(accessContainer, "remove workout");
        });
        accessEditWorkoutsButton.addActionListener(ae -> {
            accessContainer.updateText();
            accessCardLayout.show(accessContainer, "edit workout");
        });
        accessRecordWorkoutsButton.addActionListener(ae -> {
            accessContainer.updateText();
            accessCardLayout.show(accessContainer, "record workout");
        });
        accessReturnMainMenuButton.addActionListener(ae -> {
            accessCardLayout.show(accessContainer, "access select list");
            cardLayout.show(container, "main");
        });

        setLayout(accessMainGrid);
        add(accessContainer.accessLabel);
        add(accessAddWorkoutButton);
        add(accessRemoveWorkoutButton);
        add(accessEditWorkoutsButton);
        add(accessRecordWorkoutsButton);
        add(accessReturnMainMenuButton);
    }
}
