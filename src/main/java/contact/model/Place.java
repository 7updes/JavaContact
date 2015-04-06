package contact.model;

/**
 * Created by Alex on 09.03.2015.
 */
public class Place {
    private String title;
    private String description;

    public Place(String title) {
        this.title = title;
    }

    public Place(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
