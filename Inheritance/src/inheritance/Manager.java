package inheritance;

public class Manager extends Employee {

    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public double getCompensation() {
        return getSalary() + getSalary() * 0.1;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + this.department;
    }
}
