package model.typesofworkouts;

public class Pushups extends Workout {
    public Pushups(int numRepetitions) {
        super(numRepetitions);
        workoutName = "Push Ups";
    }

    @Override
    public String workoutTips() {
        return  "Tips for Push Ups:\n" + "Keep your back straight, don't arch or sag your back!\n"
                + "Your butt should be down, not lifted.\n"
                + "Breathe in as you go down, and breathe out as you go up!";
    }

    @Override
    public String workoutBenefits() {
        return  "Benefits of Push Ups:\n" + "Great workout to build muscles!: Builds biceps, triceps, core, "
                + "anterior deltoids and lower body.\n"
                + "Improve your posture and suffer less from back pain!";
    }
}
