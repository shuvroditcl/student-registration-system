import java.util.ArrayList;

public class Students {
    private String id;
    private String firstName;
    private String lastName;
    private String campus;
    private ArrayList<RegisteredActivities> registeredActList;

    public Students(String sId, String fName, String lName, String camp) {
        this.id = sId;
        this.firstName = fName;
        this.lastName = lName;
        this.campus = camp;
        this.registeredActList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {this.campus = campus;}

    public ArrayList<RegisteredActivities> getRegisteredList() {
        return registeredActList;
    }

    public void setRegisteredList(ArrayList<RegisteredActivities> registeredActList) {
        this.registeredActList = registeredActList;
    }

    public void addRegisteredActivity(RegisteredActivities ra) {
        this.registeredActList.add(ra);
    }
}
