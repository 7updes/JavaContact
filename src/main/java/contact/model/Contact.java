package contact.model;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Alex on 09.03.2015.
 */
public class Contact {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<Hobby> hobbies;
    private Set<Place> places;

//    public Contact(String firstName, String lastName, LocalDate birthDate) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.birthDate = birthDate;
//    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {

        this.birthDate = birthDate;
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
