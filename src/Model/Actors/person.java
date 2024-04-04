package Model.Actors;

public class person {
    private static int personCount = 0;
    int personID;
    String name;

    public person() {
        personCount++;
        this.setPersonID(personCount);
    }
    public person(String name) {
        personCount++;
        this.setPersonID(personCount);
        this.setName(name);
    }

    public person(int personID,String name) {
        personCount++;
        this.setPersonID(personCount);
        this.setName(name);
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Person ID: " + getPersonID());
        System.out.println("Actors Name: " + getName());
    }
}