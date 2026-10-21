import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class MasseyRegistrationSystem {
    public static void main(String[] args){
        final String TASK1 = "System Full Name: Massey University Club Activity Registration System";
        System.out.println();
        System.out.println("--------- Task 1 ---------");
        System.out.println(TASK1);
        System.out.println();

        ArrayList<Activities> activitiesList = new ArrayList<>();

        // Set Activities and their details
        ArrayList<String> a101 = new ArrayList<>();
        Collections.addAll(a101, "Auckland", "PN");
        Activities a1 = new Activities("A101", "Basketball Club", "Sport", "Wednesday PM", true, true, a101);
        activitiesList.add(a1);

        ArrayList<String> a102 = new ArrayList<>();
        Collections.addAll(a102, "Auckland", "PN","Online");
        Activities a2 = new Activities("A102", "Coding Circle", "Technology", "Saturday AM", true, false, a102);
        activitiesList.add(a2);

        ArrayList<String> a103 = new ArrayList<>();
        Collections.addAll(a103, "Auckland", "PN");
        Activities a3 = new Activities("A103", "Choir Group", "Art", "Monday PM", false, false, a103);
        activitiesList.add(a3);

        ArrayList<String> a104 = new ArrayList<>();
        Collections.addAll(a104, "Auckland", "PN");
        Activities a4 = new Activities("A104", "Robotics Workshop", "Technology", "Friday PM", false, true, a104);
        activitiesList.add(a4);

        ArrayList<String> a105 = new ArrayList<>();
        Collections.addAll(a105, "Auckland", "PN","Online");
        Activities a5 = new Activities("A105", "Creative Writing Club", "Literature", "Thursday PM", true, false, a105);
        activitiesList.add(a5);

        ArrayList<String> a106 = new ArrayList<>();
        Collections.addAll(a106, "Auckland", "PN");
        Activities a6 = new Activities("A106", "Hiking Group", "Sport, Lifestyle", "Sunday AM", true, false, a106);
        activitiesList.add(a6);


        System.out.println("--------- Task 2 ---------");
        System.out.println("ALL Activities Details:");
        for (Activities act : activitiesList) {
            System.out.println(act.getId() + " " + act.getName()+ " (" + act.getCategory() + ") "+ act.getTimeSlot()+ " Mode: " + act.getMode());
        }
        System.out.println();


        System.out.println("--------- Task 3 ---------");
        System.out.println("Activities that belong to Sport category:");
        int sportsCount = 0;
        for (Activities activity : activitiesList) {
            if (activity.getCategory().contains("Sport")) {
                System.out.println("Activity - " + activity.getId() + " " + activity.getName());
                sportsCount++;
            }
        }
        System.out.println("Total matching activities in Sport category: " + sportsCount);
        System.out.println();


        System.out.println("--------- Task 4 ---------");
        System.out.println("Activities that require a check-in:");
        int checkInCount = 0;

        // Display activities that require check-in
        for (Activities activity : activitiesList) {
            if (activity.getRequiresCheckIn()) {
                System.out.println("Activity - " + activity.getId() + " " + activity.getName());
                checkInCount++;
            }
        }
        System.out.println("Total number of activities that required a check-in: " + checkInCount);
        System.out.println();


        System.out.println("--------- Task 5 ---------");
        System.out.println("Activities that require a check-in but no competition:");
        int checkInNoCompetitionCount = 0;
        for (Activities activity : activitiesList) {
            if (activity.getRequiresCheckIn() && !activity.getHasCompetition()) {
                System.out.println("Activity - " + activity.getId() + " " + activity.getName());
                checkInNoCompetitionCount++;
            }
        }
        System.out.println("Total number of activities that required a check-in but without competition: " + checkInNoCompetitionCount);
        System.out.println();


        ArrayList<Students> enrolledStudents = new ArrayList<>();

        // 2. Add Students and their details
        enrolledStudents.add(new Students("1105236", "Amy", "Sheffield", "PN"));
        enrolledStudents.add(new Students("1235894", "Victoria", "Jensen", "PN"));
        enrolledStudents.add(new Students("7225669", "James", "Lee", "PN"));
        enrolledStudents.add(new Students("1328991", "Colin", "Delmont", "PN"));
        enrolledStudents.add(new Students("1562347", "Thomas", "Becker", "Auckland"));
        enrolledStudents.add(new Students("5664789", "Steven", "Hobbs", "Auckland"));
        enrolledStudents.add(new Students("3658947", "Andrew", "Jackson", "Auckland"));
        enrolledStudents.add(new Students("6332698", "Jonathon", "Wood", "Auckland"));
        enrolledStudents.add(new Students("2455897", "Emma", "Smith", "Auckland"));
        Students me = new Students("26017361", "Subrota", "Debnath", "Auckland");
        enrolledStudents.add(me);


        Random random = new Random();

        for (Students student : enrolledStudents) {
            // Generates a random integer from 0 (inclusive) to 4 (exclusive). Adds 1 to the generated number refers 1-4
            int numberOfActivities = random.nextInt(4) + 1;
            // Pick a random activity from the available activities list
            while (student.getRegisteredList().size() < numberOfActivities) {
                Activities activity = activitiesList.get(random.nextInt(activitiesList.size()));
                String mode = "";
                // Check if the activity supports the student's campus location or online
                boolean hasCampus = activity.getMode().contains(student.getCampus());
                boolean hasOnline = activity.getMode().contains("Online");

                if (hasCampus && hasOnline) {
                    // Activity supports both modes — randomly assign one
                    mode = random.nextBoolean() ? student.getCampus() : "Online";
                } else if (hasCampus) {
                    // Activity is only available at the student's campus
                    mode = student.getCampus();
                } else if (hasOnline) {
                    // Activity is only available online
                    mode = "Online";
                }
                // Only proceed if a valid mode was found for this student
                if (!mode.equalsIgnoreCase("")) {
                    // Check if the student has already registered for this activity to avoid duplicates
                    boolean alreadyRegistered = false;
                    for (RegisteredActivities ra : student.getRegisteredList()) {
                        if (ra.getActivity().equals(activity)) {
                            alreadyRegistered = true;
                            break;
                        }
                    }
                    // Register the activity only if the student hasn't already signed up for it
                    if (!alreadyRegistered) {
                        student.addRegisteredActivity(new RegisteredActivities(activity, mode));
                    }
                }
            }
        }


        System.out.println("--------- Task 6 ---------");
        System.out.println("ALL students registered:");
        for (Students st : enrolledStudents) {
            System.out.println("Student[" + st.getId() + "]: " + st.getFirstName() + " " + st.getLastName() + " (" + st.getCampus() + ")");

            for (RegisteredActivities regAct : st.getRegisteredList()) {
                System.out.println(" - " + regAct.getActivity().getName()+ " [" + regAct.getActivity().getId() + "]"+ "   -   Mode: "+ regAct.getSelectedMode());
            }
            System.out.println();
        }


        System.out.println("--------- Task 7 ---------");
        System.out.println("Activities that I select:");

        ArrayList<RegisteredActivities> myActs = me.getRegisteredList();
        for (RegisteredActivities rAct : myActs) {
            System.out.println("Activity selection - "+ rAct.getActivity().getName()+ " [" + rAct.getActivity().getId() + "]    "+ rAct.getSelectedMode()+ "    Student: "+ me.getFirstName() + " "+ me.getLastName()+ " [" + me.getId() + "]");
        }
        System.out.println("The number of activities that I selected: " + myActs.size());
        System.out.println();


        System.out.println("--------- Task 8 ---------");
        System.out.println("Students who are based at Auckland and select A106 (Hiking Group):");
        ArrayList<String> hikingGrp = new ArrayList<>();
        // Iterate through all enrolled students to find eligible hiking group members
        for (Students stud : enrolledStudents) {
            // Filter to only include students based at the Auckland campus
            if (stud.getCampus().equals("Auckland")) {
                // Check through the student's registered activities for the hiking activity
                for (RegisteredActivities regLst : stud.getRegisteredList()) {
                    // If the student is registered for activity A106 (Hiking), add them to the group
                    if (regLst.getActivity().getId().equals("A106")) {
                        hikingGrp.add(stud.getFirstName() + " " + stud.getLastName());
                        break;
                    }
                }
            }
        }

        System.out.print("Student's Name: ");
        if (hikingGrp.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.print("[");
            for (int n = 0; n < hikingGrp.size(); n++) {
                System.out.print(hikingGrp.get(n));
                if (n < hikingGrp.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("The number of students based in Auckland who have selected A106: " + hikingGrp.size());
    }
}
