package UserAuthentication;

public class LoginInterface {

    public LoginInterface() {}

    public User Login() {
        String login = "login";
        String password = "password";
        User u = new User(login, password);
        return u;
    }
}
