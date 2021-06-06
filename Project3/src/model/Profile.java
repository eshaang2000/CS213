package model;

/**
 *  Class to define profile of an account holder.
 *  @author Shankar Kohli, Eshaan Gandhi
 */

public class Profile {

    private String fname;
    private String lname;

    /**
     Constructor to make Student object
     @param fname first name of the Student
     @param lname last name of the Student
     */
    public Profile(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    /**
     * Getter method for First Name (fname)
     *
     * @return fname
     */
    public String getFirstName() {
        return fname;
    }

    /**
     * Getter method for Last Name (lname)
     *
     * @return lname
     */
    public String getLastName() {
        return lname;
    }

    @Override
    /**
     * Equals method to compare Profiles/account holder
     * @param  obj, object
     * @return boolean value, true or false
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Profile holder = (Profile) obj;

        if (holder.getFirstName().equals(this.fname)) {
            if (holder.getLastName().equals(this.lname)) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param obj accountDatabase.Profile to be compared
     * @return -1 if accountDatabase.Profile is alphabetically less, 0 if equal, and 1 if accountDatabase.Profile is alphabetically greater
     */
    public int compareTo(Object obj) {

        Profile holder = (Profile) obj;
        if (holder.getLastName().compareTo(this.lname) > 0) {
            return -1;
        } else if (holder.getLastName().compareTo(this.lname)<0) {
            return 1;
        }

        return 0;
    }

    @Override
    /**
     * Coverts the object to a string
     * @return String of the profile
     */
    public String toString(){
        String ans = this.fname+" "+this.lname;
        return ans;
    }

}