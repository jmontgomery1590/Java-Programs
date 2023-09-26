package StudentManagement;

import UserAuthentication.User;

public class StudentMgmtController {
    public StudentMgmtInterface si;

    /**
     * Constructor for the user management interface
     * @param u1 Student user profile to be managed through interface
     */
    public StudentMgmtController (User u1) {
        this.si = new StudentMgmtInterface();
    }
}
