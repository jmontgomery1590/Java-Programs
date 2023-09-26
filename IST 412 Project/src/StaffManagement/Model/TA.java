package StaffManagement.Model;

import CourseManagement.Model.Course;
import CourseworkManagement.Model.Assignment;
import UserAuthentication.User;

import java.util.ArrayList;

public class TA extends User {
    public ArrayList<Course> coursesTutored;

    /**
     * Super constructor for TA User class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param roleID Given user role for user
     */
    public TA(String userLogin, String userPassword, String roleID) {
        super(userLogin, userPassword, roleID);
    }

    /**
     * Constructor for TA class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param roleID Given user role for user
     * @param tutoring Courses actively tutoring students in
     */
    public TA(String userLogin, String userPassword, String roleID, ArrayList<Course> tutoring) {
        super(userLogin, userPassword, roleID);
        this.coursesTutored = tutoring;
    }

    /**
     * Grade uploaded assignment.
     * @param a1 Assignment to be graded
     */
    public void gradeAssignment(Assignment a1) {}
}
