package humans;

public abstract class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private int age;


    public User(String id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getInfo() {
        return "Id: " + id + " FirstName: " + firstName + " LastName: " + lastName + " Age: " + age;
    }
}
