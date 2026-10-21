import java.util.ArrayList;

public class Activities {
    private String id;
    private String name;
    private String category;
    private String timeSlot;
    private boolean requiresCheckIn;
    private boolean hasCompetition;
    private ArrayList<String> mode;

    public Activities(String actId, String actName, String actCat, String time, boolean checkIn, boolean comp, ArrayList<String> modeList) {
        this.id = actId;
        this.name = actName;
        this.category = actCat;
        this.timeSlot = time;
        this.requiresCheckIn = checkIn;
        this.hasCompetition = comp;
        this.mode = modeList;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {this.category = category;}

    public String getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(String timeSlot) {this.timeSlot = timeSlot;}

    public boolean getRequiresCheckIn() {
        return requiresCheckIn;
    }
    public void setRequiresCheckIn(boolean requiresCheckIn) {this.requiresCheckIn = requiresCheckIn;}

    public boolean getHasCompetition() {
        return hasCompetition;
    }
    public void setHasCompetition(boolean hasCompetition) {this.hasCompetition = hasCompetition;}

    public ArrayList<String> getMode() {
        return mode;
    }
    public void setMode(ArrayList<String> mode) {this.mode = mode;}
}
