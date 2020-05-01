//package model;
//
//import javax.swing.*;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class Subject implements Saveable, Loadable, Serializable {
//
//    private List<RepetitionObserver> listOfObservers;
//
//    public Subject() {
//        listOfObservers = new ArrayList<>();
//    }
//
//    public List<RepetitionObserver> getListOfObservers() {
//        return listOfObservers;
//    }
//
//    public void addObserver(RepetitionObserver observer) {
//        if (!listOfObservers.contains(observer)) {
//            listOfObservers.add(observer);
//        }
//        try {
//            save("subject.txt");
//        } catch (IOException e) {
//            System.out.println("Error: Could not save subject");
//        }
//    }
//
//    public void notifyObserver(String s, Integer i) {
//        for (RepetitionObserver observer : listOfObservers) {
//            observer.update(s, i);
//        }
//    }
//
//    @Override
//    public void load(String s) throws IOException, ClassNotFoundException {
//        ObjectInputStream is = new ObjectInputStream(new FileInputStream(s));
//        listOfObservers = (ArrayList<RepetitionObserver>) is.readObject(); //load subject object from save file
//        is.close();
//    }
//
//    @Override
//    public void save(String s) throws IOException {
//        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(s));
//        os.writeObject(listOfObservers); //write subject object to save file
//        os.close();
//    }
//}
