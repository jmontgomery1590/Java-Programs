package Abstract;

public class App {

    public static void main(String[] args) {
        var people = new Person[6];

        people[0] = new Employee("Lily Aldrin", 50000, 2005, 10, 1);
        people[1] = new Employee("Robin Scherbatsky", 85000, 2006, 6, 15);
        people[2] = new Employee("Barney Stinson", 1500000, 2003, 7, 12);
        people[3] = new Student("Marshall Erikson", "pre-law");
        people[4] = new Student("Justin Montgomery", "cyber security");
        people[5] = new Student("Ted Mosby", "architecture");

        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }
}
