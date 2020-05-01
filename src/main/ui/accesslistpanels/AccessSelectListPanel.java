package ui.accesslistpanels;

import ui.MainContainer;
import ui.accesslistpanels.AccessContainer;

import javax.swing.*;
import java.awt.*;

import static ui.MainContainer.*;
import static ui.accesslistpanels.AccessContainer.accessCardLayout;

public class AccessSelectListPanel extends JPanel {

    public AccessSelectListPanel(MainContainer container, AccessContainer accessContainer) {
        BorderLayout accessSelectListLayout = new BorderLayout();
        setLayout(accessSelectListLayout);

        // accessSelectListPanel back to menu button
        JButton accessSelectListMenuButton = new JButton("Return to menu");
        accessSelectListMenuButton.addActionListener(ae -> cardLayout.show(container, "main"));

        // accessSelectListPanel display workout lists
        StringBuilder accessSelectListPanelString = container.addMakeString();
        container.accessSelectListCurrentWorkoutLists.setText(accessSelectListPanelString.toString());

        // accessSelectListPanel text area
        JTextField accessSelectListPanelTextArea = new JTextField();

        // accessSelectListPanel access button
        JButton accessWorkoutListsButton = new JButton("Access workout list!");
        accessWorkoutListsButton.addActionListener(ae -> {
            if (workoutMap.getWorkoutMap().containsKey(accessSelectListPanelTextArea.getText().trim())) {
                accessListName = accessSelectListPanelTextArea.getText().trim();
                accessContainer.updateComboBoxes();
                accessContainer.accessLabel.setText("<html>The workout list you are currently in is : <br/><html>"
                        + accessSelectListPanelTextArea.getText()
                        + "<html> <br/>What would you like to do?<html>");
                accessCardLayout.show(accessContainer, "access main");
            }
        });

        // accessSelectListPanel instruction label
        JLabel accessSelectListInstructionLabel = new JLabel("To access a workout list, type the name of the list"
                + " and press \" Access workout list!\"");
        add(accessSelectListPanelTextArea, BorderLayout.CENTER);
        add(accessWorkoutListsButton, BorderLayout.EAST);
        add(accessSelectListInstructionLabel, BorderLayout.NORTH);
        add(accessSelectListMenuButton, BorderLayout.SOUTH);
        add(container.accessSelectListCurrentWorkoutLists, BorderLayout.WEST);
    }
}
