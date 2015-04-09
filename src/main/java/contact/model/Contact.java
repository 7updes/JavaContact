package contact.model;


import java.util.*;

/**
 * Created by Alex on 09.03.2015.
 */
public class Contact {
    private String firstName;
    private String lastName;
    private Date birthDate;
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

    public void setConversation(Message conversation) {
       allConversation.add(conversation) ;
    }

    public List<Contact> getFriends() {
        return friends;
    }

    public void setFriends(Contact friend) {
        friends.add(friend);
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

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
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
}
