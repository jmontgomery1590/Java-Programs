package CourseworkManagement.Model;

public class Question {
    public String desc;
    public String answer;
    public String response;
    public double pointValue;

    /**
     * Returns the user response for this assignment
     * @return String representation of the user response for this assignment
     */
    public String getResponse() {
        return this.response;
    }

    /**
     * Compares user response against the answer to check for correct answer
     * @param userResponse User response given for this question
     * @param Answer Actual answer for this question
     */
    public void checkResponse(String userResponse, String Answer) {}
}
