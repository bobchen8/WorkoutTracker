//package ui;
//
//import model.Subject;
//import model.WorkoutList;
//import model.typesofworkouts.*;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Objects;
//import java.util.Scanner;
//
//
//public class WorkoutListUI extends Subject implements Serializable {
//    private WorkoutList workouts;
//    private Workout workout;
//
//    public WorkoutListUI() {
//        workouts = new WorkoutList();
//    }
//
//
//    private void addWorkoutLoopUI(Scanner scanner) {
//        String nextWorkout = scanner.nextLine();
//        chooseOperationUI1(nextWorkout, scanner);
//    }
//
//    private void printWorkoutsToDoUI() {
//        for (Workout w : workouts.getWorkoutList()) {
//            System.out.println(w.getNumRepetitions() + " " + w.getWorkoutName());
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        WorkoutListUI that = (WorkoutListUI) o;
//        return Objects.equals(workouts, that.workouts);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(workouts);
//    }
//
//    public void chooseOperationUI1(String nextWorkout, Scanner scanner) {
//        switch (nextWorkout) {
//            case "1":
//                makeWorkout(scanner);
//                break;
//            case "2":
//                removeWorkoutUI(scanner);
//                break;
//            case "3":
//                showWorkouts();
//                break;
//            default:
//                chooseOperationUI2(nextWorkout, scanner);
//        }
//    }
//
//    private void chooseOperationUI2(String nextWorkout, Scanner scanner) {
//        switch (nextWorkout) {
//            case "4":
//                doWorkouts(scanner);
//                break;
//            case "5":
//                addRepetitionsToWorkoutUI(scanner);
//                break;
//            case "6":
//                viewTipsAndBenefits1(scanner);
//                break;
//            default:
//                chooseOperationUI3(nextWorkout);
//        }
//    }
//
//    private void chooseOperationUI3(String nextWorkout) {
//        switch (nextWorkout) {
//            default:
//                break;
//        }
//    }
//
//    // BELOW IS ALL addRepetitionsToWorkout()
//    private void addRepetitionsToWorkoutUI(Scanner scanner) {
//        System.out.println("Which workout would you like to add repetitions to? These are your current workouts.");
//        printWorkoutsToDoUI();
//        String workoutNameInput = scanner.nextLine();
//        if (inputWorkoutIsInList(workoutNameInput)) {
//            System.out.println("How many repetitions would you like to add to " + workoutNameInput + "?");
//            String numToAddInput = scanner.nextLine();
//            finalAddRepetitionsUI(numToAddInput, workoutNameInput, scanner);
//        } else {
//            System.out.println("That's not an option! Type the name of the workout you want to add repetitions to.");
//            addRepetitionsToWorkoutUI(scanner);
//        }
//    }
//
//    private void finalAddRepetitionsUI(String numToAddInput, String workoutName, Scanner scanner) {
//        if (isStringInteger(numToAddInput) && (Integer.parseInt(numToAddInput) >= 0)) {
//            System.out.println("You added " + numToAddInput + " " + "repetitions to " + workoutName + "!");
//            for (Workout w : workouts.getWorkoutList()) {
//                if (inputWorkoutIsInList(workoutName)) {
//                    w.addRepetitions(Integer.parseInt(numToAddInput));
//                }
//            }
//        } else {
//            if (isStringInteger(numToAddInput)) {
//                System.out.println("Enter a positive number!");
//            } else {
//                System.out.println("Type a number!");
//            }
//            numToAddInput = scanner.nextLine();
//            finalAddRepetitionsUI(numToAddInput, workoutName, scanner);
//        }
//    }
//
//    //BELOW IS ALL viewTipsAndBenefits /////////////////////EDIT THIS BS///////////////////////
//    private void viewTipsAndBenefits1(Scanner scanner) {
//        System.out.println("Which workout would you like to view tips or benefits of?");
//        System.out.println("[1]Crunches, [2]Jump Rope, [3]Lunges, [4]Plank, [5]Pushups, [6]Situps,[7]Squats");
//        String viewTipsOrBenefits = scanner.nextLine();
//        if (isStringInteger(viewTipsOrBenefits) && (Integer.parseInt(viewTipsOrBenefits) >= 1)
//                && (Integer.parseInt(viewTipsOrBenefits) <= 7)) {
//            Workout workout = getWorkoutByNumber(viewTipsOrBenefits);
//            viewTipsAndBenefits2(workout, scanner);
//        } else {
//            System.out.println("That's not a valid option!");
//            viewTipsAndBenefits1(scanner);
//        }
//    }
//
//    private void viewTipsAndBenefits2(Workout workout, Scanner scanner) {
//        System.out.println("Would you like to: \n[1]View tips of " + workout.getWorkoutName());
//        System.out.println("[2]Or View benefits of " + workout.getWorkoutName() + "?");
//        String viewTipsorBenefits = scanner.nextLine();
//        if (viewTipsorBenefits.equals("1")) {
//            workout.workoutTips();
//        } else {
//            if (viewTipsorBenefits.equals("2")) {
//                workout.workoutBenefits();
//            } else {
//                System.out.println("Enter 1 or 2!");
//                viewTipsAndBenefits2(workout, scanner);
//            }
//        }
//    }
//
//    //BELOW IS ALL doWorkout()
//    private void doWorkouts(Scanner scanner) {
//        System.out.println("Here are your current workouts to do!");
//        printWorkoutsToDoUI();
//        System.out.println("After you finish some repetitions,\n"
//                + "Press [1] to record your repetitions!\n" + "Or press [2] to save and return to the menu!");
//        doWorkoutsWhileLoop(scanner);
//    }
//
//    private void doWorkoutsWhileLoop(Scanner scanner) {
//        while (true) {
//            String next1Or2 = scanner.nextLine();
//            if (isStringInteger(next1Or2)) {
//                if (next1Or2.equals("1")) {
//                    recordRepetitions1(scanner);
//                    break;
//                }
//                if (next1Or2.equals("2")) {
//                    addWorkoutLoopUI(scanner);
//                    break;
//                }
//            } else {
//                System.out.println("Choose [1] or [2]!");
//                doWorkouts(scanner);
//            }
//        }
//    }
//
//    private void recordRepetitions1(Scanner scanner) {
//        System.out.println("Which workout would you like to record repetitions of?");
//        printWorkoutsToDoUI();
//        String workoutToRecord = scanner.nextLine();
//        recordRepetitions2(workoutToRecord, scanner);
//    }
//
//    private void recordRepetitions2(String workoutToRecord, Scanner scanner) {
//        if (inputWorkoutIsInList(workoutToRecord)) {
//            recordRepetitions3(workoutToRecord, scanner);
//        } else {
//            System.out.println("That's not an option! Type the name of the workout you want to edit");
//            recordRepetitions1(scanner);
//        }
//    }
//
//    private void recordRepetitions3(String workoutToRecord, Scanner scanner) {
//        System.out.println("How many repetitions of " + workoutToRecord + " did you do?");
//        String repsDone = scanner.nextLine();
//        if (isStringInteger(repsDone) && (Integer.parseInt(repsDone) > 0)) {
//            checkWorkoutDone(repsDone, workoutToRecord);
//        } else {
//            if (isStringInteger(repsDone)) {
//                System.out.println("Enter a positive number!");
//            } else {
//                System.out.println("Type a number!");
//            }
//            recordRepetitions3(workoutToRecord, scanner);
//        }
//    }
//
//    private void checkWorkoutDone(String repsDone, String workoutToRecord) {
//        for (Workout w : workouts.getWorkoutList()) {
//            if (w.getWorkoutName().replaceAll("\\s+", "")
//                    .equalsIgnoreCase(workoutToRecord.replaceAll("\\s+", ""))) {
//                w.subtractRepetitions(Integer.parseInt(repsDone));
//                notifyObserver(w.getWorkoutName(), Integer.parseInt(repsDone));
//
//            }
//        }
//        ArrayList<Workout> newList = new ArrayList<>(workouts.getWorkoutList());
//        for (Workout w : newList) {
//            if (w.getNumRepetitions() == 0) {
//                System.out.println("You finished doing " + w.getWorkoutName() + "!");
//                workouts.removeWorkout(w);
//            }
//        }
//    }
//
//    // Citation: For comparing two strings without considering spaces and case
//    // https://stackoverflow.com/questions/17973964/how-to-compare-two-strings-in-java-without-considering-spaces
//    private boolean inputWorkoutIsInList(String w) {
//        for (Workout wo : workouts.getWorkoutList()) {
//            if (wo.getWorkoutName().replaceAll("\\s+", "")
//                    .equalsIgnoreCase(w.replaceAll("\\s+", ""))) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // BELOW IS removeWorkout()
//    private void removeWorkoutUI(Scanner scanner) {
//        System.out.println("What workout would you like to remove? These are your current workouts");
//        printWorkoutsToDoUI();
//        String toRemove = scanner.nextLine();
//        ArrayList<Workout> newList = new ArrayList<>(workouts.getWorkoutList());
//        for (Workout w : newList) {
//            if (inputWorkoutIsInList(toRemove)) {
//                workouts.removeWorkout(w);
//                System.out.println("You removed " + w.getWorkoutName() + " from the list!");
//            }
//        }
//    }
//
//    // BELOW IS ALL makeWorkout()
//    private void makeWorkout(Scanner scanner) {
//        System.out.println("What workout would you like to add?"
//                + " Press number to select workout type" + '\n'
//                + "[1]Crunches, [2]Jump Rope, [3]Lunges, [4]Plank, [5]Pushups, [6]Situps,[7]Squats");
//        String workoutType = scanner.nextLine();
//        if (isStringInteger(workoutType) && (Integer.parseInt(workoutType) > 0)
//                && (Integer.parseInt(workoutType) <= 7)) {
//            addWorkoutNum(getWorkoutByNumber(workoutType), scanner);
//        } else {
//            System.out.println("That's not an option!");
//            makeWorkout(scanner);
//        }
//    }
//
//    public Workout getWorkoutByNumber(String w) {
//        switch (w) {
//            case "1":
//                workout = new Crunches(0);
//                break;
//            case "2":
//                workout = new JumpRope(0);
//                break;
//            case "3":
//                workout = new Lunges(0);
//                break;
//            case "4":
//                workout = new Plank(0);
//                break;
//            default:
//                getWorkoutByNumber2(w);
//        }
//        return workout;
//    }
//
//    private void getWorkoutByNumber2(String w) {
//        switch (w) {
//            case "6":
//                workout = new Situps(0);
//                break;
//            case "7":
//                workout = new Squats(0);
//                break;
//            default:
//                workout = new Pushups(0);
//                break;
//        }
//    }
//
//    private void addWorkoutNum(Workout workout, Scanner scanner) {
//        workoutExist(workout, scanner);
//        System.out.println("Please choose the number of " + workout.getWorkoutName() + " you would like to add to the"
//                + " list");
//        String numRepetitions = scanner.nextLine();
//        if (isStringInteger(numRepetitions) && (Integer.parseInt(numRepetitions) > 0)) {
//            System.out.println("You added " + numRepetitions + " " + workout.getWorkoutName()
//                    + " to your workout list!");
//            workout.setNumber(Integer.parseInt(numRepetitions));
//            workouts.addWorkout(workout);
//        } else {
//            if (isStringInteger(numRepetitions)) {
//                System.out.println("Enter a positive number!");
//            } else {
//                System.out.println("Type a number!");
//            }
//            addWorkoutNum(workout, scanner);
//        }
//    }
//
//    private void workoutExist(Workout workout, Scanner scanner) {
//        boolean sameWorkout = false;
//        for (Workout w : workouts.getWorkoutList()) {
//            if (w.getWorkoutName().equals(workout.getWorkoutName())) {
//                sameWorkout = true;
//            }
//        }
//        if (sameWorkout) {
//            System.out.println("This workout was already in your workout list!");
//            addWorkoutLoopUI(scanner);
//        }
//    }
//
//    // To check if string is an integer
//    // Citation: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
//    private static boolean isStringInteger(String number) {
//        try {
//            Integer.parseInt(number);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    //BELOW IS showWorkouts()
//    private void showWorkouts() {
//        if (workouts.getWorkoutList().isEmpty()) {
//            System.out.println("Your workout list is empty!");
//        } else {
//            System.out.println("You currently need to do:");
//            printWorkoutsToDoUI();
//        }
//    }
//}








