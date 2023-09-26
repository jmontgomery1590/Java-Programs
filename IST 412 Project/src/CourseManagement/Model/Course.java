package CourseManagement.Model;

public class Course {
    private String courseID;
    private String courseName;
    private int maxEnrolled;

    public Course(String id, String coursename, int maxenrolled) {
        this.courseID = id;
        this.courseName = coursename;
        this.maxEnrolled = maxenrolled;
    }

    /**
     * Create new course
     * @param c1 Course to be created
     */
    public void createCourse(Course c1) {}

    /**
     * Adds a new page to the course
     * @param courseId course to add the page to
     * @param p1 page to be added to the course
     */
    public void addPage(String courseId, Page p1) {}

    /**
     * Returns the course name for this course
     * @return String representing the name for the course.
     */
    public String getCourseName() {
        return this.courseName;
    }
}
