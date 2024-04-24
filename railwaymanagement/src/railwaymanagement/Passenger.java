
package railwaymanagement;


public class Passenger {
    private String name;
    private int age;
    private int contact;

public Passenger(String name, int age,int contact ) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
     public int getcontact() {
        return contact;
    } 
}
