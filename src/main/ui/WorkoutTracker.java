package ui;

import java.awt.*;

import javax.swing.*;

public class WorkoutTracker extends JFrame {

    private MainContainer wp;

    public WorkoutTracker() {
        super("Workout Tracker");

        // Citation: https://stackoverflow.com/questions/4219919/how-to-change-the-background-color-on-a-java-panel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setUndecorated(false);
        wp = new MainContainer();
        add(wp);
        pack();
        centreOnScreen();
        setVisible(true);
        setResizable(false);

//        scanner = new Scanner(System.in);
//        mapUI = new WorkoutMapUI(scanner);
    }

    private void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECT:
    public static void main(String[] args) {
        new WorkoutTracker();
    }
}
