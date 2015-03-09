package contact;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Alex on 09.03.2015.
 */
public class Contact {
    private String firstName;
    private String lastName;
    private static LocalDate birthDate;
    private Set<Hobby> hobbies;
    private Set<Place> places;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static LocalDate getBirthDate() {
        return birthDate;
    }

    public static void setBirthDate(LocalDate birthDate) {
        Contact.birthDate = birthDate;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Place> getPlaces() {
        return places;
    }
    public void setPlaces(Set<Place> places) {
        this.places = places;
    }


}
