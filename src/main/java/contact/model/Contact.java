package contact.model;


import javax.persistence.*;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.*;

/**
 * Created by Alex on 09.03.2015.
 */
@Entity
@Table(name = "contact")
public class Contact {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "id")
    private int id ;


    private Set<Hobby> hobbies = new HashSet<Hobby>();
    private Set<Place> places = new HashSet<Place>();
    private List<Contact> friends = new ArrayList<Contact>();
    private List<Message> allConversation = new ArrayList<Message>();


    public Contact() {
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Contact(int id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public List<Message> getAllConversation() {
        return allConversation;
    }

    public List<Contact> getFriends() {
        return friends;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setBirthDate(Date birthDate) {

        this.birthDate=birthDate;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobby hobby) {
        hobbies.add(hobby);
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setFriends(Contact friend) {
        friends.add(friend);
    }

    public void setPlaces(Place place) {
        places.add(place);
    }

    public void setConversation(Message conversation) {
        allConversation.add(conversation) ;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", hobbies=" + hobbies +
                ", places=" + places +
                ", friends=" + friends +
                '}'+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(contact.birthDate) : contact.birthDate != null) return false;
        if (hobbies != null ? !hobbies.equals(contact.hobbies) : contact.hobbies != null) return false;
        if (places != null ? !places.equals(contact.places) : contact.places != null) return false;
        if (friends != null ? !friends.equals(contact.friends) : contact.friends != null) return false;
        return !(allConversation != null ? !allConversation.equals(contact.allConversation) : contact.allConversation != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (hobbies != null ? hobbies.hashCode() : 0);
        result = 31 * result + (places != null ? places.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (allConversation != null ? allConversation.hashCode() : 0);
        return result;
    }
}
