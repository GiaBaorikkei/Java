package entity;

public abstract class Person {
    protected String name;
    protected int age;
    protected String address;
    protected String phone;
    protected String email;
    protected Sex sex;

    public enum Sex {
        MALE, FEMALE, OTHER
    }

    // Getters and setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}