package model;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WorkoutMap implements Loadable, Saveable, Serializable {
    private Map<String, WorkoutList> workoutMap;

    public WorkoutMap() {
        workoutMap = new HashMap<>();
    }

    // EFFECT: Getter for workout map
    public Map<String, WorkoutList> getWorkoutMap() {
        return workoutMap;
    }

    // MODIFIES: this
    // EFFECT: adds a workout list along with a name to the hash map
    public void addWorkoutList(String name, WorkoutList list) {
        workoutMap.put(name, list);
    }

    // MODIFIES: this
    // EFFECT: if workoutMap contains the key String name, remove String name from the hash map
    public void removeWorkoutList(String name) {
        if (workoutMap.containsKey(name)) {
            workoutMap.remove(name);
        }
    }


    //Citation: https://www.youtube.com/watch?v=YzwiuRDgSSY
    // MODIFIES: this
    // EFFECT: Loads the workoutMap from a file
    @Override
    public void load(String s) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(s));
        workoutMap = (Map<String, WorkoutList>) is.readObject(); //load workoutMap object from save file
        is.close();
    }

    //Citation: https://www.youtube.com/watch?v=YzwiuRDgSSY (same citation as load)
    // MODIFIES: s
    // EFFECT: Saves the workoutMap to a file
    @Override
    public void save(String s) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(s));
        os.writeObject(workoutMap); //write workoutMap object to save file
        os.close();
    }
}
