public class RegisteredActivities {
    private Activities activity;
    private String activityMode;

    public RegisteredActivities(Activities a, String mode) {
        this.activity = a;
        this.activityMode = mode;
    }

    public Activities getActivity() {
        return activity;
    }

    public void setActivity(Activities activity) {
        this.activity = activity;
    }

    public String getSelectedMode() {
        return activityMode;
    }

    public void setSelectedMode(String activityMode) {
        this.activityMode = activityMode;
    }
}
