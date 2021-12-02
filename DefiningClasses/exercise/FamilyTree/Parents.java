package DefiningClasses.exercise.FamilyTree;

public class Parents {
    private String firstname;
    private String lastname;
    private String birthday;

    public Parents(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
//        this.birthday = "n/a";
    }

    public Parents(String birthday) {
//        this.firstname = "n/a";
//        this.lastname = "n/a";
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
