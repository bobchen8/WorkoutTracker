package ui;

import model.WorkoutList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MainContainer.cardLayout;
import static ui.MainContainer.workoutMap;

public class AddPanel extends JPanel implements ActionListener {

    private MainContainer container;
    private JTextField addTextArea = new JTextField();

    public AddPanel(MainContainer container) {
        this.container = container;

        BorderLayout addPanelLayout = new BorderLayout();
        JButton addMenuButton = new JButton("Return to menu");
        JButton addButton = new JButton("Create new workout list!");
        JLabel addInstructionLabel = new JLabel("To create a new workout list, type the name of your new list and "
                + "press \"Create new workout list!\"");

        addMenuButton.setActionCommand("menu");
        addButton.setActionCommand("add");

        addMenuButton.addActionListener(this);
        addButton.addActionListener(this);

        // addPanel display workout lists
        StringBuilder addPanelString = container.addMakeString();
        container.addCurrentWorkoutLists.setText(addPanelString.toString());

        setLayout(addPanelLayout);
        add(addInstructionLabel, BorderLayout.NORTH);
        add(addTextArea, BorderLayout.CENTER);
        add(container.addCurrentWorkoutLists, BorderLayout.WEST);
        add(addMenuButton, BorderLayout.SOUTH);
        add(addButton, BorderLayout.EAST);
        container.addCurrentWorkoutLists.setPreferredSize(new Dimension(220, 100));
    }

    // MODIFIES: this
    // EFFECTS: Button actiosn
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("menu")) {
            cardLayout.show(container, "main");
        }
        if (e.getActionCommand().equals("add")) {
            if (!addTextArea.getText().equals("")) {
                workoutMap.addWorkoutList(addTextArea.getText().trim(), new WorkoutList());
                container.trySave();
                container.addCurrentWorkoutLists.setText(container.addMakeString().toString());
                container.removeCurrentWorkoutLists.setText(container.addMakeString().toString());
                container.accessSelectListCurrentWorkoutLists.setText(container.addMakeString().toString());
            }
        }
    }
}
