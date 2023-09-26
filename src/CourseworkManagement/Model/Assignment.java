package CourseworkManagement.Model;

import java.util.ArrayList;

public class Assignment {
    public ArrayList<Question> assignmentQuestions;
    public double possibleScore;
    public double earnedScore;

    /**
     * Returns the total possible score for this assignment
     * @return Double representation of the total possible score for this assignment
     */
    public double getPossibleScore() {
        return possibleScore;
    }

    /**
     * Sets total possible score for this assignment
     * @param totalScore Sets the total possible score for this assignment
     */
    public void setPossibleScore(double totalScore) {
        this.possibleScore = totalScore;
    }

    /**
     * Returns the total earned score for this assignment
     * @return Double representation of the total earned score for this assignment
     */
    public double getEarnedScore() {
        return earnedScore;
    }

    /**
     * Sets the total earned score for this assignment
     * @param userScore Sets the total earned score for this assignment
     */
    public void setEarnedScore(double userScore) {
        this.earnedScore = userScore;
    }

    /**
     * Grade assignment and post grade
     */
    public void gradeAssignment() {}
}
