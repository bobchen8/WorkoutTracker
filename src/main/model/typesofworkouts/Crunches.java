package model.typesofworkouts;

public class Crunches extends Workout {
    public Crunches(int numRepetitions) {
        super(numRepetitions);
        workoutName = "Crunches";
    }

    @Override
    public String workoutTips() {
        return  "Tips for Crunches:\n"
                + "Breathe on the way down and exhale on the way up!\n"
                + "Do not go crunch too high, try bringing your ribs to your belly-button.\n"
                + "Do not rely on momentum! Crunch slowly and steadily for best results.\n"
                + "Do not strain your neck! Maintain a fist-sized space"
                + " between your chin and chest.";
    }

    @Override
    public String workoutBenefits() {
        return "Benefits of Crunches:\n"
                + "Targets the primary ab muscle to build your core fast!\n"
                + "Improves your posture, therefore reducing back pain!";
    }
}
