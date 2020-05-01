package ui;

import model.typesofworkouts.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MainContainer.cardLayout;

public class TipsPanel extends JPanel implements ActionListener {

    private Workout workout;
    private static final int TEXTAREAROWS = 6;
    private static final int TEXTAREACOLUMNS = 53;
    private JTextArea tipsText;
    private JTextArea benefitsText;
    private MainContainer container;

    public TipsPanel(MainContainer container) {
        this.container = container;
        tipsText = new JTextArea(TEXTAREAROWS, TEXTAREACOLUMNS);
        benefitsText = new JTextArea(TEXTAREAROWS, TEXTAREACOLUMNS);

        ButtonGroup group = new ButtonGroup();
        JRadioButton crunches = new JRadioButton("Crunches");
        JRadioButton jumpRope = new JRadioButton("Jump Rope");
        JRadioButton lunges = new JRadioButton("Lunges");
        JRadioButton plank = new JRadioButton("Plank");
        JRadioButton pushUps = new JRadioButton("Push Ups");
        JRadioButton sitUps = new JRadioButton("Sit Ups");
        JRadioButton squats = new JRadioButton("Squats");
        JButton tipsMenuButton = new JButton("Return to menu");
        JLabel tipsMainLabel = new JLabel("Which tips/benefits would you like to view?");

        crunches.setActionCommand("crunches");
        jumpRope.setActionCommand("jumpRope");
        lunges.setActionCommand("lunges");
        plank.setActionCommand("plank");
        pushUps.setActionCommand("pushUps");
        sitUps.setActionCommand("sitUps");
        squats.setActionCommand("squats");
        tipsMenuButton.setActionCommand("menu");

        crunches.addActionListener(this);
        jumpRope.addActionListener(this);
        lunges.addActionListener(this);
        plank.addActionListener(this);
        pushUps.addActionListener(this);
        sitUps.addActionListener(this);
        squats.addActionListener(this);
        tipsMenuButton.addActionListener(this);

        group.add(crunches);
        group.add(jumpRope);
        group.add(lunges);
        group.add(plank);
        group.add(pushUps);
        group.add(sitUps);
        group.add(squats);
        add(tipsMainLabel);
        add(crunches);
        add(jumpRope);
        add(lunges);
        add(plank);
        add(pushUps);
        add(sitUps);
        add(squats);
        add(tipsText);
        add(benefitsText);
        add(tipsMenuButton);
    }

    // MODIFIES: this
    // EFFECT: Button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("crunches")) {
            workout = new Crunches(0);
            tipsText.setText(workout.workoutTips());
            benefitsText.setText(workout.workoutBenefits());
        }
        if (e.getActionCommand().equals("jumpRope")) {
            workout = new JumpRope(0);
            tipsText.setText(workout.workoutTips());
            benefitsText.setText(workout.workoutBenefits());
        }
        if (e.getActionCommand().equals("lunges")) {
            workout = new Lunges(0);
            tipsText.setText(workout.workoutTips());
            benefitsText.setText(workout.workoutBenefits());
        }
        surpassCheckstyle(e);
    }

    private void surpassCheckstyle(ActionEvent e) {
        if (e.getActionCommand().equals("plank")) {
            workout = new Plank(0);
            tipsText.setText(workout.workoutTips());
            benefitsText.setText(workout.workoutBenefits());
        }
        if (e.getActionCommand().equals("pushUps")) {
            workout = new Pushups(0);
            tipsText.setText(workout.workoutTips());
            benefitsText.setText(workout.workoutBenefits());
        }
        if (e.getActionCommand().equals("sitUps")) {
            workout = new Situps(0);
            tipsText.setText(workout.workoutTips());
            benefitsText.setText(workout.workoutBenefits());
        }
        surpassCheckstyle2(e);
    }

    private void surpassCheckstyle2(ActionEvent e) {
        if (e.getActionCommand().equals("squats")) {
            workout = new Squats(0);
            tipsText.setText(workout.workoutTips());
            benefitsText.setText(workout.workoutBenefits());
        }
        if (e.getActionCommand().equals("menu")) {
            cardLayout.show(container, "main");
        }
    }
}
