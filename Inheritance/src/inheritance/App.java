package inheritance;

public class App {

    public static void main(String[] args) {
	    Employee employee1 = new Employee("Harry", 40000);
	    Manager employee2 = new Manager("Ron", 80000, "Sales");
	    Executive employee3 = new Executive("Hermione", 120000, "Regional VP");

	    System.out.println("Employee Info: ");
	    System.out.println(employee1);
	    System.out.println();
	    System.out.println(employee2);
	    System.out.println();
	    System.out.println(employee3);

	    System.out.println("\nCompensation Info: ");
	    System.out.printf("Compensation for employee 1: $%.2f\n", employee1.getCompensation());
        System.out.printf("Compensation for employee 2: $%.2f\n", employee2.getCompensation());
        System.out.printf("Compensation for employee 3: $%.2f\n", employee3.getCompensation());
    }
}
