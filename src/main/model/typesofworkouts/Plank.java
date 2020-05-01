package model.typesofworkouts;

public class Plank extends Workout {
    public Plank(int numRepetitions) {
        super(numRepetitions);
        workoutName = "Plank";
    }

    @Override
    public String workoutTips() {
        return "Tips for Planks:\n" + "Don't sink down your shoulders.\n"
                + "Remember to breathe slow and steady. Don't hold your breath!\n"
                + "Flex your abs, lower back, and glutes for a better workout.\n"
                + "Keep your hips in a neutral position: Not too low, not too high.\n"
                + "Keep your spine and knees straight!";
    }

    @Override
    public String workoutBenefits() {
        return "Benefits of Planks:\n" + "Strengthens your core!\n"
                + "Increases your flexibility to reduce risk of injury.\n"
                + "Improve your posture and suffer less back pain.\n"
                + "Increase metabolism!";
    }
}
