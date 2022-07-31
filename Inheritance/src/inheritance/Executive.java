package inheritance;

public class Executive extends Manager {

    public Executive(String name, double salary, String department) {
        super(name, salary, department);
    }

    public double getCompensation() {
        return getSalary() + (getSalary() * 0.3);
    }

    public String toString() {
        return super.toString();
    }
}
