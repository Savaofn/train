package humans;

public class Driver extends User {
    private License license;

    public Driver(String id, String firstName, String lastName, int age, License license) {
        super(id, firstName, lastName, age);
        this.license = license;
    }

    public License getLicense() {
        return license;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Humans.License: " + license + "\n";
    }
}
