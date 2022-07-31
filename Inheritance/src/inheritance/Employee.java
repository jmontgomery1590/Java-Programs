package inheritance;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary(){
        return this.salary;
    }

    public double getCompensation() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nSalary: $" + this.salary;
    }
}
