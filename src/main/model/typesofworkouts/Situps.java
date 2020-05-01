package model.typesofworkouts;

public class Situps extends Workout {
    public Situps(int numRepetitions) {
        super(numRepetitions);
        workoutName = "Sit Ups";
    }

    @Override
    public String workoutTips() {
        return  "Tips for Sit Ups:\n"
                + "Do sit-ups slowly and steadily for best results.\n"
                + "Do not strain your neck! Maintain a fist-sized space between your chin.\n"
                + "and chest throughout the entire movement.\n"
                + "Breathe on the way down and exhale on the way up!";
    }

    @Override
    public String workoutBenefits() {
        return  "Benefits of Sit Ups:\n"
                + "Works abs, lower back, hip flexors, and neck!";
    }
}
