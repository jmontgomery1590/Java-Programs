package StaffManagement.Model;

import CourseManagement.Model.Course;
import CourseworkManagement.Model.Assignment;
import UserAuthentication.User;

import java.util.ArrayList;

public class Instructor extends User {
    public ArrayList<Course> coursesTeaching;

    /**
     * Super constructor for Instructor User class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param roleID Given user role for user
     */
    public Instructor(String userLogin, String userPassword, String roleID) {
        super(userLogin, userPassword, roleID);
    }
    /**
     * Constructor for Instructor class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param userRole Given user role for user
     * @param teaching courses actively teaching
     */
    public Instructor(String userLogin, String userPassword, String userRole, ArrayList<Course> teaching) {
        super(userLogin, userPassword, userRole);
        this.coursesTeaching = teaching;
    }

    /**
     * Grade uploaded assignment.
     * @param a1 Assignment to be graded
     */
    public void gradeAssignment(Assignment a1) {}

    /**
     * Assign TA user role
     */
    public void assignTA() {}

    /**
     * Edit chosen course
     * @param c1 Course to be edited
     */
    public void editCourse(Course c1) {}
}
