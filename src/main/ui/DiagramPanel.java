//package ui;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import static ui.MainContainer.cardLayout;
//
//public class DiagramPanel extends JPanel implements ActionListener {
//
//    private MainContainer container;
//    private CardLayout imageCard;
//    private JPanel imagePanel;
//
//    public DiagramPanel(MainContainer container) {
//        this.container = container;
//
//        BorderLayout borderLayout = new BorderLayout();
//        setLayout(borderLayout);
//
//        JPanel panel = new JPanel();
//
//        ButtonGroup group = new ButtonGroup();
//        JRadioButton crunches = new JRadioButton("Crunches");
//        JRadioButton jumpRope = new JRadioButton("Jump Rope");
//        JRadioButton lunges = new JRadioButton("Lunges");
//        JRadioButton plank = new JRadioButton("Plank");
//        JRadioButton pushUps = new JRadioButton("Push Ups");
//        JRadioButton sitUps = new JRadioButton("Sit Ups");
//        JRadioButton squats = new JRadioButton("Squats");
//        JButton diagramMenuButton = new JButton("Return to menu");
//        JLabel diagramMainLabel = new JLabel("Which workout's diagram would you like to see?");
//
//        imagePanel = new JPanel();
//        imageCard = new CardLayout();
//        imagePanel.setLayout(imageCard);
//        imagePanel.setPreferredSize(new Dimension(500, 500));
//
//        JLabel pushUpImage = new JLabel();
//        JLabel sitUpImage = new JLabel();
//        JLabel plankImage = new JLabel();
//        JLabel jumpRopeImage = new JLabel();
//        JLabel crunchesImage = new JLabel();
//        JLabel lungesImage = new JLabel();
//        JLabel squatsImage = new JLabel();
//
//        pushUpImage.setSize(450, 240);
//        sitUpImage.setSize(450, 240);
//        plankImage.setSize(450, 240);
//        jumpRopeImage.setSize(450, 240);
//        crunchesImage.setSize(450, 240);
//        lungesImage.setSize(450, 240);
//        squatsImage.setSize(450, 240);
//
//        createWorkoutImage(pushUpImage, "pushUp_rgb.png");
//        createWorkoutImage(sitUpImage, "sitUp_rgb.png");
//        createWorkoutImage(plankImage, "plank_rgb.png");
//        createWorkoutImage(jumpRopeImage, "jumpRope_rgb.png");
//        createWorkoutImage(crunchesImage, "crunches_rgb.png");
//        createWorkoutImage(lungesImage, "lunges_rgb.png");
//        createWorkoutImage(squatsImage, "squat_rgb.png");
//
//        crunches.setActionCommand("crunches");
//        jumpRope.setActionCommand("jumpRope");
//        lunges.setActionCommand("lunges");
//        plank.setActionCommand("plank");
//        pushUps.setActionCommand("pushUps");
//        sitUps.setActionCommand("sitUps");
//        squats.setActionCommand("squats");
//        diagramMenuButton.setActionCommand("menu");
//
//        crunches.addActionListener(this);
//        jumpRope.addActionListener(this);
//        lunges.addActionListener(this);
//        plank.addActionListener(this);
//        pushUps.addActionListener(this);
//        sitUps.addActionListener(this);
//        squats.addActionListener(this);
//        diagramMenuButton.addActionListener(this);
//
//        group.add(crunches);
//        group.add(jumpRope);
//        group.add(lunges);
//        group.add(plank);
//        group.add(pushUps);
//        group.add(sitUps);
//        group.add(squats);
//        panel.add(diagramMainLabel);
//        panel.add(crunches);
//        panel.add(jumpRope);
//        panel.add(lunges);
//        panel.add(plank);
//        panel.add(pushUps);
//        panel.add(sitUps);
//        panel.add(squats);
//        panel.add(diagramMenuButton);
//        add(panel, BorderLayout.NORTH);
//        add(imagePanel, BorderLayout.CENTER);
//
//        imageCard.addLayoutComponent(pushUpImage, "pushUps");
//        imageCard.addLayoutComponent(sitUpImage, "sitUps");
//        imageCard.addLayoutComponent(plankImage, "plank");
//        imageCard.addLayoutComponent(jumpRopeImage, "jumpRope");
//        imageCard.addLayoutComponent(crunchesImage, "crunches");
//        imageCard.addLayoutComponent(lungesImage, "lunges");
//        imageCard.addLayoutComponent(squatsImage, "squats");
//
//        imageCard.show(imagePanel, "pushUps");
//    }
//
//    private void createWorkoutImage(JLabel label, String file) {
//        Image image = bufferedImage(file).getScaledInstance(label.getWidth(), label.getHeight(),
//                Image.SCALE_SMOOTH);
//        ImageIcon pushUpIcon = new ImageIcon(image);
//        label.setIcon(pushUpIcon);
//    }
//
//    private BufferedImage bufferedImage(String file) {
//        BufferedImage bufferedImage = null;
//        try {
//            bufferedImage = ImageIO.read(new File(file));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bufferedImage;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals("menu")) {
//            cardLayout.show(container, "main");
//        }
//        if (e.getActionCommand().equals("crunches")) {
//            imageCard.show(imagePanel, "crunches");
//        }
//        if (e.getActionCommand().equals("pushUps")) {
//            imageCard.show(imagePanel, "pushUps");
//        }
//    }
//}
