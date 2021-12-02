package DefiningClasses.exercise.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class PersonFamilyTree {
    public static class Parents {
        private String firstname;
        private String lastname;
        private String birthday;

        public Parents(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public Parents(String birthday) {
            this.birthday = birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            if (this.firstname != null && this.birthday != null) {
                return String.format("%s %s %s", this.firstname, this.lastname, this.birthday);
            } else if (this.firstname != null) {
                return String.format("%s %s", this.firstname, this.lastname);
            } else {
                return String.format("%s", this.birthday);
            }
        }
    }

    public static class Children {
        private String firstname;
        private String lastname;
        private String birthday;

        public Children(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public Children(String birthday) {
            this.birthday = birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            if (this.firstname != null && this.birthday != null) {
                return String.format("%s %s %s", this.firstname, this.lastname, this.birthday);
            } else if (this.firstname != null) {
                return String.format("%s %s", this.firstname, this.lastname);
            } else {
                return String.format("%s", this.birthday);
            }
        }
    }

    private String firstname;
    private String lastname;
    private String birthday;
    private List<Parents> parents;
    private List<Children> children;

    public PersonFamilyTree(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
//        this.birthday = "n/a";
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public PersonFamilyTree(String birthday) {
//        this.firstname = "n/a";
//        this.lastname = "n/a";
        this.birthday = birthday;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
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

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        if (this.firstname != null && this.birthday != null) {
            return String.format("%s %s %s", this.firstname, this.lastname, this.birthday);
        } else if (this.firstname != null) {
            return String.format("%s %s", this.firstname, this.lastname);
        } else {
            return String.format("%s", this.birthday);
        }
    }
}
