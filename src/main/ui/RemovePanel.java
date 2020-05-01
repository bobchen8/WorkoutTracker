package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MainContainer.cardLayout;
import static ui.MainContainer.workoutMap;

public class RemovePanel extends JPanel implements ActionListener {

    private MainContainer container;
    private JTextField removeTextArea = new JTextField();

    public RemovePanel(MainContainer container) {
        this.container = container;

        BorderLayout removePanelLayout = new BorderLayout();
        JButton removeMenuButton = new JButton("Return to menu");
        JButton removeButton = new JButton("Remove workout list!");

        removeMenuButton.setActionCommand("menu");
        removeButton.setActionCommand("remove");

        removeMenuButton.addActionListener(this);
        removeButton.addActionListener(this);

        StringBuilder removePanelString = container.addMakeString();
        container.removeCurrentWorkoutLists.setText(removePanelString.toString());

        // addPanel instruction label
        JLabel removeInstructionLabel = new JLabel("To remove a workout list, type the name of the list and "
                + "press \"Remove workout list!\"");

        setLayout(removePanelLayout);
        add(removeInstructionLabel, BorderLayout.NORTH);
        add(removeTextArea, BorderLayout.CENTER);
        add(container.removeCurrentWorkoutLists, BorderLayout.WEST);
        add(removeMenuButton, BorderLayout.SOUTH);
        add(removeButton, BorderLayout.EAST);
        container.removeCurrentWorkoutLists.setPreferredSize(new Dimension(220, 100));
    }

    // MODIFIES: this
    // EFFECT: Button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("menu")) {
            cardLayout.show(container, "main");
        }
        if (e.getActionCommand().equals("remove")) {
            workoutMap.removeWorkoutList(removeTextArea.getText().trim());
            container.trySave();
            container.removeCurrentWorkoutLists.setText(container.addMakeString().toString());
            container.addCurrentWorkoutLists.setText(container.addMakeString().toString());
            container.accessSelectListCurrentWorkoutLists.setText(container.addMakeString().toString());
        }
    }
}
