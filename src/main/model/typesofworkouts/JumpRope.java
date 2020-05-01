package model.typesofworkouts;

public class JumpRope extends Workout {
    public JumpRope(int numRepetitions) {
        super(numRepetitions);
        workoutName = "Jump Rope";
    }

    @Override
    public String workoutTips() {
        return "Tips for Jump Rope:\n"
                + "When landing, the weight should be over the balls of your feet.\n"
                + "Turn the rope with your wrist, not your elbow and shoulders!\n"
                + "Stay relaxed and loosen up! Having tension makes jump rope harder and less effective.\n";
    }

    @Override
    public String workoutBenefits() {
        return  "Benefits of Jump Rope:\n"
                + "One of the best cardio workouts! Burns calories across your body effectively.\n"
                + "Improve your coordination between your eyes, feet, and hands.\n"
                + "Increases the elasticity of your lower-leg muscles, therefore reducing lower-leg injuries!";
    }
}
