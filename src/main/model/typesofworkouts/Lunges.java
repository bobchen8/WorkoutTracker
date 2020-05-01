package model.typesofworkouts;

public class Lunges extends Workout {
    public Lunges(int numRepetitions) {
        super(numRepetitions);
        workoutName = "Lunges";
    }

    @Override
    public String workoutTips() {
        return  "Tips for Lunges: \n"
                + "Lower hips until both knees are bent at a 90 degree angle.\n"
                + "Keep your body weight on the heels.\n"
                + "Stand straight, keep your back straight, shoulders relaxed, and chin up.";
    }

    @Override
    public String workoutBenefits() {
        return  "Benefits of Lunges: \n"
                + "Helps you achieve better body balance and coordination!\n"
                + "Engages abdominal muscles, and strengthens legs and buttocks.";
    }
}
