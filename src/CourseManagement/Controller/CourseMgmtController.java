package CourseManagement.Controller;

import CourseManagement.Model.Course;
import CourseManagement.View.CourseMgmtInterface;

public class CourseMgmtController {
    public CourseMgmtInterface ci;

    /**
     * Constructor for Course Management Interface
     * @param c1 Selected course to be managed through interface.
     */
    public CourseMgmtController(Course c1) {
        this.ci = new CourseMgmtInterface();
    }
}
