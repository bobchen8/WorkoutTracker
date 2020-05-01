package model.typesofworkouts;

public class Squats extends Workout {

    public Squats(int numRepetitions) {
        super(numRepetitions);
        workoutName = "Squats";
    }

    @Override
    public String workoutTips() {
        return  "Tips for Squats:\n"
                + "Execute with feet shoulder-width apart, turned out at 30 degrees, and flat on the floor!\n"
                + "Push as you go down, push your knees to the side in the direction of your feet.\n"
                + "Have your lower back in a natural, neutral position. No excess arching!";
    }

    @Override
    public String workoutBenefits() {
        return  "Benefits of Squats:\n"
                + "Works your quadriceps, hamstrings, calves, abs, lower back, and buttocks.\n"
                + "Great workout for burning calories!\n"
                + "If done correctly, can help prevent injuries, help with balance, and improve flexibility!";
    }
}
