package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    private MainContainer workoutMenuContainer;

    public MainPanel(MainContainer container) {
        this.workoutMenuContainer = container;
        BorderLayout menuBorderLayout = new BorderLayout();
//        JPanel southPanel = new JPanel(new BorderLayout());
        JLabel mainLabel = new JLabel("Welcome to your personal workout tracker!");

        JButton mainViewButton = new JButton("Access a workout list");
        JButton mainRemoveButton = new JButton("Remove a workout list");
        JButton mainAddButton = new JButton("Add a new workout list");
        JButton mainTipsButton = new JButton("View workout tips/benefits!");
//        JButton mainDiagramButton = new JButton("View diagrams for several workouts!");

        mainViewButton.setActionCommand("access panel");
        mainRemoveButton.setActionCommand("remove panel");
        mainAddButton.setActionCommand("add panel");
        mainTipsButton.setActionCommand("tips panel");
//        mainDiagramButton.setActionCommand("diagram panel");

        mainViewButton.addActionListener(this);
        mainRemoveButton.addActionListener(this);
        mainAddButton.addActionListener(this);
        mainTipsButton.addActionListener(this);
//        mainDiagramButton.addActionListener(this);

        menuBorderLayout.setHgap(5);
        menuBorderLayout.setVgap(5);
        setLayout(menuBorderLayout);

//        southPanel.add(mainTipsButton, BorderLayout.WEST);
//        southPanel.add(mainDiagramButton, BorderLayout.EAST);

        add(mainLabel, BorderLayout.NORTH);
        add(mainViewButton, BorderLayout.WEST);
        add(mainRemoveButton, BorderLayout.CENTER);
        add(mainAddButton, BorderLayout.EAST);
        add(mainTipsButton, BorderLayout.SOUTH);
//        add(southPanel, BorderLayout.SOUTH);

        mainViewButton.setPreferredSize(new Dimension(200, 100));
        mainRemoveButton.setPreferredSize(new Dimension(200, 100));
        mainAddButton.setPreferredSize(new Dimension(200, 100));
        mainTipsButton.setPreferredSize(new Dimension(302, 100));
//        mainDiagramButton.setPreferredSize(new Dimension(302, 100));
    }

    // MODIFIES: this
    // EFFECT: Button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("access panel")) {
            workoutMenuContainer.showAccessPanel();
        }
        if (e.getActionCommand().equals("remove panel")) {
            workoutMenuContainer.showRemovePanel();
        }
        if (e.getActionCommand().equals("add panel")) {
            workoutMenuContainer.showAddPanel();
        }
        if (e.getActionCommand().equals("tips panel")) {
            workoutMenuContainer.showTipsPanel();
        }
//        if (e.getActionCommand().equals("diagram panel")) {
//            workoutMenuContainer.showDiagramPanel();
//        }
    }
}
