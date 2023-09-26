package StudentManagement;

import CourseManagement.Model.Course;
import UserAuthentication.User;
import java.util.ArrayList;

public class Student extends User {
    private String major;
    private ArrayList<Course> enrolledCourses;

    /**
     * Super constructor for Student User class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param roleID Given user role for user
     */
    public Student(String userLogin, String userPassword, String roleID) {
        super(userLogin, userPassword, roleID);
    }

    /**
     * Constructor for Student class
     * @param userLogin Given login username for authentication
     * @param userPassword Given login password for authentication
     * @param roleID Given user role for user
     * @param userMajor Student's major area of study
     */
    public Student(String userLogin, String userPassword, String roleID, String userMajor) {
        super(userLogin, userPassword, roleID);
        this.major = userMajor;
    }

    /**
     * Returns an ArrayList of the enrolled courses
     * @return ArrayList representation of given courses
     */
    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Register for a course to enroll in
     * @param course Given course to register for
     */
    public void registerCourse(Course course) {
        this.enrolledCourses.add(course);
    }
}
