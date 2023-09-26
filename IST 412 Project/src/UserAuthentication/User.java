package UserAuthentication;

public class User {
    private String loginID;
    private String password;
    private String userNum;
    private String userName;
    public String roleID;

    /**
     * Constructor for User class
     * @param userLogin given username for User
     * @param userPassword given password for User
     */
    public User(String userLogin, String userPassword, String roleId) {
        this.loginID = userLogin;
        this.password = userPassword;
        this.roleID = roleId;
    }

    /**
     * Returns username for this User
     * @return String representing the username for the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Verify a user profile exists
     * @param loginName given username to verify
     * @param loginPassword given password to verify
     */
    public void verifyUser(String loginName, String loginPassword) {}

    /**
     * Change password linked to User profile
     * @param loginName Given username to change password on
     * @param userPassword New password to set to user account.
     */
    public void changePassword(String loginName, String userPassword) {}
}
