package StaffManagement.Model;

import CourseManagement.Model.Course;
import UserAuthentication.User;

import java.util.ArrayList;

public class Admin extends User {
    ArrayList<Instructor> instructorsOverseen;
    ArrayList<Course> masterCourseList;

    /**
     * Super constructor for Admin User class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param roleID Given user role for user
     */
    public Admin(String userLogin, String userPassword, String roleID) {
        super(userLogin, userPassword, roleID);
    }

    /**
     * Constructor for Admin class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param roleID Given user role for user
     * @param overseen List of instructors overseen
     */
    public Admin(String userLogin, String userPassword, String roleID, ArrayList<Instructor> overseen) {
        super(userLogin, userPassword, roleID);
        this.instructorsOverseen = overseen;
    }

    /**
     * Set user role
     * @param id Role ID level to assign to user.
     */
    public void setRoleID(User u1, String id) {
        this.roleID = id;
    }

    /**
     * Assign instructor to given course
     * @param courseId Course id to assign instructor to
     * @param i1 Instructor to be assigned to course
     */
    public void assignCourseInstructor(String courseId, Instructor i1) {}


}
