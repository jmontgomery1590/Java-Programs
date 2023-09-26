package CourseManagement.Model;

public class Page {
    private String pageTitle;
    private String pageBody;

    /**
     * Constructor for the Page class
     * @param title Title for the page
     * @param body Content for the page
     */
    public Page (String title, String body) {
        this.pageTitle = title;
        this.pageBody = body;
    }
}
