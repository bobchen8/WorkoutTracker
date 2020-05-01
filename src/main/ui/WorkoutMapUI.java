//package ui;
//
//import model.Subject;
//import network.Network;
//import model.WorkoutMap;
//import model.recordrepetitions.RepetitionsMap;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.Scanner;
//
//public class WorkoutMapUI implements Serializable {
//    private WorkoutMap workoutMap;
//    private RepetitionsMap repetitionsMap;
//    private Subject subject;
//
//    WorkoutMapUI(Scanner scanner) {
//        workoutMap = new WorkoutMap();
//        repetitionsMap = new RepetitionsMap();
//        subject = new Subject();
//        try {
//            workoutMap.load("savefile.txt");
//            repetitionsMap.load("repetitions.txt");
//            subject.load("subject.txt");
//        } catch (IOException e) {
//            System.out.println("ERROR: Could not load from save file.");
//        } catch (ClassNotFoundException e) {
//            System.out.println("ERROR: Could not load from save file. ClassNotFoundException");
//        } finally {
//            addWorkoutListLoop(scanner);
//        }
//    }
//
//    private void addWorkoutListLoop(Scanner scanner) {
//        Boolean x = true;
//        while (true) {
//            try {
//                Network.displayIntro();
//            } catch (IOException e) {
//                System.out.println("Oh no!");
//            }
//            menuText();
//            String s = scanner.nextLine();
//            getToDo(s, scanner);
//        }
//    }
//
//    private void menuText() {
//        System.out.println("Welcome to your personal workout tracker!"
//                + " Press number: \n[1]View all of your workout lists \n[2]Remove a workout list\n"
//                + "[3]Add a workout list");
//    }
//
//    private void getToDo(String operation, Scanner scanner) {
//        switch (operation) {
//            case "1":
//                showWorkoutLists(scanner);
//                trySave();
//                break;
//            case "2":
//                removeWorkoutList(scanner);
//                trySave();
//                break;
//            case "3":
//                addWorkoutList(scanner);
//                trySave();
//                break;
//            default:
//                break;
//        }
//    }
//
//    private void trySave() {
//        try {
//            workoutMap.save("savefile.txt");
//        } catch (IOException e) {
//            System.out.println("ERROR: Could not save to save file");
//        }
//    }
//
//    private void showWorkoutLists(Scanner scanner) {
//        if (workoutMap.getWorkoutMap().isEmpty()) {
//            System.out.println("You currently have no workout lists!");
//        } else {
//            System.out.println("Here are all your workout lists.");
//            System.out.println(workoutMap.getWorkoutMap().keySet());
//            System.out.println("Which list would you like to access? Type the name of the list to continue, or "
//                    + "enter 'quit' to return to menu.");
//            String s = scanner.nextLine();
//            accessList(s, scanner);
//        }
//
//    }
//
//    private void accessList(String listName, Scanner scanner) {
//        if (listName.equals("quit")) {
//            addWorkoutListLoop(scanner);
//        }
//        if (workoutMap.getWorkoutMap().containsKey(listName)) {
//            while (true) {
//                menuTextForList();
//                String nextWorkout = scanner.nextLine();
//                if (nextWorkout.equals("0")) {
//                    break;
//                }
//                workoutMap.getWorkoutMap().get(listName).chooseOperationUI1(nextWorkout, scanner);
//                trySave();
//
//            }
//        } else {
//            System.out.println("You didn't enter a valid name!");
//            showWorkoutLists(scanner);
//        }
//    }
//
//    private void menuTextForList() {
//        System.out.println("What would you like to do?"
//                + " Press number: \n[1]Add a new workout \n[2]Remove a workout\n"
//                + "[3]Show current workout list\n"
//                + "[4]Do workouts!\n"
//                + "[5]Add repetitions to a current workout\n"
//                + "[6]View the tips and benefits of a workout\n"
//                + "[0]Return to menu");
//    }
//
//    private void removeWorkoutList(Scanner scanner) {
//        if (workoutMap.getWorkoutMap().isEmpty()) {
//            System.out.println("You currently have no workout lists!");
//        } else {
//            System.out.println("Here are all your current workout lists.");
//            System.out.println(workoutMap.getWorkoutMap().keySet());
//            System.out.println("Which list would you like to remove? Type the name of the list to remove, or "
//                    + "enter 'quit' to return to the menu.");
//            String listToRemove = scanner.nextLine();
//            if (listToRemove.equals("quit")) {
//                addWorkoutListLoop(scanner);
//            }
//            workoutMap.removeWorkoutList(listToRemove);
//        }
//    }
//
//    private void addWorkoutList(Scanner scanner) {
//        if (!workoutMap.getWorkoutMap().isEmpty()) {
//            System.out.println("Here are all your current workout lists");
//            System.out.println(workoutMap.getWorkoutMap().keySet());
//        }
//        System.out.println("To make a new workout list, type the name of your new list, or "
//                + "enter 'quit' to return to the menu");
//        String newList = scanner.nextLine();
//        if (newList.equals("quit")) {
//            addWorkoutListLoop(scanner);
//        }
//        if (workoutMap.getWorkoutMap().containsKey(newList)) {
//            System.out.println("Two lists cannot have the same name!");
//            addWorkoutListLoop(scanner);
//        } else {
//            workoutMap.addWorkoutList(newList, new WorkoutListUI());
//            workoutMap.getWorkoutMap().get(newList).addObserver(repetitionsMap);
//        }
//
//    }
//}
