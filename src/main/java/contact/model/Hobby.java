package contact.model;

/**
 * Created by Alex on 09.03.2015.
 */
public class Hobby {

    private int id;
    private String title;
    private String description;

    public Hobby(String title) {
        this.title = title;
    }

    public Hobby(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Hobby(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;


        Hobby hobby = (Hobby) o;

        if (description != null ? !description.equals(hobby.description) : hobby.description != null) return false;
        if (title != null ? !title.equals(hobby.title) : hobby.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
