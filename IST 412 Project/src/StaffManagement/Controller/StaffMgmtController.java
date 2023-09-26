package StaffManagement.Controller;

import StaffManagement.View.StaffMgmtInterface;
import UserAuthentication.User;

public class StaffMgmtController {
    public StaffMgmtInterface si;

    /**
     * Constructor for the staff management interface
     * @param u1 Staff user profile to be managed through interface
     */
    public StaffMgmtController(User u1) {
        this.si = new StaffMgmtInterface();
    }
}
