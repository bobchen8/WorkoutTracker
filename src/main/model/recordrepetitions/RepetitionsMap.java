package model.recordrepetitions;

import model.Loadable;
import model.Saveable;


import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RepetitionsMap implements Loadable, Saveable, Serializable {

    public Map<String, Integer> repetitionMap;

    public RepetitionsMap() {
        repetitionMap = new HashMap<>();
        repetitionMap.put("Crunches", 0);
        repetitionMap.put("Jump Rope", 0);
        repetitionMap.put("Lunges", 0);
        repetitionMap.put("Plank", 0);
        repetitionMap.put("Push Ups", 0);
        repetitionMap.put("Sit Ups", 0);
        repetitionMap.put("Squats", 0);
    }

    public Map<String, Integer> getRepetitionMap() {
        return repetitionMap;
    }

    public void updateRepetition(String s, int i) {
        int oldNum = repetitionMap.get(s);
        repetitionMap.replace(s, oldNum + i);
    }

    //Citation for loading: https://www.youtube.com/watch?v=YzwiuRDgSSY
    // MODIFIES: this
    // EFFECT: Loads the repetition map object from a file
    @Override
    public void load(String s) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(s));
        repetitionMap = (Map<String, Integer>) is.readObject();
        is.close();
    }

    //Citation for saving: https://www.youtube.com/watch?v=YzwiuRDgSSY (same citation as load)
    // MODIFIES: t
    // EFFECT: Saves the repetition map object to a file
    @Override
    public void save(String s) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(s));
        os.writeObject(repetitionMap);
        os.close();
    }

//    @Override
//    public void update(String s, Integer i) {
//        Integer num = repetitionMap.get(s);
//        num += i;
//        repetitionMap.replace(s, num);
//        System.out.println("You have done a total of " + num + " " + s
//                + " for all workout lists combined!");
//        try {
//            save("repetitions.txt");
//        } catch (IOException e) {
//            System.out.println("Error: Could not save repetitions");
//        }
//    }
}
