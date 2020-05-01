package ui;

import model.WorkoutMap;
import model.recordrepetitions.RepetitionsMap;
import ui.accesslistpanels.AccessContainer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import static java.util.Collections.sort;

@SuppressWarnings("WeakerAccess")
public class MainContainer extends JPanel {

    public static final CardLayout cardLayout = new CardLayout();
    public static WorkoutMap workoutMap = new WorkoutMap();
    public static RepetitionsMap repetitionsMap = new RepetitionsMap();
    public JLabel addCurrentWorkoutLists = new JLabel();
    public JLabel removeCurrentWorkoutLists = new JLabel();
    public JLabel accessSelectListCurrentWorkoutLists = new JLabel();

    public static String accessListName;

    public MainContainer() {
        try {
            repetitionsMap.load("repetitions.txt");
            workoutMap.load("savefile.txt");
        } catch (IOException e) {
            System.out.println("Load IO Exception");
        } catch (ClassNotFoundException e) {
            System.out.println("Load class not found exception");
        }


        setLayout(cardLayout);
        setPreferredSize(new Dimension(600, 300));


//        initializeMainPanel(mainPanel);
        JPanel mainPanel = new MainPanel(this);
        JPanel removePanel = new RemovePanel(this);
        JPanel addPanel = new AddPanel(this);
        JPanel tipsPanel = new TipsPanel(this);
        JPanel accessPanel = new AccessContainer(this);
//        JPanel diagramPanel = new DiagramPanel(this);


        add(mainPanel, "main");
        add(accessPanel, "access");
        add(removePanel, "remove");
        add(addPanel, "add");
        add(tipsPanel, "tips");
//        add(diagramPanel, "diagram");

        cardLayout.show(this, "main");
    }

    // Citation for displaying new line in JLabel: https://stackoverflow.com/questions/1090098/newline-in-jlabel
    // Citation for StringBuilder
    // EFFECT: Returns a StringBuilder of the beginning of the string for displaying current workout lists
    public StringBuilder addMakeString() {
        ArrayList<String> keys = new ArrayList<>(workoutMap.getWorkoutMap().keySet());
        sort(keys);
        StringBuilder addPanelString = new StringBuilder("<html>Here are your current workout lists: <br/>");
        for (String key : keys) {
            addPanelString.append(key);
            addPanelString.append("<br/>");
        }
        addPanelString.append("<html>");
        return addPanelString;
    }

    // MODIFIES: savefile.txt
    // EFFECT: Saves workout map to file
    public void trySave() {
        try {
            workoutMap.save("savefile.txt");
        } catch (IOException e) {
            System.out.println("Save IO Exception");
        }
    }

    // MODIFIES: repetitions.txt
    // EFFECT: Saves repetitions map to file
    public void trySaveRepetitions() {
        try {
            repetitionsMap.save("repetitions.txt");
        } catch (IOException e) {
            System.out.println("Could not save repetitions map");
        }
    }

    // EFFECT: Shows access panel
    public void showAccessPanel() {
        cardLayout.show(this, "access");
    }

    // EFFECT: Shows remove panel
    public void showRemovePanel() {
        cardLayout.show(this, "remove");
    }

    // EFFECT: Shows add panel
    public void showAddPanel() {
        cardLayout.show(this, "add");
    }

    // EFFECT: Shows tips panel
    public void showTipsPanel() {
        cardLayout.show(this, "tips");
    }

//    public void showDiagramPanel() {
//        cardLayout.show(this, "diagram");
//    }


}
